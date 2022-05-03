package com.example.demo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class PropertyConfig {

    /** 基本URL. */
    @Value("${app.baseurl}")
    private String baseurl;

}
