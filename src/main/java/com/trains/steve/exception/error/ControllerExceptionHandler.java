package com.trains.steve.exception.error;

import com.trains.steve.dto.ErrorResponseDto;
import com.trains.steve.exception.custom.InvalidParameterException;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public ControllerExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected @NotNull ResponseEntity<Object> handleHttpMessageNotReadable(@NotNull HttpMessageNotReadableException ex, @NotNull HttpHeaders headers, @NotNull HttpStatus status, @NotNull WebRequest request) {
        ErrorResponseDto<Void> responseDto = new ErrorResponseDto<Void>().buildFailureMsg(messageSource.getMessage("malformed.request", new Object[0], Locale.ENGLISH), ex, status);
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponseDto<Void>> globalInvalidExceptionHandler(Exception ex) {
        ErrorResponseDto<Void> responseDto = new ErrorResponseDto<Void>().buildFailureMsg(ex.getCause().getMessage(), ex, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
