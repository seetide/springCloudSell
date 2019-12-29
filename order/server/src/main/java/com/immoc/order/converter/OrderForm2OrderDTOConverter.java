package com.immoc.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.immoc.order.dataobject.OrderDetail;
import com.immoc.order.dto.OrderDTO;
import com.immoc.order.enums.ResultEnum;
import com.immoc.order.exception.OrderException;
import com.immoc.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();

        Gson gson = new Gson();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());

        }catch (Exception ex){
            log.error("[json transformation] error, string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
