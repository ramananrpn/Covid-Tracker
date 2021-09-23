package com.example.java_sample.dto.request;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class UserSelfAssesmentRequestDto {
    private long userId;

    @NonNull
    private List<String> symptoms;

    private boolean travelHistory;

    private boolean contactWithCovidPatient;
}
