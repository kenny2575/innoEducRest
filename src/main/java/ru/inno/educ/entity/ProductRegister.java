package ru.inno.educ.entity;

import lombok.Data;

@Data
public class ProductRegister {
    private Long id;
    private Long productId;
    private String type;
    private Long account;
    private String currencyCode;
    private String state;
    private String accountNumber;
}
