package com.efsaplicativos.spring_boot_course_basic.repositories;

import com.efsaplicativos.spring_boot_course_basic.entities.OrderItem;
import com.efsaplicativos.spring_boot_course_basic.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
