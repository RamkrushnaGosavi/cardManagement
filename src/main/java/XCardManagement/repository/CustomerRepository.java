package XCardManagement.repository;

import XCardManagement.entity.Account;
import XCardManagement.entity.Customer;
import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {



}
