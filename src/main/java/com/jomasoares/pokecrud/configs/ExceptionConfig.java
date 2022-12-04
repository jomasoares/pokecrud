package com.jomasoares.pokecrud.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jomasoares.pokecrud.dtos.ExceptionResponseDto;
import com.jomasoares.pokecrud.exceptions.BadRequestException;

/**
 * Custom exception handler.
 * 
 * 
 */
@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponseDto> handleBadRequest(BadRequestException e) {
		return new ResponseEntity<>(new ExceptionResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponseDto> handleDefault(Exception e) {
		e.printStackTrace();
		ExceptionResponseDto body = new ExceptionResponseDto("Unkown error. Try again later.");
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    
}
