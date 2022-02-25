package com.notebook_b.org.core.exceptions.abstracts;


import com.notebook_b.org.core.constants.coreEnums.CoreEnumExceptionMessages;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public abstract class BaseExceptionModel extends RuntimeException {
    private Integer errorCode;
    private String errorMessage;
    private String errorDescription;
    private String baseErrorCode;

    private CoreEnumExceptionMessages coreEnumExceptionMessages;

    public BaseExceptionModel(CoreEnumExceptionMessages coreEnumExceptionMessages,
                              String baseErrorCode,
                              String errorDescription) {
        super(errorDescription);
        this.coreEnumExceptionMessages = coreEnumExceptionMessages;
        errorCode = coreEnumExceptionMessages.getExceptionCode();
        errorMessage = coreEnumExceptionMessages.getExceptionMessage();
        this.errorDescription = errorDescription;
        this.baseErrorCode = baseErrorCode;


    }

    public Integer getErrorCode() {
        return convertToSuperErrorCode();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    private Integer convertToSuperErrorCode() {
        String foundErrorCode = coreEnumExceptionMessages.getExceptionCode().toString();
        return Integer.parseInt(baseErrorCode + foundErrorCode);
    }


}
