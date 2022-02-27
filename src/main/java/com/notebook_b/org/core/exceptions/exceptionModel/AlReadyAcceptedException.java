package com.notebook_b.org.core.exceptions.exceptionModel;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import org.springframework.http.HttpStatus;

import static com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants.ALREADY_ACCEPTED_EXCEPTION_ERROR_CODE;

public class AlReadyAcceptedException extends BaseExceptionModel {
    public AlReadyAcceptedException(CoreEnumExceptionMessages coreEnumExceptionMessages, String errorDescription) {
        super(coreEnumExceptionMessages,
                ALREADY_ACCEPTED_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.ALREADY_REPORTED);
    }
}
