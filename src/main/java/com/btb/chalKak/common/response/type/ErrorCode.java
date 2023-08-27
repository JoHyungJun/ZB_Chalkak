package com.btb.chalKak.common.response.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    LOAD_USER_FAILED(HttpStatus.UNAUTHORIZED, "회원 정보를 불러오는데 실패했습니다."),

    CONSTRAINT_VIOLATION(HttpStatus.CONFLICT, "제약 조건 위반"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 오류가 발생하였습니다."),

    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    // MEMBER
    ALREADY_EXISTS_EMAIL(HttpStatus.BAD_REQUEST, "이미 사용중인 이메일입니다."),
    ALREADY_EXISTS_NICKNAME(HttpStatus.BAD_REQUEST, "이미 사용중인 닉네임입니다."),

    INVALID_MEMBER_ID(HttpStatus.BAD_REQUEST, "존재하지 않는 회원 번호입니다."),
    INVALID_EMAIL(HttpStatus.BAD_REQUEST, "존재하지 않는 이메일입니다."),

    MISMATCH_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),

    // POST
    INVALID_POST_ID(HttpStatus.BAD_REQUEST, "존재하지 않는 게시글 번호입니다."),
    MISMATCH_WRITER(HttpStatus.BAD_REQUEST, "작성자가 아닙니다."),

    ;

    private final HttpStatus httpStatus;
    private final String message;

}
