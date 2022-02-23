package com.notebook_b.org.security.jwt_security;

import com.notebook_b.org.core.constants.appConstant.AppConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtTokenManager {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    public String generateToken(String username) {
        Long createdDate=System.currentTimeMillis();
        Long expirationDate=createdDate + AppConstants.TOKEN_EXPERIMENT_TIME;
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("notebook_b")
                .setIssuedAt(new Date(createdDate))
                .setExpiration(new Date(expirationDate))
                .signWith(key)
                .compact();
    }


    public Boolean validateToken(String token) {
        return (getUserNameFromToken(token) != null && isExpired(token));
    }


    public String getUserNameFromToken(String token) {
        return getClaims(token).getSubject();
    }



    private Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }
}
