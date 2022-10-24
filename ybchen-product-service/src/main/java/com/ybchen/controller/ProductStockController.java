package com.ybchen.controller;

import com.ybchen.service.ProductStockService;
import com.ybchen.util.ReturnT;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品库存控制层
 * @author: chenyanbin 2022-10-21 15:03
 */
@RestController
@Api(value = "商品库存api", tags = "商品库存api")
@RequestMapping("/api/v1/stock")
public class ProductStockController {
    @Autowired
    ProductStockService productStockService;

    @ApiOperation("扣减库存")
    @GetMapping("reduce")
    public ReturnT<String> reduce() {
        return productStockService.reduceProductStock();
    }
}
