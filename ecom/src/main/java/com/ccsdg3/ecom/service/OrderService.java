package com.ccsdg3.ecom.service;

import com.ccsdg3.ecom.model.Order;
import com.ccsdg3.ecom.model.User;
import com.ccsdg3.ecom.model.OrderItem;
import com.ccsdg3.ecom.model.Product;
import com.ccsdg3.ecom.model.PaymentResult;
import com.ccsdg3.ecom.model.ShippingAddress;
import com.ccsdg3.ecom.repository.OrderRepository;
import com.ccsdg3.ecom.exception.ResourceNotFoundException;
import com.ccsdg3.ecom.dto.OrderRequest;
import com.ccsdg3.ecom.dto.OrderItemRequest;
import com.ccsdg3.ecom.dto.PaymentResultDTO;
import com.ccsdg3.ecom.dto.ShippingAddressDTO;
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

        ShippingAddress shippingAddress = new ShippingAddress();
        ShippingAddressDTO shipDTO = request.getShippingAddress();
        shippingAddress.setFullName(shipDTO.getFullName());
        shippingAddress.setAddress(shipDTO.getAddress());
        shippingAddress.setCity(shipDTO.getCity());
        shippingAddress.setPostalCode(shipDTO.getPostalCode());
        shippingAddress.setCountry(shipDTO.getCountry());

        order.setShippingAddress(shippingAddress);
        order.setPaymentMethod(request.getPaymentMethod());
        order.setItemsPrice(request.getItemsPrice());
        order.setShippingPrice(request.getShippingPrice());
        order.setTaxPrice(request.getTaxPrice());
        order.setTotalPrice(request.getTotalPrice());
        order.setUser(new User(userId));
        order.setPaid(false);
        order.setDelivered(false);

        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(String userId) {
        return orderRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    public Order updateOrderToPaid(String orderId, PaymentResultDTO paymentResultDTO) {
        Order order = getOrderById(orderId);
        order.setPaid(true);
        order.setPaidAt(new Date());

        PaymentResult paymentResult = new PaymentResult();
        paymentResult.setId(paymentResultDTO.getId());
        paymentResult.setStatus(paymentResultDTO.getStatus());
        paymentResult.setUpdateTime(paymentResultDTO.getUpdateTime());
        paymentResult.setEmailAddress(paymentResultDTO.getEmailAddress());

        order.setPaymentResult(paymentResult);
        return orderRepository.save(order);
    }

    private OrderItem mapToOrderItem(OrderItemRequest itemRequest) {
        OrderItem item = new OrderItem();
        item.setSlug(itemRequest.getSlug());
        item.setName(itemRequest.getName());
        item.setQuantity(itemRequest.getQuantity());
        item.setImage(itemRequest.getImage());
        item.setPrice(itemRequest.getPrice());
        item.setProduct(new Product(itemRequest.getProductId()));
        return item;
    }
}