package com.chois.payorder.user.controller;

import com.chois.payorder.user.dto.UserDto;
import com.chois.payorder.common.constant.ApiResponseCode;
import com.chois.payorder.common.dto.ResponseBody;
import com.chois.payorder.user.entity.User;
import com.chois.payorder.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/charge")
    public ResponseEntity<?> setUserCharge(@RequestBody UserDto user){
        User result = userService.addUpdateUser(user);

        return ResponseEntity.ok(
                ResponseBody.builder()
                        .resultCode(ApiResponseCode.SUCCESS.getCode())
                        .message(ApiResponseCode.SUCCESS.name())
                        .data(result)
                        .build());
    }

}
