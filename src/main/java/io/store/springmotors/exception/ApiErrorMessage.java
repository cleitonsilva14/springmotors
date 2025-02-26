package io.store.springmotors.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ApiErrorMessage(

        @JsonFormat(pattern = "dd-MM-YYYY HH:mm:ss")
        LocalDateTime timestamp,
        String method,
        Integer statusCode,
        String statusText,
        String message

) {
}
