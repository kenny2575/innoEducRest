package ru.inno.educ.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Agreement {
    private Long id;
    private Long productId;
    private String generalAgreementId;
    private String supplementaryAgreementId;
    private String arrangementType;
    private Long scheduledJobId;
    private String number;
    private Date openningDate;
    private Date closingDate;
    private Date cancelDate;
    private Long validityDuration;
    private String cancellationReason;
    private String status;
    private Date interestCalculationDate;
    private BigDecimal interestRate;
    private BigDecimal coefficient;
    private String coefficientAction;
    private BigDecimal minimumInterestRate;
    private BigDecimal minimumInterestRateCoefficient;
    private String minimumInterestRateCoefficientAction;
    private BigDecimal maximumInterestRate;
    private BigDecimal maximumInterestRateCoefficient;
    private String maximumInterestRateCoefficientAction;
}
