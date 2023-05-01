package aca.demo.movierating.endpoint;

import aca.demo.movierating.movie.MovieNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j

public class GeneralExceptionHandler {

    @ExceptionHandler
    ResponseEntity<ErrorResponse> handle(MovieNotFoundException e) {
        log.error("Movie Not Found",e);

        HttpStatus status = HttpStatus.BAD_REQUEST;

        int errorCode = 1001;

        String description = e.getMessage();

        ErrorResponse errorResponse = new ErrorResponse(errorCode,description,null);

        return new ResponseEntity<>(errorResponse,status);

    }

    @ExceptionHandler
    ResponseEntity<ErrorResponse> handle(IllegalArgumentException e){
        log.error("Illegal Argument",e);

        HttpStatus status = HttpStatus.BAD_REQUEST;

        int errorCode = 1002;

        String description = e.getMessage();

        ErrorResponse errorResponse = new ErrorResponse(errorCode,description,null);

        return new ResponseEntity<>(errorResponse,status);
    }

    @ExceptionHandler
    ResponseEntity<ErrorResponse> handle(RuntimeException e) {
        log.error("Runtime Exception",e);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        int errorCode = 1100;

        String description = e.getMessage();

        ErrorResponse errorResponse = new ErrorResponse(errorCode,description,null);

        return new ResponseEntity<>(errorResponse,status);

    }
}
