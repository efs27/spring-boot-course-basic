package com.efsaplicativos.spring_boot_course_basic.resources;

import com.efsaplicativos.spring_boot_course_basic.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Paulo Silva", "paulo@gmail.com", "988283524", "123456");
        return ResponseEntity.ok().body(u);
    }
}
