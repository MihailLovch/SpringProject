package ru.kpfu.itis.semesterprojectspring.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.semesterprojectspring.model.entity.Product;
import ru.kpfu.itis.semesterprojectspring.repository.ProductRepository;
import ru.kpfu.itis.semesterprojectspring.service.ProductService;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product with id = " + id + " not found"));
    }
}
