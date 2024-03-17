package ru.inno.educ.repository;

import ru.inno.educ.entity.AccountPool;

public interface AccountPoolRepository {
    AccountPool findPool(String branchCode, String currencyCode, String mdmCode, String priorityCode, String registryTypeCode);
}
