package com.notebook_b.org.core.exceptions.exceptionModel;

import static com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants.*;
import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import org.springframework.http.HttpStatus;


public class ForbiddenException extends BaseExceptionModel {

    public ForbiddenException(CoreEnumExceptionMessages coreEnumExceptionMessages, String errorDescription) {
        super(coreEnumExceptionMessages,
                FORBIDDEN_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.FORBIDDEN); }
}
