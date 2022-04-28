package com.example.demo.controller.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EmployeePostRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    // 氏名（姓）
    @JsonProperty("firstname")
    private String firstname;

    // 氏名（名）
    @JsonProperty("lastname")
    private String lastname;

    // 所属部署
    @JsonProperty("department")
    private String department;

    // 入社日
    @JsonProperty("hiredate")
    private int hiredate;

}
