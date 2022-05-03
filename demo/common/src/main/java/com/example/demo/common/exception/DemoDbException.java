package com.example.demo.common.exception;

import lombok.Getter;
import lombok.Setter;

public class DemoDbException extends RuntimeException {

    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 1L;

    /** 障害コード. */
    @Setter
    @Getter
    private String errCode;

    /**
     * DB関連のException.
     * 
     * @param message メッセージ
     * @param code コード
     * 
     */
    public DemoDbException(final String message, final String code) {
        super(message);
        this.errCode = code;
    }

}
