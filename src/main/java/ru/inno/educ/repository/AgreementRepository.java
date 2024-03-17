package ru.inno.educ.repository;

import ru.inno.educ.entity.Agreement;

import java.util.List;

public interface AgreementRepository {
    List<Agreement> findAgreementsByNumber(List<String> number);
}
