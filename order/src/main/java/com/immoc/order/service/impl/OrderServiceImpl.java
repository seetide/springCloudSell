package com.immoc.order.service.impl;

import com.immoc.order.dataobject.OrderMaster;
import com.immoc.order.dto.OrderDTO;
import com.immoc.order.enums.OrderStatusEnum;
import com.immoc.order.enums.PayStatusEnum;
import com.immoc.order.repository.OrderDetailRepository;
import com.immoc.order.repository.OrderMasterRepository;
import com.immoc.order.service.OrderService;
import com.immoc.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //Todo query product info
        //Todo calculate total amount
        //Todo deduce the stock

        //save order
        OrderMaster orderMaster = new OrderMaster();

        // do this copy at the beginning to build the structure. then modify the
        // special data.
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);

        orderMaster.setBuyerOpenid(orderDTO.getBuyerOpenid());
        orderMaster.setBuyerName(orderDTO.getBuyerName());
        //Todo modify the amount
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());


        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
