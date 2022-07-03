package com.chois.payorder.order.controller;

import com.chois.payorder.common.dto.ResponseBody;
import com.chois.payorder.common.constant.ApiResponseCode;
import com.chois.payorder.order.dto.OrderDto;
import com.chois.payorder.order.dto.OrderTopMenu;
import com.chois.payorder.order.entity.Order;
import com.chois.payorder.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/req")
    public ResponseEntity<?> setOrderRequest(@RequestBody OrderDto order) throws Exception{
        Order result = orderService.addOrderProcess(order);

        return ResponseEntity.ok(
                com.chois.payorder.common.dto.ResponseBody.builder()
                        .resultCode(ApiResponseCode.SUCCESS.getCode())
                        .message(ApiResponseCode.SUCCESS.name())
                        .data(result)
                        .build());
    }

    @GetMapping("/weektop")
    public ResponseEntity<?> getWeekTopMenuInfo(){
        List<OrderTopMenu> result = orderService.findTop3OfWeek();

        return ResponseEntity.ok(
                ResponseBody.builder()
                        .resultCode(ApiResponseCode.SUCCESS.getCode())
                        .message(ApiResponseCode.SUCCESS.name())
                        .data(result)
                        .build());
    }

}
