package com.ybchen.service.impl;

import com.ybchen.exception.BizException;
import com.ybchen.feign.ProductStockControllerFeign;
import com.ybchen.mapper.OrderMapper;
import com.ybchen.model.OrderDO;
import com.ybchen.service.OrderService;
import com.ybchen.util.ReturnT;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * @author: chenyanbin 2022-10-21 15:06
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ProductStockControllerFeign productStockControllerFeign;

    @Override
    //开启分布式事务 Seta AT模式
    @GlobalTransactional
    public ReturnT<String> add() {
        OrderDO orderDO = new OrderDO();
        int outTradeNo = new Random().nextInt(1000);
        orderDO.setOutTradeNo("T" + outTradeNo);
        orderDO.setCreateTime(new Date());
        int rows = orderMapper.insert(orderDO);
        if (rows > 0) {
            //扣减商品库存
            ReturnT<String> reduceReturn = productStockControllerFeign.reduce();
            if (ReturnT.isSuccess(reduceReturn)) {
                log.info("购买成功");
                //TODO 模拟异常方式二
                int num = 1 / 0;
                return ReturnT.buildSuccess("购买成功");
            }
            // 解决全局拦截器问题，通过接口响应状态码，来判断是否主动抛异常！！！！！！！
            if (reduceReturn.getCode() != 0) {
                log.info("扣减商品库存失败，接口响应：{}", reduceReturn);
                throw new BizException(110, "扣减商品库存失败");
            }
            log.info("扣减商品库存失败");
            return ReturnT.buildError("扣减商品库存失败");
        }
        log.info("购买失败");
        return ReturnT.buildError("购买失败");
    }
}