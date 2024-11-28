
package com.school.student_ms.exception;

import lombok.Getter;


@Getter
public class ValidationException extends RuntimeException {

    private ErrorPayload errorPayload;

    public ValidationException(String msg, ErrorCode errorCode) {
        super("Validation Exception: " + msg);
        errorPayload = new ErrorPayload(errorCode, super.getMessage());
    }
}
