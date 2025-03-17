package com.efsaplicativos.spring_boot_course_basic.services;

import com.efsaplicativos.spring_boot_course_basic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
}
