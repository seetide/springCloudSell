package com.immoc.order.repository;

import com.immoc.order.dataobject.OrderMaster;
import com.immoc.order.enums.OrderStatusEnum;
import com.immoc.order.enums.PayStatusEnum;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class OrderMasterRepositoryTest  {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12345678");
        orderMaster.setBuyerOpenid("123456");
        orderMaster.setBuyerAddress("mooc headerquater");
        orderMaster.setBuyerName("mo shixiong");
        orderMaster.setBuyerPhone("1223333444");
        orderMaster.setOrderAmount(new BigDecimal(20));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());


        OrderMaster result = orderMasterRepository.save(orderMaster);
        assertNotNull(result);
    }
}