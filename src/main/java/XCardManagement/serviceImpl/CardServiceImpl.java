package XCardManagement.serviceImpl;

import XCardManagement.dto.CardDto;
import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Account;
import XCardManagement.entity.Bank;
import XCardManagement.entity.Card;
import XCardManagement.entity.Customer;
import XCardManagement.repository.AccountRepository;
import XCardManagement.repository.CardRepository;
import XCardManagement.repository.CustomerRepository;
import XCardManagement.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CardRepository cardRepository;
    @Override
    public StatusResponce addCard(CardDto cardDto) {
        if(cardDto != null && checkDuplicateCardNumber(cardDto.getCardNumber()))
        {
            Optional<Customer> customer = customerRepository.findById(cardDto.getCustomrId());
            if(!customer.isEmpty()) {
                    List<Account> accountDetails = getAccountDetails(customer.get().getCustomrId());
                    if(!accountDetails.isEmpty()) {
                        Bank bankDetails = accountDetails.get(0).getBank();
                        cardRepository.save(this.convertDtoToEntity(cardDto, customer.get(), accountDetails.get(0), bankDetails));
                        return new StatusResponce(HttpStatus.CREATED.value(), "Card Created", "Success");
                    }
                    else {
                        return new StatusResponce(HttpStatus.BAD_REQUEST.value(), "Account not found for ID " + cardDto.getCustomrId(), "Failed");
                    }
            }
            else {
                return new StatusResponce(HttpStatus.BAD_REQUEST.value(), "Customer not found for ID " + cardDto.getCustomrId(), "Failed");
            }
        }
        else
        {
            return  new StatusResponce(HttpStatus.NO_CONTENT.value(), "Null or duplicate card number" , "Unsuccessful");
        }
    }
    private boolean checkDuplicateCardNumber(double cardNumber) {
        Optional<Card> byId = cardRepository.findById(cardNumber);
        if(byId.isEmpty())
            return true;
        return false;
    }
    public List<Account> getAccountDetails(int customerID){
        List<Account> byCustomerId = accountRepository.findByCustomer_customrId(customerID);
        return byCustomerId;
    }
    public Card convertDtoToEntity(CardDto cardDto , Customer customer , Account account , Bank bank)
    {
        Card card = new Card();
        card.setAccount(account);
        card.setBank(bank);
        card.setCardLimit(cardDto.getCardLimit());
        card.setCardBal(cardDto.getCardBal());
        card.setCardType(cardDto.getCardType());
        card.setCardNumber(cardDto.getCardNumber());
        card.setAccountHolder(customer);
        card.setDueAmount(cardDto.getDueAmount());
        card.setExpriryDate(cardDto.getExpriryDate());
        card.setIssuingDate(cardDto.getIssuingDate());
        return card;
    }
}
