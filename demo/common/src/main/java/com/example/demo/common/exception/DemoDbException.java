package com.example.demo.common.exception;

import lombok.Getter;

public class DemoDbException extends RuntimeException {

    /** シリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    // 障害コード
    @Getter
    private String code;

    public DemoDbException(String message, String code) {
        super(message);
        this.code = code;
    }

}
