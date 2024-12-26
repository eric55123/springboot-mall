package com.eric.springbootmall.service;

import com.eric.springbootmall.dao.CreateOrderRequest;
import com.eric.springbootmall.dto.OrderQueryParams;
import com.eric.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

}
