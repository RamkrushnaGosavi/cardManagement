package XCardManagement.serviceImpl;


import XCardManagement.dto.AccountDto;
import XCardManagement.dto.CardDto;
import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Account;
import XCardManagement.entity.Bank;
import XCardManagement.entity.Card;
import XCardManagement.entity.Customer;
import XCardManagement.repository.CardRepository;
import XCardManagement.repository.CustomerRepository;
import XCardManagement.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CardRepository cardRepository;

    @Override
    public StatusResponce addCard(CardDto cardDto) {


        Optional<Customer> customer = customerRepository.findById(cardDto.getCustomrId());

        cardRepository.save(this.convertDtoToEntity(cardDto, customer.get()));

        return  new StatusResponce(HttpStatus.CREATED.value(), "Card Created" , "Success");
    }


    public Card convertDtoToEntity(CardDto cardDto , Customer customer)
    {
        Card card = new Card();

        card.setCardLimit(cardDto.getCardLimit());
        card.setCardBal(cardDto.getCardBal());
        card.setCardNumber(cardDto.getCardNumber());
        card.setAccountHolder(customer);
        card.setDueAmount(cardDto.getDueAmount());
        card.setExpriryDate(cardDto.getExpriryDate());
        card.setIssuingDate(cardDto.getIssuingDate());

        return card;
    }

}
