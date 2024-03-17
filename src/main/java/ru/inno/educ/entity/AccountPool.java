package ru.inno.educ.entity;

import lombok.Data;

import java.util.List;

@Data
public class AccountPool {
    private Long id;
    private String branchCode;
    private String currencyCode;
    private String mdmCode;
    private String priorityCode;
    private String registryTypeCode;
    private List<Account> accountList;
}
