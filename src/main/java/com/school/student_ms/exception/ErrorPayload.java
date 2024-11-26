package com.school.student_ms.exception;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorPayload {
    private ErrorCode errorCode;
    private String detail;
    private LocalDateTime time;

    public ErrorPayload(ErrorCode errorCode, String errorDetail) {
        this.errorCode = errorCode;
        this.detail = errorDetail;
        time = LocalDateTime.now();
    }
}
