package ru.inno.educ.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inno.educ.model.AccountRequest;
import ru.inno.educ.model.AccountResponse;
import ru.inno.educ.service.AccountService;

@RestController
@RequestMapping("/corporate-settlement-account")
@RequiredArgsConstructor
public class CorporateAccountController {

    private final AccountService accountService;
    @PostMapping("/create")
    ResponseEntity<AccountResponse> handleCreateAccount(@RequestBody @Validated AccountRequest request){
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(accountService.createAccount(request));
    }

}
