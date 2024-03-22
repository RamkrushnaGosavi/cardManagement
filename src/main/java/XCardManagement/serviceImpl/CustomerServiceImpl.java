package XCardManagement.serviceImpl;


import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Bank;
import XCardManagement.entity.Customer;
import XCardManagement.repository.BankRepository;
import XCardManagement.repository.CustomerRepository;
import XCardManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BankRepository bankRepository;


    @Override
    public StatusResponce addCustomer(Customer customer, int bankCode) {


        Optional<Bank> bank = bankRepository.findById(bankCode);

        customer.setBank(bank.get());

        customerRepository.save(customer);

        return new StatusResponce(HttpStatus.CREATED.value(), "Customer Added" , "Success" );
    }
}
