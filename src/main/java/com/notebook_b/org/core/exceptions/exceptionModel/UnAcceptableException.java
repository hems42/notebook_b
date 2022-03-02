package com.notebook_b.org.core.exceptions.exceptionModel;

import com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants;
import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import org.springframework.http.HttpStatus;

public class UnAcceptableException extends BaseExceptionModel {

    public UnAcceptableException(CoreEnumExceptionMessages coreEnumExceptionMessages, String errorDescription) {
        super(coreEnumExceptionMessages,
                CoreExceptionErrorCodeConstants.UN_ACCEPTABLE_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.NOT_ACCEPTABLE);
    }
}
