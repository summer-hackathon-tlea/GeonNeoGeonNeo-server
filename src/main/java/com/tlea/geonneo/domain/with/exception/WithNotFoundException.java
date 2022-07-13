package com.tlea.geonneo.domain.with.exception;

import com.tlea.geonneo.global.error.exception.ErrorCode;
import com.tlea.geonneo.global.error.exception.GeonneoGeonneoException;

public class WithNotFoundException extends GeonneoGeonneoException {

    public final static GeonneoGeonneoException EXCEPTION = new WithNotFoundException();

    private WithNotFoundException() {
        super(ErrorCode.WITH_NOT_FOUND);
    }
}
