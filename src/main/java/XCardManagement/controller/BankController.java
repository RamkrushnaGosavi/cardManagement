package XCardManagement.controller;


import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Bank;
import XCardManagement.serviceImpl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @Autowired
    BankServiceImpl bankService;


    @PostMapping("/addBank")
    public ResponseEntity<StatusResponce> addBank(@RequestBody Bank bank)
    {

        StatusResponce addbank = bankService.addbank(bank);

        return new ResponseEntity<>(addbank , HttpStatus.CREATED);
    }
}
