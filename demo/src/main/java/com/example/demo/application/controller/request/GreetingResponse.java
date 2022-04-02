package com.example.demo.application.controller.request;

import java.io.Serializable;
// import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
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
