package XCardManagement.serviceImpl;


import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Bank;
import XCardManagement.repository.BankRepository;
import XCardManagement.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService
{

    @Autowired
    BankRepository bankRepository ;

    @Override
    public StatusResponce addbank(Bank bank) {


         bankRepository.save(bank);

        return new StatusResponce(HttpStatus.CREATED.value(), "Bank Created" , "Success");
    }
}
