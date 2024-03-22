package XCardManagement.service;

import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Customer;

public interface CustomerService {


    public StatusResponce addCustomer(Customer customer, int bankCode);
}
