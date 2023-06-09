package com.projekt.s2e4.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    /**
     * Server Error Message
     */
    CONFLICT_ERROR(HttpStatus.BAD_REQUEST, "예기치 못한 에러가 발생했습니다."),
    INTERNAL_SERVER_ERROR_BY_MAPPER_ERROR(HttpStatus.BAD_REQUEST, "예기치 못한 에러가 발생했습니다."),
    INTERNAL_SERVER_ERROR_BY_PROPERTIES_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예기치 못한 에러가 발생했습니다."),
    INVALID_REQUEST_PARAMETER_ERROR(HttpStatus.BAD_REQUEST, "잘못된 요청 입니다."),

    /**
     * Error Message
     */
    DATA_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "데이터 정보를 찾을 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String description;
}