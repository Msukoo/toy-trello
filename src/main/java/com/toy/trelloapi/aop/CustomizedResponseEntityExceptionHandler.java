package com.toy.trelloapi.aop;

import com.toy.trelloapi.domain.exception.CardNotFoundException;
import com.toy.trelloapi.infra.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // 공통 예외처리 (status=500)
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse =
                ExceptionResponse.builder()
                    .timestamp(new Date())
                    .message(ex.getMessage())
                    .details(request.getDescription(false))
                    .build();

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CardNotFoundException.class)
    public final ResponseEntity<Object> handleCardNotFoundException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse =
                ExceptionResponse.builder()
                        .timestamp(new Date())
                        .message(ex.getMessage())
                        .details(request.getDescription(false))
                        .build();

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
