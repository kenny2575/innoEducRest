package ru.inno.educ.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ArrangementInstance {
    private String generalArrangement;
    private String supplementaryAgreement;
    private String arrangementType;
    private Integer schedulerJobId;
    @NotNull
    private String number;
    @NotNull
    private Date openingDate;
    private Date closingDate;
    private Date cancelDate;
    private Integer validityDuration;
    private String cancelReason;
    private String status;
    private Date interestCalculationDate;
    private BigDecimal interestDate;
    private BigDecimal coefficient;
    private String coefficientAction;
    private BigDecimal minimumInterestRate;
    private String minimumInterestRateCoefficient;
    private String minimumInterestRateCoefficientAction;
    private BigDecimal maximumInterestRate;
    private BigDecimal maximumInterestRateCoefficient;
    private String maximumInterestRateCoefficientAction;
}
