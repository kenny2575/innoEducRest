package ru.inno.educ.repository;

import ru.inno.educ.entity.ProductRegisterType;

import java.util.List;

public interface ProductRegisterTypeRepository {
    List<ProductRegisterType> findProductRegisterByCode(String productCode);

    List<ProductRegisterType> findProductRegisterTypeByValue(String value);
}
