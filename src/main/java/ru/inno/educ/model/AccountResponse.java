package ru.inno.educ.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonRootName("data")
public class AccountResponse {
    private String accountId;
}
