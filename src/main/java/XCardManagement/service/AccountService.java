package XCardManagement.service;

import XCardManagement.dto.AccountDto;
import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Account;

public interface AccountService {

    public StatusResponce addAccount(AccountDto account);
}
