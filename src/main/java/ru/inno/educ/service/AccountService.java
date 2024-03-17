package ru.inno.educ.service;

import ru.inno.educ.model.AccountRequest;
import ru.inno.educ.model.AccountResponse;

public interface AccountService {
    AccountResponse createAccount(AccountRequest request);
}
