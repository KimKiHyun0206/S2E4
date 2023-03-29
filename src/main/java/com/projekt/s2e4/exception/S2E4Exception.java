package com.projekt.s2e4.exception;

public class S2E4Exception extends BusinessException {
    public S2E4Exception() {
        super(ErrorMessage.DATA_NOT_FOUND_ERROR);
    }
}