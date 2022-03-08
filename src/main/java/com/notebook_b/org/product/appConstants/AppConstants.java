package com.notebook_b.org.product.appConstants;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class AppConstants {

   public static final Integer ACCESS_TOKEN_EXPERIMENT_TIME = 30 * 60 * 1000;

   public static final String TOKEN_ISSUER = "notebook_b";

   public static final String AUTH_HEADER = "Authorization";

   public static final String TOKEN_START_WITH ="Bearer ";

   public static final String MAIL_SEND_LINK = "http://localhost:8080/api/authentication/registration?confirmToken=";

   public static final SecretKey TOKEN_ALGORITHM_KEY =Keys.secretKeyFor(SignatureAlgorithm.HS256);

   public static Long REFRESH_TOKEN_EXPERIMENT_TIME = 3 * 86400000l; // DAY

   public static Long CONFIRMATION_TOKEN_EXPERIMENT_TIME = 15l; // MINUTE

}
