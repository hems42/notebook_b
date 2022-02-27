package com.notebook_b.org.core.exceptions.exceptionModel;

import com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants;
import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import org.springframework.http.HttpStatus;

import static com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants.*;

public class UnSuccessfulException extends BaseExceptionModel {
    public UnSuccessfulException(CoreEnumExceptionMessages coreEnumExceptionMessages,
                                 String errorDescription) {
        super(coreEnumExceptionMessages,
                UN_SUCCESFUL_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.NOT_ACCEPTABLE);
    }
}
