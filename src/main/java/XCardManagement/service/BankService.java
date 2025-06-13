package XCardManagement.service;

import XCardManagement.dto.BankDto;
import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Bank;

import java.util.List;

public interface BankService {

    public StatusResponce addbank(BankDto bankDto);

    public List<BankDto> getAllBank();
}
