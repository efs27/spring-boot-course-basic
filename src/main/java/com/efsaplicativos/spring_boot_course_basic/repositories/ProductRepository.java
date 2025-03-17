package com.efsaplicativos.spring_boot_course_basic.repositories;

import com.efsaplicativos.spring_boot_course_basic.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
