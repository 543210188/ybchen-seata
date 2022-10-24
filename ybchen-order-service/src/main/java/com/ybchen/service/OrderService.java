package com.ybchen.service;

import com.ybchen.util.ReturnT;

public interface OrderService {
    /**
     * 添加订单
     * @return
     */
    ReturnT<String> add();
}