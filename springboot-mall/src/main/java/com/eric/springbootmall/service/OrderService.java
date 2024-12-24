package com.eric.springbootmall.service;

import com.eric.springbootmall.dao.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
