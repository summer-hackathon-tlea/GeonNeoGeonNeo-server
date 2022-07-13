package com.tlea.geonneo.global.error.exception;

import lombok.Getter;

@Getter
public class GeonneoGeonneoException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;

    public GeonneoGeonneoException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    public GeonneoGeonneoException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
