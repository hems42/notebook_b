package com.notebook_b.org.core.exceptions.exceptionModel;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;

public class UnAuthorizeException extends BaseExceptionModel {





    public UnAuthorizeException(CoreEnumExceptionMessages coreEnumExceptionMessages,
                                String errorDescription) {
        super(coreEnumExceptionMessages,"1991",errorDescription);
    }
}
