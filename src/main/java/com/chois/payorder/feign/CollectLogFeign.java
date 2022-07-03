package com.chois.payorder.feign;

import com.chois.payorder.common.dto.CollectLogReqDto;
import com.chois.payorder.common.dto.ResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CollectLogFeign", url = "${feign.callurl}")
public interface CollectLogFeign {

    @PostMapping(value = "/collect/order/log", produces = "application/json")
    ResponseBody sendCollectLog(@RequestBody CollectLogReqDto param);
}
