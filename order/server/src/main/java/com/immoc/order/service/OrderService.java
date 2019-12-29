package com.immoc.order.service;

import com.immoc.order.dto.OrderDTO;

import javax.validation.Valid;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */

public interface OrderService {

    /**
     * create the order
     * @param orderDTO
     * @return
     * user a DTO object to connect orderDetail and orderMaster to make the function simple.
     */
    OrderDTO create(OrderDTO orderDTO);
}
