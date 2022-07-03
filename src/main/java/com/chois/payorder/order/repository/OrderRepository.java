package com.chois.payorder.order.repository;

import com.chois.payorder.order.dto.OrderInfo;
import com.chois.payorder.order.entity.Order;
import com.chois.payorder.order.dto.OrderTopMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(value =
            "select a.order_user_id as userId, a.menu_id as menuId, b.price as price, c.points as point " +
            "from orders as a " +
                    "inner join menu as b on a.menu_id = b.id " +
                    "inner join users as c on a.order_user_id = c.id " +
            "where a.id = :id"
            , nativeQuery = true
    )
    public OrderInfo findByMenuOrderInfo(@Param("id") long id);

    @Query(value =
            "select b.id as menuId, count(a.menu_id) as cnt, b.name as menuName, b.price as price " +
            "from orders as a " +
                    "inner join menu as b on a.menu_id = b.id " +
            "where a.created_date " +
            "between formatdatetime(timestampadd(day, -7, now()),'yyyy-MM-dd') " +
            "   and formatdatetime(now(),'yyyy-MM-dd') " +
            "group by a.menu_id " +
            "order by cnt desc limit 3"
            , nativeQuery = true
    )
    public List<OrderTopMenu> findAllByMenuOOrderByCnt();
}
