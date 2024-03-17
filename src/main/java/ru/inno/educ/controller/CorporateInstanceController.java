package ru.inno.educ.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inno.educ.model.CorporateInstanceRequest;
import ru.inno.educ.model.CorporateInstanceResponse;
import ru.inno.educ.service.InstanceService;


@RestController
@RequestMapping("/corporate-settlement-instance")
@RequiredArgsConstructor
public class CorporateInstanceController {

    private final InstanceService instanceService;

    @PostMapping("/create")
    ResponseEntity<CorporateInstanceResponse> handleCreateCorporateInstance(@RequestBody @Validated CorporateInstanceRequest request) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(instanceService.saveInstance(request));
    }
}
