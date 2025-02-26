package io.store.springmotors.handler;


import io.store.springmotors.exception.ApiErrorMessage;
import io.store.springmotors.exception.ErrorMessage;
import io.store.springmotors.exception.PlacaUniqueViolationException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(PlacaUniqueViolationException.class)
    public ResponseEntity<ApiErrorMessage> placaUniqueViolation(RuntimeException ex, HttpServletRequest request){
        ApiErrorMessage apiErrorMessage = ApiErrorMessage
                .builder()
                .timestamp(LocalDateTime.now())
                .method(request.getMethod())
                .statusCode(CONFLICT.value())
                .statusText(CONFLICT.name())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(apiErrorMessage, CONFLICT);
    }

}
