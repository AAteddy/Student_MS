
package com.school.student_ms.exception;

import lombok.Getter;


@Getter
public class ValidationException extends RuntimeException {

//    private ErrorPayload errorPayload;

    public ValidationException(String msg) {
        super(msg);
//        errorPayload = new ErrorPayload(errorCode, super.getMessage());
    }
}
