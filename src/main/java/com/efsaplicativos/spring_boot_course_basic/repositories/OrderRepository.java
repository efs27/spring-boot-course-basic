package com.efsaplicativos.spring_boot_course_basic.repositories;

import com.efsaplicativos.spring_boot_course_basic.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
