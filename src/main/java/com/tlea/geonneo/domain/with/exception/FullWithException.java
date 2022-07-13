package com.tlea.geonneo.domain.with.exception;

import com.tlea.geonneo.global.error.exception.ErrorCode;
import com.tlea.geonneo.global.error.exception.GeonneoGeonneoException;

public class FullWithException extends GeonneoGeonneoException {

    public final static GeonneoGeonneoException EXCEPTION = new FullWithException();

    private FullWithException() {
        super(ErrorCode.FULL_WITH);
    }
}
