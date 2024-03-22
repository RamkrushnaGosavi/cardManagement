package XCardManagement.controller;


import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Bank;
import XCardManagement.entity.Customer;
import XCardManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {



    @Autowired
    CustomerService customerService ;

    @PostMapping("/addCustomer/{bankCode}")
    public ResponseEntity<StatusResponce> addCustomer(@RequestBody Customer customer , @PathVariable int bankCode)
    {

        StatusResponce addbank = customerService.addCustomer(customer , bankCode);

        return new ResponseEntity<>(addbank , HttpStatus.CREATED);
    }

}
