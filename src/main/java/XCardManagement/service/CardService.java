package XCardManagement.service;

import XCardManagement.dto.CardDto;
import XCardManagement.dto.StatusResponce;

public interface CardService {

    StatusResponce addCard(CardDto cardDto);
}
