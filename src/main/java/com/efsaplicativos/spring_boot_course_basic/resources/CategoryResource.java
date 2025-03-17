package com.efsaplicativos.spring_boot_course_basic.resources;

import com.efsaplicativos.spring_boot_course_basic.dtos.CategoryDto;
import com.efsaplicativos.spring_boot_course_basic.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> dtos = service.findAll();
        return ResponseEntity.ok(dtos);
    }
}
