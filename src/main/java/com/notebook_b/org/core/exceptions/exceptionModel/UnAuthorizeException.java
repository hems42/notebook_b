package com.notebook_b.org.core.exceptions.exceptionModel;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import org.springframework.http.HttpStatus;

import static com.notebook_b.org.core.constants.coreConstants.CoreExceptionErrorCodeConstants.UN_AUTHORIZE_EXCEPTION_ERROR_CODE;

public class UnAuthorizeException extends BaseExceptionModel {

    public UnAuthorizeException(CoreEnumExceptionMessages coreEnumExceptionMessages,
                                String errorDescription) {
        super(coreEnumExceptionMessages,
                UN_AUTHORIZE_EXCEPTION_ERROR_CODE,
                errorDescription,
                HttpStatus.UNAUTHORIZED);
    }
}
