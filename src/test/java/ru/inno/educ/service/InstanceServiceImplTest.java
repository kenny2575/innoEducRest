package ru.inno.educ.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.inno.educ.entity.Agreement;
import ru.inno.educ.entity.Product;
import ru.inno.educ.exception.AlreadyExistException;
import ru.inno.educ.exception.NoDataFoundException;
import ru.inno.educ.model.ArrangementInstance;
import ru.inno.educ.model.CorporateInstanceRequest;
import ru.inno.educ.repository.AgreementRepository;
import ru.inno.educ.repository.ProductRegisterTypeRepository;
import ru.inno.educ.repository.ProductRepository;
import ru.inno.educ.service.impl.InstanceServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InstanceServiceImplTest {

    @Mock
    ProductRepository productRepository;
    @Mock
    AgreementRepository agreementRepository;

    @Mock
    ProductRegisterTypeRepository registerRepository;

    @InjectMocks
    InstanceServiceImpl service;


    @Test
    void saveInstanceWhenFindProdByContractNumberIsNotNullThenThrowException(){
        var request = new CorporateInstanceRequest();
        request.setContractId(new Random().nextInt());
        var resultSet = Optional.of(new Product());

        doReturn(resultSet)
                .when(this.productRepository)
                .findByContractNumber(request.getContractNumber());

        //then
        assertThrows(AlreadyExistException.class, () -> service.saveInstance(request));

    }

    @Test
    void saveInstanceWhenFindAgreementByNumberIsNotNullThenThrownException(){
        var request = new CorporateInstanceRequest();
        var agreement = new ArrangementInstance();
        agreement.setNumber("SomeNumber");
        request.setInstanceArrangement(List.of(agreement));

        var resultSet = List.of(new Agreement(), new Agreement());

        doReturn(resultSet)
                .when(this.agreementRepository)
                .findAgreementsByNumber(request
                        .getInstanceArrangement()
                        .stream()
                        .map(ArrangementInstance::getNumber)
                        .collect(Collectors.toList()));

        //then
        assertThrows(AlreadyExistException.class, () -> service.saveInstance(request));
    }

    @Test
    void saveInstanceWhenFindRegisterByCodeIsNullThenThrownException(){
        var request = new CorporateInstanceRequest();
        doReturn(null)
                .when(this.registerRepository)
                .findProductRegisterByCode(request.getProductCode());

        //then
        assertThrows(NoDataFoundException.class, () -> service.saveInstance(request));
    }
}