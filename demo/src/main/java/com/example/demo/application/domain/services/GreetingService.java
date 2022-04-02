package com.example.demo.application.domain.services;

import com.example.demo.application.controller.request.GreetingResponse;
import com.example.demo.application.domain.models.DeptModel;
import com.example.demo.application.domain.repositories.DeptRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
// import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GreetingService {

    private final DeptRepository repository;

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

}
