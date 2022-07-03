package com.chois.payorder.order.service;

import com.chois.payorder.common.dto.CollectLogReqDto;
import com.chois.payorder.common.dto.ResponseBody;
import com.chois.payorder.order.dto.OrderInfo;
import com.chois.payorder.user.service.UserService;
import com.chois.payorder.common.constant.ApiResponseCode;
import com.chois.payorder.feign.CollectLogFeign;
import com.chois.payorder.order.dto.OrderDto;
import com.chois.payorder.order.dto.OrderTopMenu;
import com.chois.payorder.order.entity.Order;
import com.chois.payorder.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserService userService;
    private final OrderRepository orderRepository;

    private final CollectLogFeign collectLogFeign;

    @Transactional(rollbackOn = {Exception.class})
    public Order addOrderProcess(OrderDto orderDto) throws Exception{
        Order order = addOrder(orderDto.toEntity());
        OrderInfo orderInfo = findOrderInfo(order.getId());
        int leftPoint = getLeftPoint(orderInfo.getPoint(), orderInfo.getPrice());

        userService.updatePoint(orderDto.getOrderUserId(), leftPoint);

        sendCollectLog(findOrderInfo(order.getId()));

        return order;
    }

    public int getLeftPoint(int nowPoint, int usePoint) throws Exception {
        if(nowPoint < usePoint){
            throw new Exception("소지한 포인트가 부족합니다.");
        }else{
            return nowPoint - usePoint;
        }
    }

    private Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public List<OrderTopMenu> findTop3OfWeek(){
        return orderRepository.findAllByMenuOOrderByCnt();
    }

    public OrderInfo findOrderInfo(long id){
        return orderRepository.findByMenuOrderInfo(id);
    }

    public void sendCollectLog(OrderInfo param){
        CollectLogReqDto reqInfo = new CollectLogReqDto(
                param.getUserId()
                ,param.getMenuId()
                ,param.getPrice());
        ResponseBody body = collectLogFeign.sendCollectLog(reqInfo);

        if(ApiResponseCode.SUCCESS.getCode() != body.getResultCode()){
            log.error("[sendCollectLog] error : {}",body.getResultCode());
        }
    }
}
