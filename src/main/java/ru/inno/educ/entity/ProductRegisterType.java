package ru.inno.educ.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductRegisterType {
    private Long id;
    private String value;
    private String registerTypeName;
    private String productClassCode;
    private Date startDate;
    private Date endDate;
    private String accountType;
}
