package com.notebook_b.org.product.appConstants;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class AppConstants {

   public static final Integer TOKEN_EXPERIMENT_TIME = 3 * 60 * 1000;

   public static final String TOKEN_ISSUER = "notebook_b";

   public static final String AUTH_HEADER = "Authorization";

   public static final String TOKEN_START_WITH ="Bearer ";

   public static final SecretKey TOKEN_ALGHORITHMA_KEY=Keys.secretKeyFor(SignatureAlgorithm.HS256);

}
