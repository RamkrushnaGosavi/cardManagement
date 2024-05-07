package XCardManagement.controller;


import XCardManagement.dto.BankDto;
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
    public ResponseEntity<StatusResponce> addBank(@RequestBody BankDto bankDto)
    {

        StatusResponce addbank = bankService.addbank(bankDto);

        return new ResponseEntity<>(addbank , HttpStatus.CREATED);
    }
}
