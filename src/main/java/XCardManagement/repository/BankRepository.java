package XCardManagement.repository;

import XCardManagement.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Integer>  {


    @Override
    Optional<Bank> findById(Integer bankCode);
}
