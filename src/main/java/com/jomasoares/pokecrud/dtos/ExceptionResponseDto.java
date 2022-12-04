package com.jomasoares.pokecrud.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class ExceptionResponseDto {
    
    private String error;

    @Getter(AccessLevel.NONE)
    private LocalDateTime timestamp;

    public ExceptionResponseDto(String error) {
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }

    public String getTimestamp() {
        return timestamp.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

}
