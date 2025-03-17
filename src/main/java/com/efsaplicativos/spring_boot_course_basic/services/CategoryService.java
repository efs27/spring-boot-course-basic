package com.efsaplicativos.spring_boot_course_basic.services;

import com.efsaplicativos.spring_boot_course_basic.dtos.CategoryDto;
import com.efsaplicativos.spring_boot_course_basic.entities.Category;
import com.efsaplicativos.spring_boot_course_basic.exceptions.DatabaseException;
import com.efsaplicativos.spring_boot_course_basic.exceptions.ResourceNotFoundException;
import com.efsaplicativos.spring_boot_course_basic.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new CategoryDto(category);
    }

    @Transactional(readOnly = true)
    public List<CategoryDto> findAll() {
        List<Category> categories = repository.findAll();
        return categories.stream().map(CategoryDto::new).toList();
    }

    @Transactional
    public CategoryDto save(CategoryDto dto) {
        Category category = new Category();
        BeanUtils.copyProperties(dto, category);
        category = repository.save(category);
        return new CategoryDto(category);
    }

    @Transactional
    public CategoryDto update(Long id, CategoryDto dto) {
        try {
            Category category = repository.getReferenceById(id);
            BeanUtils.copyProperties(dto, category);
            category = repository.save(category);
            return new CategoryDto(category);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Categoria não encontrada");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Categoria não encontrada");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}
