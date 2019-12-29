package com.immoc.order.repository;

import com.immoc.order.dataobject.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave(){

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setDetailId("12457983");
        orderDetail.setOrderId("12345678");
        orderDetail.setProductIcon("www.xxx.com/ord.jpg");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(0.01));
        orderDetail.setProductQuantity(3);

        OrderDetail result = orderDetailRepository.save(orderDetail);
        assertNotNull(result);
    }
}