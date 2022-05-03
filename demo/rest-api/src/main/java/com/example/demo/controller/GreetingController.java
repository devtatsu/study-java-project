package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.example.demo.resource.Greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.common.constants.AppServerServiceURI;
import com.example.demo.controller.response.GreetingResponse;
import com.example.demo.domain.services.GreetingService;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    /** 部門情報フォーマット用テンプレート. */
    // private static final String defaultTemp = "Hello, %s!";
    private final String defaultTemp = "Hello, %s!";
    /** 社員ID. */
    private final AtomicLong counter = new AtomicLong();

    /** 部門情報取得Service. */
    private final GreetingService service;

    /**
     * 部門情報取得.
     * 
     * @param name 部門名
     * @return 部門情報
     * 
     */
    // @formatter:off
    @GetMapping(AppServerServiceURI.GREETING)
    public Greeting greeting(
            @RequestParam(
                value = "name",
                defaultValue = "World")
                final String name) {
        return new Greeting(
            counter.incrementAndGet(), 
            String.format(defaultTemp, name));
        
    }
    // @formatter:on

    /**
     * 部門情報取得.
     * 
     * @return 部門情報リスト
     * 
     */
    @GetMapping(AppServerServiceURI.GET_GREETING)
    public ResponseEntity<List<GreetingResponse>> getGreeting() {

        List<GreetingResponse> retEntity = this.service.getAccountInfo();

        return new ResponseEntity<>(retEntity, HttpStatus.OK);

    }

    /**
     * 部門情報取得 テスト用.
     * 
     * @return 部門情報リスト
     * 
     */
    @GetMapping(value = AppServerServiceURI.GET_GREETING_TEST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GreetingResponse>> getGreetingTest() {

        List<GreetingResponse> retEntity = this.service.getFind();

        return new ResponseEntity<>(retEntity, HttpStatus.OK);

    }

}
