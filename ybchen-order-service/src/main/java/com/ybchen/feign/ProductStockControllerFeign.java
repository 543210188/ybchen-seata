package com.ybchen.feign;

import com.ybchen.util.ReturnT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "product-service",contextId = "ProductStockControllerFeign")
public interface ProductStockControllerFeign {
    /**
     * 扣减库存
     * @return
     */
    @GetMapping("/api/v1/stock/reduce")
    ReturnT<String> reduce();
}