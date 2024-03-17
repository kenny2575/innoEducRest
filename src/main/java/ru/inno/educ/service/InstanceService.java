package ru.inno.educ.service;

import ru.inno.educ.model.CorporateInstanceRequest;
import ru.inno.educ.model.CorporateInstanceResponse;

public interface InstanceService {
    CorporateInstanceResponse saveInstance(CorporateInstanceRequest request);
}