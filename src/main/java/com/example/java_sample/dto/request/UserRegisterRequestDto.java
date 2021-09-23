package com.example.java_sample.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequestDto {
    @NonNull
    @JsonProperty("name")
    private String name;

    @NonNull
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @NonNull
    @JsonProperty("pinCode")
    private Integer pinCode;
}
