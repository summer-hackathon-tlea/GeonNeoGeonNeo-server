package com.tlea.geonneo.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다."),
    BAD_REQUEST(400, "잘못된 요청입니다."),

    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),
    USER_ALREADY_EXISTS(422, "사용자가 이미 존재합니다."),
    PASSWORD_MISMATCH(401, "비밀번호가 틀렸습니다."),

    WITH_NOT_FOUND(404, "위드를 찾을 수 없습니다."),
    WITHER_ALREADY_EXISTS(422, "사용자가 이미 위드에 참가했습니다."),
    FULL_WITH(422, "이미 꽉 찬 위드입니다.")
    ;

    private final int status;
    private final String message;
}
