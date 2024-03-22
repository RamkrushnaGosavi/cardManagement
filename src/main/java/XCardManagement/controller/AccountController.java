package XCardManagement.controller;


import XCardManagement.dto.AccountDto;
import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Account;
import XCardManagement.entity.Bank;
import XCardManagement.service.AccountService;
import XCardManagement.serviceImpl.AccountServiceImpl;
import XCardManagement.serviceImpl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;


    @PostMapping("/addAccount")
    public ResponseEntity<StatusResponce> addAccount(@RequestBody AccountDto account)
    {

        StatusResponce addAccount = accountService.addAccount(account);
        return new ResponseEntity<>(addAccount  , HttpStatus.CREATED);
    }

}
