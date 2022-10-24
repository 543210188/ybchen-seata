package com.ybchen.controller;

import com.ybchen.service.OrderService;
import com.ybchen.util.ReturnT;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chenyanbin 2022-10-21 15:05
 */
@RestController
@Api(value = "订单api",tags = "订单api")
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @ApiOperation("添加订单")
    @GetMapping("add")
    public ReturnT<String> add(){
        return orderService.add();
    }
}
