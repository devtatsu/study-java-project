package com.example.demo.common;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.example.demo.common.exception.DemoDbException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(DemoExceptionHandler.class);

    /**
     * DB処理結果、失敗時制御<br>
     * <br>
     * 
     * @param e Exception
     * @return 編集結果、エラーレスポンス
     * 
     */
    @ExceptionHandler({ DemoDbException.class })
    public ResponseEntity<ErrorResponse> handleDataAccessError(DemoDbException e) {
        logger.error("Error Message(DataAccessException):[{}]", e.getMessage());
        logger.error("Error Cause(DataAccessException):{}", e.getCause());
        ErrorResponse errResponse = new ErrorResponse();
        // log.error(errResponse.toString(), e.getCause());
        return new ResponseEntity<>(errResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
