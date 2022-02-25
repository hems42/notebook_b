package com.notebook_b.org;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.exceptionModel.AlReadyExistException;

public class main {
    public static void main(String[] args) {
     AlReadyExistException exception =
             new  AlReadyExistException(CoreEnumExceptionMessages.USER_ALREADY_EXIST,"user oluşturulmui bea");


        System.out.println(exception.getErrorCode()+"- error code");
        System.out.println(exception.getErrorDescription()+"- error description");
        System.out.println(exception.getErrorMessage()+" -error message");
        System.out.println(exception.getMessage()+"- response mesage");
    }
}
