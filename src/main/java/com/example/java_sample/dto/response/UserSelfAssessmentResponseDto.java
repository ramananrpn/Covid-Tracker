package com.example.java_sample.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserSelfAssessmentResponseDto {
    private int riskPercentage;
}
