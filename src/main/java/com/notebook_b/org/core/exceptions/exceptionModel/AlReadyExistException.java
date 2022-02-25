package com.notebook_b.org.core.exceptions.exceptionModel;

import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import com.notebook_b.org.core.exceptions.abstracts.BaseExceptionModel;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class AlReadyExistException extends BaseExceptionModel {
    public AlReadyExistException(CoreEnumExceptionMessages coreEnumExceptionMessages, String errorDescription) {
        super(coreEnumExceptionMessages, "1991", errorDescription);
    }
}
