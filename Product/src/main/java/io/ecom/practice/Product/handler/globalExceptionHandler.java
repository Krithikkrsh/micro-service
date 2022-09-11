package io.ecom.practice.Product.handler;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class globalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected @NotNull ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map error = ex.getBindingResult()
                .getFieldErrors()
                .stream().collect(Collectors.toMap(
                        x -> x.getField(),x -> x.getDefaultMessage()
                ));

        return new ResponseEntity<>(error, headers, status);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> conflict(DataIntegrityViolationException e) {
        String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
        return ResponseEntity.ok(message);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<?> conflicts(DuplicateKeyException e) {
        Map<String,String> err= new HashMap<>();
        err.put("response","Please give valid details! or try to change userName!");
        err.put("status","404");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(err);
    }

}
