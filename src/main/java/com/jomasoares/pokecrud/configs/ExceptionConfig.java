package com.jomasoares.pokecrud.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jomasoares.pokecrud.dtos.ExceptionResponseDto;
import com.jomasoares.pokecrud.exceptions.BadRequestException;
import com.jomasoares.pokecrud.exceptions.NotFoundException;

/**
 * Custom exception handler.
 * 
 * 
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
