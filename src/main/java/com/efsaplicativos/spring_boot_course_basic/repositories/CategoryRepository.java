package com.efsaplicativos.spring_boot_course_basic.repositories;

import com.efsaplicativos.spring_boot_course_basic.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
