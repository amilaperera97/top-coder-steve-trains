package com.trains.steve.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class ErrorResponseDto<T> {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;

    /* For return is void*/
    private ErrorResponseDto(String message, int status) {
        this.message = message;
        this.status = status;
    }

    private ErrorResponseDto(String error, String message, int status) {
        this.error = error;
        this.message = message;
        this.status = status;
    }

    private ErrorResponseDto(String error, String message, int status, LocalDateTime timestamp) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public ErrorResponseDto<T> buildFailureMsg(Exception ex, HttpStatus status) {
        return buildFailureMsg(ex.getLocalizedMessage(), ex, status);
    }

    public ErrorResponseDto buildFailureMsg(String msg, Exception ex, HttpStatus status) {
        if (ex != null) {
            if (log.isDebugEnabled())
                log.debug("Oops, An error occurred while processing the request : {}", ex);
            else
                log.error("Oops, An error occurred while processing the request cased by {}", ex.getCause().getLocalizedMessage(), ex);
        }
        return new ErrorResponseDto<>(ex.getMessage(), msg, status.value(), LocalDateTime.now());
    }
}
