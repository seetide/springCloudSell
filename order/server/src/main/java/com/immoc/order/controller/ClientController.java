package com.immoc.order.controller;

import com.immoc.order.client.ProductClient;
import com.immoc.order.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by haitao on 12/23/19
 *
 * @project: order
 */

@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

//
//    @Autowired
//    private RestTemplate restTemplate;

    //use Feign
    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMessage")
    public String getProductMessage(){

        //1. first method: write the static url
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/message", String.class);


        //2. second method: write the dynamic combination from loadbalance serviceInstance
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/message";
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject(url, String.class);

        //3. Use @Loadbalanced in config class
//        String response = restTemplate.getForObject("http://PRODUCT/message", String.class);

        //4. Use Feign
        String response = productClient.productMessage();

        log.info("response={}", response);

        return response;

    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> response = productClient.listForOrder(Arrays.asList("157875227953464068"));
        log.info("response = {}", response);
        return "ok";
    }
}
