package ru.kpfu.itis.semesterprojectspring.service;

import ru.kpfu.itis.semesterprojectspring.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product findById(Long id);
}
