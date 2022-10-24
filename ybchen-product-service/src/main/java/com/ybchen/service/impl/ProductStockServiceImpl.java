package com.ybchen.service.impl;

import com.ybchen.mapper.ProductStockMapper;
import com.ybchen.model.ProductStockDO;
import com.ybchen.service.ProductStockService;
import com.ybchen.util.ReturnT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 商品库存业务层
 *
 * @author: chenyanbin 2022-10-21 14:55
 */
@Service
@Slf4j
public class ProductStockServiceImpl implements ProductStockService {
    @Autowired
    ProductStockMapper productStockMapper;


    @Override
    public ReturnT<String> reduceProductStock() {
        ProductStockDO stockDO = new ProductStockDO();
        stockDO.setProductId(10086);
        stockDO.setBuyNum(1);
        stockDO.setCreateTime(new Date());
        int rows = productStockMapper.insert(stockDO);
        //TODO 模拟异常方式一
//        int num = 1 / 0;
        if (rows > 0) {
            log.info("扣减商品库存成功，rows=" + rows);
            return ReturnT.buildSuccess("扣减商品库存成功");
        } else {
            log.info("扣减商品库存失败，rows=" + rows);
            return ReturnT.buildError("扣减失败");
        }
    }
}