package com.immoc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haitao on 12/23/19
 *
 * @project: product
 */

@RestController
public class ServerController {

    @GetMapping("/message")
    public String message() {
        return "this is product message";
    }
}
