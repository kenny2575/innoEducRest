package ru.inno.educ.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.educ.exception.AlreadyExistException;
import ru.inno.educ.exception.NoDataFoundException;
import ru.inno.educ.model.ArrangementInstance;
import ru.inno.educ.model.CorporateInstanceRequest;
import ru.inno.educ.model.CorporateInstanceResponse;
import ru.inno.educ.repository.AgreementRepository;
import ru.inno.educ.repository.ProductRepository;
import ru.inno.educ.repository.ProductRegisterTypeRepository;
import ru.inno.educ.service.InstanceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstanceServiceImpl implements InstanceService {

    private final ProductRepository productRepository;
    private final AgreementRepository agreementRepository;
    private final ProductRegisterTypeRepository registerRepository;

    @Override
    public CorporateInstanceResponse saveInstance(CorporateInstanceRequest request) {

        var product = productRepository.findByContractNumber(request.getContractNumber());

        if (product.isPresent())
            throw new AlreadyExistException("Параметр ContractNumber № договора " +
                    request.getContractNumber() +
                    " уже существует для ЭП с ИД  " +
                    product.get().getId() + ".");

        checkAgreement(request.getInstanceArrangement());

        var registers = registerRepository.findProductRegisterByCode(request.getProductCode());
        if (registers == null || registers.isEmpty())
            throw new NoDataFoundException("КодПродукта " + request.getProductCode() + " не найдено в Каталоге продуктов tpp_ref_product_class");

        return new CorporateInstanceResponse();
    }

    private void checkAgreement(List<ArrangementInstance> arrangementList){
        if (arrangementList == null || arrangementList.isEmpty())
            return;

        var agreement = agreementRepository.findAgreementsByNumber(
                arrangementList
                        .stream()
                        .map(ArrangementInstance::getNumber)
                        .collect(Collectors.toList())
        );
        if (!agreement.isEmpty())
            throw new AlreadyExistException("Параметр № Дополнительного соглашения (сделки) " +
                    agreement.get(0).getNumber() +
                    " уже существует для ЭП с ИД  " +
                    agreement.get(0).getProductId() + ".");
    }
}
