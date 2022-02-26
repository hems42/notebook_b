package com.notebook_b.org.core.exceptions.exceptionModel;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;

public class NotValidException extends BaseExceptionModel {
    public NotValidException(CoreEnumExceptionMessages coreEnumExceptionMessages,
                             String errorDescription) {
        super(coreEnumExceptionMessages, "1770", errorDescription);
    }
}
