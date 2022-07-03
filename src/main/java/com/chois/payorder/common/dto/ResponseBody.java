package com.chois.payorder.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseBody{

    private Integer resultCode;
    private String message;
    private Object data;

}
