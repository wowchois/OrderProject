package com.chois.payorder.menu.controller;

import com.chois.payorder.common.dto.ResponseBody;
import com.chois.payorder.menu.entity.Menu;
import com.chois.payorder.menu.service.MenuService;
import com.chois.payorder.common.constant.ApiResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu")
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/info")
    public ResponseEntity<?> getMenuInfo(){
        List<Menu> result = menuService.findMenuList();

        return ResponseEntity.ok(
                ResponseBody.builder()
                        .resultCode(ApiResponseCode.SUCCESS.getCode())
                        .message(ApiResponseCode.SUCCESS.name())
                        .data(result)
                        .build());
    }
}
