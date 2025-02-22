package io.store.springmotors.config.exception;


import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter @ToString @NoArgsConstructor
public class ErrorMessage {

    private String path;
    private String method;
    private int status;
    private String statusText;
    private String message;


    private Map<String, String> errors;

    public ErrorMessage(HttpServletRequest request, HttpStatus status, String message){
        
    }

}
