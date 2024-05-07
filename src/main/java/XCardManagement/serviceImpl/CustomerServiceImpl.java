package XCardManagement.serviceImpl;


import XCardManagement.dto.CustomerDto;
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
    public StatusResponce addCustomer(CustomerDto customerDto, int bankCode) {

        if(customerDto != null && !(bankCode <= 0) ) {
            Optional<Bank> bank = bankRepository.findById(bankCode);
            if(!bank.isEmpty()) {
                Customer customer = this.convertDtoToEntity(customerDto);
                customer.setBank(bank.get());
                customerRepository.save(customer);
                return new StatusResponce(HttpStatus.CREATED.value(), "Customer Added", "Success");
            }
            else {
                return new StatusResponce(HttpStatus.BAD_REQUEST.value(), "Invalid Bank_Code "+bankCode, "Unsuccessful");
            }
        }
        else{
            return new StatusResponce(HttpStatus.NO_CONTENT.value(), "Customer Not Added", "Unsuccessful");
        }
    }
    
    public Customer convertDtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();

        customer.setfName(customerDto.getfName());
        customer.setlName(customerDto.getlName());
        customer.setCustomrId(customerDto.getCustomrId());
        customer.setpR_Address(customerDto.getpR_Address());
        customer.settP_Address(customerDto.gettP_Address());

        return customer;
    }
}
