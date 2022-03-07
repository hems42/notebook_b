package com.notebook_b.org.product.security.jwt_security;

import static com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages.*;
import static com.notebook_b.org.product.appConstants.AppConstants.TOKEN_ALGORITHM_KEY;

import com.notebook_b.org.core.exceptions.exceptionModel.NotFoundException;
import com.notebook_b.org.core.exceptions.exceptionModel.NotValidException;
import com.notebook_b.org.core.exceptions.exceptionModel.UnSuccessfulException;
import com.notebook_b.org.product.appConstants.AppConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class JwtTokenManager {

    private final String logTitle = "JwtTokenManager : -> ";

    public String generateToken(String username) {

        Long createdDate = System.currentTimeMillis();

        Long expirationDate = createdDate + AppConstants.ACCESS_TOKEN_EXPERIMENT_TIME;

        String accessToken = Jwts.builder()
                .setSubject(username)
                .setIssuer(AppConstants.TOKEN_ISSUER)
                .setIssuedAt(new Date(createdDate))
                .setExpiration(new Date(expirationDate))
                .signWith(TOKEN_ALGORITHM_KEY)
                .compact();

        if (accessToken != null) {
            log.info("access token created with username");
            return accessToken;
        } else {
            log.error(logTitle + "access token not created with username");

            throw new UnSuccessfulException(UN_SUCCESSFUL_ACCESS_TOKEN_CREATE, "access token not created with username");
        }
    }

    public Boolean validateToken(String token) {
        return getUserNameFromToken(token) != null && isNotExpired(token);
    }

    public String getUserNameFromToken(String token) throws NotFoundException {

        String userName = getClaims(token).getSubject();

        if (userName != null) {

            log.info(logTitle + "username fetched by access token");

            return userName;

        } else {

            log.error("not found username with find by token");

            throw new NotFoundException(NOT_FOUND_ACCESS_TOKEN_USERNAME, "");
        }
    }

    private Claims getClaims(String token) {

        log.info(logTitle + " jwt claims fetched by token");

        return Jwts.parserBuilder().setSigningKey(TOKEN_ALGORITHM_KEY).build().parseClaimsJws(token).getBody();
    }

    public Boolean isNotExpired(String token) throws NotValidException, NotFoundException {
        Claims claims = getClaims(token);

        if (claims != null) {
            if (claims.getExpiration().after(new Date(System.currentTimeMillis()))) {

                log.info(logTitle + "access token is is expire");

                return true;

            } else {

                log.error(logTitle + "access token is expired");

                throw new NotValidException(NOT_VALID_ACCESS_TOKEN_EXPIRED, "");
            }
        } else {

            log.error(logTitle + "access token not found");

            throw new NotFoundException(NOT_FOUND_ACCESS_TOKEN, "");
        }

    }
}
