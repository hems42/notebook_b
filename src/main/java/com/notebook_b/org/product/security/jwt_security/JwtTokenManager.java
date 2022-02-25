package com.notebook_b.org.product.security.jwt_security;

import com.notebook_b.org.product.appConstants.AppConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenManager {



    public String generateToken(String username) {
        Long createdDate=System.currentTimeMillis();
        Long expirationDate=createdDate + AppConstants.TOKEN_EXPERIMENT_TIME;
        return Jwts.builder()
                .setSubject(username)
                .setIssuer(AppConstants.TOKEN_ISSUER)
                .setIssuedAt(new Date(createdDate))
                .setExpiration(new Date(expirationDate))
                .signWith(AppConstants.TOKEN_ALGORITHM_KEY)
                .compact();
    }


    public Boolean validateToken(String token) {
        return (getUserNameFromToken(token) != null && isExpired(token));
    }


    public String getUserNameFromToken(String token) {
        return getClaims(token).getSubject();
    }



    private Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(AppConstants.TOKEN_ALGORITHM_KEY).build().parseClaimsJws(token).getBody();
    }

    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }
}
