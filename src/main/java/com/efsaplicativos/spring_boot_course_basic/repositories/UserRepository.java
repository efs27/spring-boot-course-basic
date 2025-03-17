package com.efsaplicativos.spring_boot_course_basic.repositories;

import com.efsaplicativos.spring_boot_course_basic.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
