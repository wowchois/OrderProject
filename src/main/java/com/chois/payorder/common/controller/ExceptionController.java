package com.chois.payorder.common.controller;

import com.chois.payorder.common.constant.ApiResponseCode;
import com.chois.payorder.common.dto.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.kakao.payorder")
public class ExceptionController extends RuntimeException{

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(Throwable t){
        log.error("[ExceptionController] error : {}", t.getMessage());

        return ResponseEntity.status(HttpStatus.OK)
                .body(ResponseBody.builder()
                        .resultCode(ApiResponseCode.INTERNAL_SERVER_ERROR.getCode())
                        .message(t.getMessage())
                        .build());
    }

}
