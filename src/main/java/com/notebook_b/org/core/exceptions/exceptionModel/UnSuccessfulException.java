package com.notebook_b.org.core.exceptions.exceptionModel;

import com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants;
import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;

import static com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants.ALREADY_ACCEPTED_EXCEPTION_ERROR_CODE;
import static com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants.UN_SUCCESSFUL_EXCEPTION_ERROR_CODE;

public class UnSuccessfulException extends BaseExceptionModel {
    public UnSuccessfulException(CoreEnumExceptionMessages coreEnumExceptionMessages,
                                 String errorDescription) {
        super(coreEnumExceptionMessages,UN_SUCCESSFUL_EXCEPTION_ERROR_CODE, errorDescription);
    }
}
