package org.example.predictionservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiValidationError> handleNotFound(ResourceNotFoundException ex,
                                                 HttpServletRequest req) {
    ApiValidationError err = new ApiValidationError(
        LocalDateTime.now(), 404, "Not Found",
        List.of(ex.getMessage()), req.getRequestURI()
    );
    return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiValidationError> handleValidation(MethodArgumentNotValidException ex,
                                                   HttpServletRequest req) {
    List<String> msgs = ex.getBindingResult().getFieldErrors().stream()
        .map(FieldError::getDefaultMessage)
        .collect(Collectors.toList());
    ApiValidationError err = new ApiValidationError(
        LocalDateTime.now(), 400, "Validation Failed",
        msgs, req.getRequestURI()
    );
    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ApiValidationError> handleIllegalArgument(
      IllegalArgumentException ex,
      HttpServletRequest req
  ) {
    ApiValidationError err = new ApiValidationError(
        LocalDateTime.now(),
        400,
        "Validation Failed",
        List.of(ex.getMessage()),
        req.getRequestURI()
    );
    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiValidationError> handleAll(Exception ex, HttpServletRequest req) {
    ApiValidationError err = new ApiValidationError(
        LocalDateTime.now(), 500, "Internal Error",
        List.of(ex.getMessage()), req.getRequestURI()
    );
    return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
