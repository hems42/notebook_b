package com.notebook_b.org.core.constants.coreEnums;

public enum CoreEnumExceptionMessages {

    /*
    BaseErrorCodeList :
    * -AlReadyExistException : 1991
    * -ForbiddenException : 1992
    * -NotFoundException : 1993
    * -NotAuthenticateException : 1995
    * -NotAuthorizeException : 1996
    * -




    SuperErrorCodeList :

    Role : 1112


    User : 1113


    Note : 1114




     */
    UNAUTHORIZED_REQUEST("UNAUTHORIZED_REQUEST",1996),

    ROLE_ALREADY_EXIST("ALREADY_EXIST_ROLE", 1112),

    USER_ALREADY_EXIST("ALREADY_EXIST_USER",1113);
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

