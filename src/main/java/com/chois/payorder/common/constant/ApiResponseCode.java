package com.chois.payorder.common.constant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public enum ApiResponseCode {

    SUCCESS(200),
    BAD_REQUEST(400),
    INTERNAL_SERVER_ERROR(500),
    PARAMETER_ERROR(500);

    @Getter
    private Integer code;

    ApiResponseCode(Integer code) {
        this.code = code;
    }
}
