package com.myownapp.masteringjwt.ressources;

import com.myownapp.masteringjwt.exceptions.ExceptionResponse;
import com.myownapp.masteringjwt.exceptions.UserNotFoundException;
import com.myownapp.masteringjwt.exceptions.UserNotFoundExceptionToDelete;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleExceptions(UserNotFoundException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResponse , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundExceptionToDelete.class)
    public final ResponseEntity<Object> handleDeleteException(UserNotFoundExceptionToDelete ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND) ;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Data NOT valid", ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

}
