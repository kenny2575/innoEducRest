package ru.inno.educ.repository;

import ru.inno.educ.entity.ProductRegister;

import java.util.Optional;

public interface ProductRegisterRepository {
    Optional<ProductRegister> findByProductIdAndType(Long productId, String typeCode);
}
