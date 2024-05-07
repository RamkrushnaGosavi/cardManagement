package XCardManagement.serviceImpl;


import XCardManagement.dto.AccountDto;
import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Account;
import XCardManagement.entity.Bank;
import XCardManagement.entity.Customer;
import XCardManagement.repository.AccountRepository;
import XCardManagement.repository.BankRepository;
import XCardManagement.repository.CustomerRepository;
import XCardManagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    BankRepository bankRepository;

    @Autowired
    CustomerRepository  customerRepository;

    @Override
    public StatusResponce addAccount(AccountDto account) {

        Optional<Bank> bank = bankRepository.findById(account.getBankCode());
        Optional<Customer> customer = customerRepository.findById(account.getCustomerId());
        Account account1 = convertDtoToEntity(account, bank.get(), customer.get());
        accountRepository.save(account1);
        return new StatusResponce(HttpStatus.CREATED.value(), "Account Created" , "Success");
    }


    public Account convertDtoToEntity(AccountDto accountDto , Bank bank , Customer customer)
    {

        Account account = new Account();

        account.setBank(bank);
        account.setCustomer(customer);
        account.setAccountStatus(accountDto.getAccountStatus());
        account.setAccountType(accountDto.getAccountType());
        account.setAccountWlLimit(accountDto.getAccountWlLimit());
        account.setAccountOpeningDate(accountDto.getAccountOpeningDate());
        account.setMinimumMaintainBal(accountDto.getMinimumMaintainBal());

        return account;
    }
}
