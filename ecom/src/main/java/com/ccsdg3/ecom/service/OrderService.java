package com.ccsdg3.ecom.service;

import com.ccsdg3.ecom.model.Order;
import com.ccsdg3.ecom.model.User;
import com.ccsdg3.ecom.model.OrderItem;
import com.ccsdg3.ecom.repository.OrderRepository;
import com.ccsdg3.ecom.exception.ResourceNotFoundException;
import com.ccsdg3.ecom.dto.OrderRequest;
import com.ccsdg3.ecom.dto.PaymentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Date;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(OrderRequest request, String userId) {
        Order order = new Order();
        order.setOrderItems(request.getOrderItems().stream()
                .map(this::mapToOrderItem)
                .collect(Collectors.toList()));
        order.setShippingAddress(request.getShippingAddress());
        order.setPaymentMethod(request.getPaymentMethod());
        order.setItemsPrice(request.getItemsPrice());
        order.setShippingPrice(request.getShippingPrice());
        order.setTaxPrice(request.getTaxPrice());
        order.setTotalPrice(request.getTotalPrice());
        order.setUser(new User(userId));

        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(String userId) {
        return orderRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    public Order updateOrderToPaid(String orderId, PaymentResult paymentResult) {
        Order order = getOrderById(orderId);
        order.setPaid(true);
        order.setPaidAt(new Date());
        order.setPaymentResult(paymentResult);
        return orderRepository.save(order);
    }
}