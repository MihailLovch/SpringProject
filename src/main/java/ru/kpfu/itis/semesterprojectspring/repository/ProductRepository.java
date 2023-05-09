package ru.kpfu.itis.semesterprojectspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.semesterprojectspring.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
