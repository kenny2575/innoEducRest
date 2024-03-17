package ru.inno.educ.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.List;

@Data
@JsonRootName("data")
public class CorporateInstanceResponse {
    @JsonProperty("instanceId")
    private String instanceId;
    @JsonProperty("registerId")
    private List<Integer> registerId;
    @JsonProperty("supplementaryAgreementId")
    private List<String> supplementaryAgreementId;
}
