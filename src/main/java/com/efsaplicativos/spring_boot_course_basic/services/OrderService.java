package com.efsaplicativos.spring_boot_course_basic.services;

import com.efsaplicativos.spring_boot_course_basic.dtos.OrderDto;
import com.efsaplicativos.spring_boot_course_basic.dtos.OrderItemDto;
import com.efsaplicativos.spring_boot_course_basic.entities.Order;
import com.efsaplicativos.spring_boot_course_basic.entities.OrderItem;
import com.efsaplicativos.spring_boot_course_basic.entities.Product;
import com.efsaplicativos.spring_boot_course_basic.entities.User;
import com.efsaplicativos.spring_boot_course_basic.enuns.OrderStatus;
import com.efsaplicativos.spring_boot_course_basic.exceptions.ResourceNotFoundException;
import com.efsaplicativos.spring_boot_course_basic.repositories.OrderItemRepository;
import com.efsaplicativos.spring_boot_course_basic.repositories.OrderRepository;
import com.efsaplicativos.spring_boot_course_basic.repositories.ProductRepository;
import com.efsaplicativos.spring_boot_course_basic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        Order order = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDto(order);
    }

    @Transactional
    public OrderDto save(OrderDto dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setOrderStatus(OrderStatus.WAITING_PAYMENT);

        User user = userRepository.getReferenceById(order.getClient().getId());
        order.setClient(user);

        for (OrderItemDto itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDto(order);
    }
}
