package com.efsaplicativos.spring_boot_course_basic.dtos;

import com.efsaplicativos.spring_boot_course_basic.entities.Order;
import com.efsaplicativos.spring_boot_course_basic.entities.OrderItem;
import com.efsaplicativos.spring_boot_course_basic.enuns.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private Long id;
    private Instant moment;
    private OrderStatus orderStatus;

    private PaymentDto payment;
    private UserDto client;

    @NotEmpty(message = "Deve ter pelo menos um item")
    private List<OrderItemDto> items = new ArrayList<>();

    public OrderDto() {
    }

    public OrderDto(Long id, Instant moment, OrderStatus orderStatus, PaymentDto payment, UserDto client) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus;
        this.payment = payment;
        this.client = client;
    }

    public OrderDto(Order order) {
        id = order.getId();
        moment = order.getMoment();
        orderStatus = order.getOrderStatus();
        payment = (order.getPayment() == null) ? null : new PaymentDto(order.getPayment());
        client = new UserDto(order.getClient());
        for (OrderItem item : order.getItems()) {
            items.add(new OrderItemDto(item));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentDto payment) {
        this.payment = payment;
    }

    public UserDto getClient() {
        return client;
    }

    public void setClient(UserDto client) {
        this.client = client;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public Double getTotal() {
        double sum = 0.0;
        for (OrderItemDto item : items) {
            sum += item.getSubTotal();
        }
        return sum;
    }
}
