package ru.inno.educ.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inno.educ.exception.AlreadyExistException;
import ru.inno.educ.exception.NoDataFoundException;
import ru.inno.educ.model.AccountRequest;
import ru.inno.educ.model.AccountResponse;
import ru.inno.educ.repository.ProductRegisterRepository;
import ru.inno.educ.repository.ProductRegisterTypeRepository;
import ru.inno.educ.service.AccountService;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final ProductRegisterRepository registerRepository;
    private final ProductRegisterTypeRepository registerTypeRepository;


    @Override
    public AccountResponse createAccount(AccountRequest request) {
        var productRegisters = registerRepository.findByProductIdAndType(request.getInstanceId(), request.getRegistryTypeCode());
        if (productRegisters.isPresent())
            throw new AlreadyExistException("Параметр registryTypeCode тип регистра " + request.getRegistryTypeCode() + " уже существует для ЭП с ИД " + request.getInstanceId());

        var registerType = registerTypeRepository.findProductRegisterTypeByValue(request.getRegistryTypeCode());

        if (registerType == null || registerType.isEmpty())
            throw new NoDataFoundException("Код Продукта " + request.getRegistryTypeCode() + " не найдено в Каталоге продуктов для данного типа Регистра");



        return new AccountResponse("Test");
    }
}
