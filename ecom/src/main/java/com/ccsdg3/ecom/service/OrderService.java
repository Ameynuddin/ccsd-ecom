package com.ccsdg3.ecom.service;


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
        return orderRepository.findByUserId(userId);
    }

    public Optional<Order> getOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }

    public Order updateOrderToPaid(String orderId, PaymentResult paymentResult) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        order.setPaid(true);
        order.setPaidAt(new Date());
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
