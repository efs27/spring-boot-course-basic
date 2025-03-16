package com.efsaplicativos.spring_boot_course_basic.entities;

import com.efsaplicativos.spring_boot_course_basic.enuns.OrderStatus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

    private Long id;
    private Date moment;
    private OrderStatus orderStatus;

    private Payment payment;
    private User client;
    private Set<Product> items = new HashSet<>();


    public double total() {
        return 0;
    }
}
