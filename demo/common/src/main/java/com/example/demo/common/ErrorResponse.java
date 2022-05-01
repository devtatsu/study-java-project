package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ErrorResponse {

    // エラーコード
    @JsonProperty("code")
    private String code;
    // エラーメッセージ
    @JsonProperty("msg")
    private String msg;

}
