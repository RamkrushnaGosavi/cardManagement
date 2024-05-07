package XCardManagement.serviceImpl;


import XCardManagement.dto.BankDto;
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
    public StatusResponce addbank(BankDto bankDto) {

        if(bankDto != null) {

           Bank bank =  this.convertDtotoEntity(bankDto);
            bankRepository.save(bank);
            return new StatusResponce(HttpStatus.CREATED.value(), "Bank Created" , "Success");
        }
        else
        {
            return new StatusResponce(HttpStatus.BAD_REQUEST.value(), "Bank Not Created" , "Unsuccessful");
        }
    }

   public Bank convertDtotoEntity(BankDto bankDto)
    {
        Bank bank = new Bank();
        bank.setBankCode(bankDto.getBankCode());
        bank.setBankName(bankDto.getBankName());
        bank.setBranchCode(bankDto.getBranchCode());
        bank.setBranchName(bankDto.getBranchName());
        return bank;
    }
}
