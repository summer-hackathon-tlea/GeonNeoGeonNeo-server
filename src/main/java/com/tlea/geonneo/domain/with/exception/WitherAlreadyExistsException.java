package com.tlea.geonneo.domain.with.exception;

import com.tlea.geonneo.global.error.exception.ErrorCode;
import com.tlea.geonneo.global.error.exception.GeonneoGeonneoException;

public class WitherAlreadyExistsException extends GeonneoGeonneoException {

    public final static GeonneoGeonneoException EXCEPTION = new WitherAlreadyExistsException();

    private WitherAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
