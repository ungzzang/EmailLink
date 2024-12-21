package com.green.email1.auth.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SendEmailAuthCodeReq {
    @Schema(title = "인증 받을 이메일", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;
}
