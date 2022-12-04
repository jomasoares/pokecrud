package com.jomasoares.pokecrud.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jomasoares.pokecrud.dtos.ExceptionResponseDto;
import com.jomasoares.pokecrud.exceptions.BadRequestException;
import com.jomasoares.pokecrud.exceptions.InternalServerErrorException;
import com.jomasoares.pokecrud.exceptions.NotFoundException;

/**
 * Custom exception handler.
 * 
 * Responsible for defining what should be done when a exception is thrown.
 */
@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponseDto> handleBadRequest(BadRequestException e) {
		return defaultResponse(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleNotFound(NotFoundException e) {
		return defaultResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ExceptionResponseDto> handleInternalServerError(InternalServerErrorException e) {
		e.printStackTrace();
        return defaultResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
      StringBuilder strb = new StringBuilder();
      e.getFieldErrors().forEach(er -> strb.append(er.getField() + ": " + er.getDefaultMessage() + "; "));
      ExceptionResponseDto body = new ExceptionResponseDto(strb.toString());
      return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleDefault(Exception e) {
      e.printStackTrace();
      ExceptionResponseDto body = new ExceptionResponseDto("Unkown error. Try again later.");
      return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ExceptionResponseDto> defaultResponse(Exception e, HttpStatus s) {
        return new ResponseEntity<>(new ExceptionResponseDto(e.getMessage()), s);
    }
    
}
