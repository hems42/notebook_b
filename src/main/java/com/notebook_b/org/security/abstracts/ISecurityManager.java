package com.notebook_b.org.security.abstracts;

public abstract class ISecurityManager implements ISecurityService {

  public abstract String  generateToken(String userName);

  public abstract Boolean validateToken(String token);

  public abstract String getUserNameFromToken(String token);
}
