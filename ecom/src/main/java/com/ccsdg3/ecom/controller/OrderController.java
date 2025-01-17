package com.ccsdg3.ecom.controller;

import com.ccsdg3.ecom.model.Order;
import com.ccsdg3.ecom.service.OrderService;
import com.ccsdg3.ecom.dto.OrderRequest;
import com.ccsdg3.ecom.dto.PaymentResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest,
                                         @AuthenticationPrincipal UserDetails userDetails) {
        Order order = orderService.createOrder(orderRequest, userDetails.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new OrderResponse("New Order Created", order));
    }

    @GetMapping("/mine")
    public List<Order> getMyOrders(@AuthenticationPrincipal UserDetails userDetails) {
        return orderService.getUserOrders(userDetails.getUsername());
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}/pay")
    public ResponseEntity<?> updateOrderToPaid(@PathVariable String id,
                                               @RequestBody PaymentResultDTO paymentResult) {
        Order updatedOrder = orderService.updateOrderToPaid(id, paymentResult);
        return ResponseEntity.ok(new OrderResponse("Order Paid", updatedOrder));
    }
}