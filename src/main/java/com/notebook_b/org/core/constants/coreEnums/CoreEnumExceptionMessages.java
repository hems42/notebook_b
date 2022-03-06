package com.notebook_b.org.core.constants.coreEnums;

public enum CoreEnumExceptionMessages {

    /*
    BaseErrorCodeList :
    * -AlReadyExistException : 1991
    * -ForbiddenException : 1992
    * -NotFoundException : 1993
    * -NotAuthenticateException : 1995
    * -NotAuthorizeException : 1996
    * -NotValidException : 1770




    SuperErrorCodeList :

    Role : 1112


    User : 1113


    Note : 1114

    AccessToken : 1115
    RefreshToken : 1116
    confirmationToken : 1117
     */




    //AUTHENTICATION***
      //REQUEST
    UNAUTHORIZED_REQUEST("UNAUTHORIZED_REQUEST",1996),

    // ACCESS TOKEN
    NOT_VALID_ACCESS_TOKEN_EXPIRED("ACCESS_TOKEN_EXPIRED",1116),
    NOT_FOUND_ACCESS_TOKEN("ACCESS_TOKEN_NOT_FOUND",55),
    NOT_FOUND_ACCESS_TOKEN_USERNAME("ACCESS_TOKEN_USERNAME_NOT_FOUND",55),


    //REFRESH TOKEN
    NOT_VALID_REFRESH_TOKEN_EXPIRED("REFRESH_TOKEN_EXPIRED",1115),
    NOT_FOUND_REFRESH_TOKEN("REFRESH_TOKEN_NOT_FOUND",1116),
    ALREADY_EXIST_REFRESH_TOKEN("REFRESH_TOKEN_ALREADY_EXIST",1117),
    UN_SUCCESSFUL_CREATED_REFRESH_TOKEN("UN_SUCCESSFUL_CREATED_REFRESH",1117),
    UN_SUCCESSFUL_SAVED_REFRESH_TOKEN("UN_SUCCESSFUL_SAVED_REFRESH_TOKEN",1117),
    UN_SUCCESSFUL_DELETED_REFRESH_TOKEN("UN_SUCCESSFUL_DELETED_REFRESH_TOKEN",1117),

    //CONFIRMATION TOKEN
    NOT_VALID_CONFIRMATION_TOKEN_EXPIRED("CONFIRMATION_TOKEN_EXPIRED",1117),
    NOT_FOUND_CONFIRMATION_TOKEN("CONFIRMATION_TOKEN_NOT_FOUND",1118),
    ALREADY_ACCEPTED_CONFIRMATION_TOKEN_CONFIRMED("CONFIRMATION_ALREADY_CONFIRMED",1119),
    UN_SUCCESSFUL_CONFIRMATION_TOKEN("CONFIRMATION_TOKEN_NOT_CONFIRMED",1117),



    //EMAIL
    NOT_VALID_E_MAIL_ADDRESS("E_MAIL_ADDRESS_NOT_VALID",1188),
    NOT_FOUND_E_MAIL_ADDRESS("E_MAIL_ADDRESS_NOT_FOUND",1189),
    ALREADY_ACCEPTED_E_MAIL_ADDRESS("E_MAIL_ADDRESS_ALREADY_ACCEPTED",1189),



    //ENTITY***
      //ROLE
    ALREADY_EXIST_ROLE("ROLE_ALREADY_EXIST", 1112),
    NOT_FOUND_ROLE("ROLE_NOT_FOUND", 1113),
    UN_SUCCESSFUL_CREATED_ROLE("ROLE_NOT CREATED", 1114),



      //USER
    NOT_FOUND_USER("USER_NOT_FOUND",1212),
    ALREADY_EXIST_USER("USER_ALREADY_EXIST",1113),


   //LOGIN
    UN_ACCEPTABLE_LOGIN_REQUEST("LOGIN REQUEST UNACCEPTABLE",1255);























    private String exceptionMessage;
    private Integer exceptionCode;

    CoreEnumExceptionMessages(String exceptionMessage, Integer exceptionCode) {
        this.exceptionMessage = exceptionMessage;
        this.exceptionCode = exceptionCode;
    }

    public void setExceptionCode(Integer exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public Integer getExceptionCode() {
        return exceptionCode;
    }
}

