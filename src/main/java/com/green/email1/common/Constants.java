package com.green.email1.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {
    @Getter
    private static int default_page_size;
    @Getter
    private static int auth_code_length;

    public Constants(@Value("${const.default-page-size}") int default_page_size, @Value("${const.auth-code-length}") int auth_code_length) {
        Constants.default_page_size = default_page_size;
        Constants.auth_code_length = auth_code_length;
    }
}
