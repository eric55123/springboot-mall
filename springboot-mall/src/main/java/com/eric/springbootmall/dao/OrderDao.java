package com.eric.springbootmall.dao;

import com.eric.springbootmall.dto.OrderQueryParams;
import com.eric.springbootmall.model.Order;
import com.eric.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItems);

    List<OrderItem> getOrderItemsById(Integer orderId);

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);
}
