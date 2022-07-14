package com.tlea.geonneo.domain.notification.exception;

import com.tlea.geonneo.global.error.exception.ErrorCode;
import com.tlea.geonneo.global.error.exception.GeonneoGeonneoException;

public class NotificationNotFoundException extends GeonneoGeonneoException {

    public final static GeonneoGeonneoException EXCEPTION = new NotificationNotFoundException();

    private NotificationNotFoundException() {
        super(ErrorCode.NOTIFICATION_NOT_FOUND);
    }
}
