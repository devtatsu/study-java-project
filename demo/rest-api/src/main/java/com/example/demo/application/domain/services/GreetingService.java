package com.example.demo.application.domain.services;

import com.example.demo.application.controller.response.GreetingResponse;
import com.example.demo.jpa.domain.models.DeptModel;
import com.example.demo.jpa.domain.models.DeptQuery;
import com.example.demo.jpa.domain.repositories.DeptQueryRepository;
import com.example.demo.jpa.domain.repositories.DeptRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final DeptRepository repository;
    private final DeptQueryRepository repository2;

    @Transactional
    public List<GreetingResponse> getAccountInfo() {

        List<GreetingResponse> resultList = new ArrayList<GreetingResponse>();
        GreetingResponse wkResponse;

        List<DeptModel> resultRecord = this.repository.findAll();
        if (resultRecord.isEmpty()) {
            return new ArrayList<GreetingResponse>();
        }

        resultList = new ArrayList<GreetingResponse>();

        for (DeptModel oneRecord : resultRecord) {

            wkResponse = new GreetingResponse();

            wkResponse.setId(oneRecord.getId());
            wkResponse.setName(oneRecord.getName());

            resultList.add(wkResponse);

        }

        return resultList;

    }

    @Transactional
    public List<GreetingResponse> getFind() {

        List<GreetingResponse> resultList = new ArrayList<GreetingResponse>();
        GreetingResponse wkResponse;

        List<DeptQuery> resultRecord = this.repository2.findTest(2);
        if (resultRecord.isEmpty()) {
            return new ArrayList<GreetingResponse>();
        }

        resultList = new ArrayList<GreetingResponse>();

        for (DeptQuery oneRecord : resultRecord) {

            wkResponse = new GreetingResponse();

            wkResponse.setId(oneRecord.getId());
            wkResponse.setName(oneRecord.getName());

            resultList.add(wkResponse);

        }

        return resultList;

    }

}
