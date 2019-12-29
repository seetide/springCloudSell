package com.immoc.order.controller;

import com.immoc.order.VO.ResultVO;
import com.immoc.order.converter.OrderForm2OrderDTOConverter;
import com.immoc.order.dto.OrderDTO;
import com.immoc.order.enums.ResultEnum;
import com.immoc.order.exception.OrderException;
import com.immoc.order.form.OrderForm;
import com.immoc.order.service.OrderService;
import com.immoc.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    /**
     * 1. check the parameters
     * 2. query product information (call the product service)
     * 3. calculate the total price
     * 4. deduce the stock (call the product service)
     * 5. save the order
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.error("parameters for Order creation is not correct! orderForm={}", orderForm );
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        //orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        // previous check only check whether the string for order items not empty.
        // current step check the object after json transformation
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[create order] order cart is empty");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        return ResultVOUtil.success(map);
    }
}
