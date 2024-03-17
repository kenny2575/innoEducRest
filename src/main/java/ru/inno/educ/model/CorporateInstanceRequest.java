package ru.inno.educ.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class CorporateInstanceRequest {
    @JsonProperty(value = "instanceId", required = true)
    private Integer instanceId;
    @NotNull
    private String productType;
    @NotNull
    private String productCode;
    @NotNull
    private String registerType;
    @NotNull
    private String mdmCode;
    @NotNull
    private String contractNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date contractDate;
    @NotNull
    private Integer priority;
    private BigDecimal interestRatePenalty;
    private BigDecimal minimalBalance;
    private BigDecimal thresholdAmount;
    private String accountingDetails;
    private String rateType;
    private BigDecimal taxPercentageRate;
    private BigDecimal technicalOverdraftLimitAmount;
    @NotNull
    private Integer contractId;
    @NotNull
    private String branchCode;
    @NotNull
    private String isoCurrencyCode;
    @NotNull
    private String urgencyCode;
    private Integer referenceCode;
    private List<AdditionalProperties> additionalPropertiesVip;
    @Valid
    private List<ArrangementInstance> instanceArrangement;
}
