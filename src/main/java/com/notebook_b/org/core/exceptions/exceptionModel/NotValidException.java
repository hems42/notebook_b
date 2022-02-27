package com.notebook_b.org.core.exceptions.exceptionModel;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import org.springframework.http.HttpStatus;

import static com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants.NOT_VALID_EXCEPTION_ERROR_CODE;

public class NotValidException extends BaseExceptionModel {
    public NotValidException(CoreEnumExceptionMessages coreEnumExceptionMessages,String errorDescription) {
        super(coreEnumExceptionMessages,
                NOT_VALID_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.NOT_ACCEPTABLE);
    }
}
