package ru.inno.educ.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {
    private Long id;
    private Long productCode;
    private Long clientId;
    private String type;
    private String number;
    private Long priority;
    private Date dateOfConclusion;
    private Date startDateTime;
    private Date endDateTime;
    private Long days;
    private BigDecimal penaltyRate;
    private BigDecimal nso;
    private BigDecimal thresholdAmount;
    private String requisiteType;
    private String interestRateType;
    private BigDecimal taxRate;
    private String reasonClose;
    private String state;
}
