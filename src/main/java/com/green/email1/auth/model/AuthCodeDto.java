package com.green.email1.auth.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCodeDto {
    private String authCode;
    private String maxDate;
}
