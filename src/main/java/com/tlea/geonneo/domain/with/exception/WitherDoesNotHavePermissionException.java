package com.tlea.geonneo.domain.with.exception;

import com.tlea.geonneo.global.error.exception.ErrorCode;
import com.tlea.geonneo.global.error.exception.GeonneoGeonneoException;

public class WitherDoesNotHavePermissionException extends GeonneoGeonneoException {

    public final static GeonneoGeonneoException EXCEPTION = new WitherDoesNotHavePermissionException();

    private WitherDoesNotHavePermissionException() {
        super(ErrorCode.WITHER_DOES_NOT_HAVE_PERMISSION);
    }
}
