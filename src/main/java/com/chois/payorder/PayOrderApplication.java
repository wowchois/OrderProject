package com.chois.payorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PayOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayOrderApplication.class, args);
    }

}
