package ru.inno.educ.repository;

import ru.inno.educ.entity.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findByContractNumber(String contractNumber);
}
