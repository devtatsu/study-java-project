package com.example.demo.application.controller;

import com.example.demo.application.common.constants.AppServerServiceURI;
import com.example.demo.application.controller.request.EmployeePostRequest;
import com.example.demo.application.domain.services.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping(value = AppServerServiceURI.POST_EMPLOYEE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addEmployee(@RequestBody @Validated EmployeePostRequest request) {

        this.service.addData(request);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
