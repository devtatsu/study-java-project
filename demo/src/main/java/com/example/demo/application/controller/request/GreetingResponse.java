package com.example.demo.application.controller.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
// @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GreetingResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    // ID
    @JsonProperty("id")
    private long id;

    // 氏名
    @JsonProperty("name")
    private String name;

}
