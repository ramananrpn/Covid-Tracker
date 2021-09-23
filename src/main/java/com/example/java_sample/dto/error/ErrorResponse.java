package com.example.java_sample.dto.error;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse
        implements Serializable {
    @JsonProperty("error_type")
    private String errorType;
    private String message;
}