package com.chois.payorder.order.repository;

import com.chois.payorder.order.dto.OrderInfo;
import com.chois.payorder.order.dto.OrderTopMenu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(OrderRepositoryTest.class);

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testFindByMenuOrderInfo(){
        long orderId = 1;
        OrderInfo info = orderRepository.findByMenuOrderInfo(orderId);
        assertEquals(1,info.getMenuId());
    }

    @Test
    public void testFindAllByMenuOOrderByCnt(){
        List<OrderTopMenu> info = orderRepository.findAllByMenuOOrderByCnt();
        info.stream().forEach(data -> logger.info("{}",data.getMenuName()));
    }
}