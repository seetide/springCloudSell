package com.immoc.product.controller;

import com.immoc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haitao on 12/23/19
 *
 * @project: product
 */

@RestController
public class ServerController {

    @Autowired
    ProductService productService;

    @GetMapping("/message")
    public String message() {
        return "this is product message";
    }

//    @PostMapping("/listForOrder")
//    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
//        return productService.findList(productIdList);
//    }
}
