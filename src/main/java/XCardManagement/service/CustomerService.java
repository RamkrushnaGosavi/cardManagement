package XCardManagement.service;

import XCardManagement.dto.CustomerDto;
import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Customer;

public interface CustomerService {


    public StatusResponce addCustomer(CustomerDto customerDto, int bankCode);
}
