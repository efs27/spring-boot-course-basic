package com.efsaplicativos.spring_boot_course_basic.entities;

public class OrderItem {

    private Integer quantity;
    private Double price;


    public double subTotal() {
        return quantity * price;
    }
}
