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

        if(account != null)
        {
            Optional<Bank> bank = bankRepository.findById(account.getBankCode());
            Optional<Customer> customer = customerRepository.findById(account.getCustomerId());
            if(!bank.isEmpty() && !customer.isEmpty()) {
                Account account1 = convertDtoToEntity(account, bank.get(), customer.get());
                if(account1 != null)
                {
                    accountRepository.save(account1);
                }
            }
            else {
                return new StatusResponce(HttpStatus.BAD_REQUEST.value(), "Invalid bank_code "+account.getBankCode()+"OR Invalid Customer_Id "+account.getCustomerId() , "Unsuccessful");
            }

            return new StatusResponce(HttpStatus.CREATED.value(), "Account Created" , "Success");
        }

        if(account == null) {
            return new StatusResponce(HttpStatus.NO_CONTENT.value(), "Somthing went worng", "Unsuccessful");
        }

        return null ;
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
