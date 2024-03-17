package ru.inno.educ.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class AccountRequest {
    @NotNull
    @JsonProperty("instanceId")
    private Long instanceId;
    @JsonProperty("registryTypeCode")
    private String registryTypeCode;
    @JsonProperty("accountType")
    private String accountType;
    @JsonProperty("currencyCode")
    @Length(min = 3, max = 3)
    private String currencyCode;
    @JsonProperty("branchCode")
    private String branchCode;
    @JsonProperty("priorityCode")
    private String priorityCode;
    @JsonProperty("mdmCode")
    private String mdmCode;
    @JsonProperty("clientCode")
    private String clientCode;
    @JsonProperty("trainRegion")
    private String trainRegion;
    @JsonProperty("counter")
    private String counter;
    @JsonProperty("salesCode")
    private String salesCode;

}
