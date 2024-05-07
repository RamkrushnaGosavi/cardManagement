package XCardManagement.service;

import XCardManagement.dto.BankDto;
import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Bank;

public interface BankService {

    public StatusResponce addbank(BankDto bankDto);
}
