package com.green.email1.common;

import org.apache.commons.text.RandomStringGenerator;

public class CodeGenerate {
    public static String generateCode(int length) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z') // 숫자와 영문 범위 지정
                .filteredBy(Character::isLetterOrDigit) // 문자와 숫자만 허용
                .get();
        return generator.generate(length);
    }
}
