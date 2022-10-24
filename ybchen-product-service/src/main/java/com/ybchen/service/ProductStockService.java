package com.ybchen.service;

import com.ybchen.util.ReturnT;

public interface ProductStockService {
    /**
     * 扣减商品库存
     * @return
     */
    ReturnT<String> reduceProductStock();
}