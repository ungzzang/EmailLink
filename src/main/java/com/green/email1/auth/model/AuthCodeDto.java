package com.green.email1.auth.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthCodeDto {
    private String authCode;
    private String maxDate;
    private String email;
}
