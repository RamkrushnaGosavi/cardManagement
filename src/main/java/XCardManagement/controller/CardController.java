package XCardManagement.controller;


import XCardManagement.dto.CardDto;
import XCardManagement.dto.StatusResponce;
import XCardManagement.entity.Card;
import XCardManagement.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/addCard")
    public ResponseEntity<StatusResponce>  addCard(@RequestBody  CardDto cardDto)
    {
        StatusResponce statusResponce = cardService.addCard(cardDto);

        return new ResponseEntity<>(statusResponce , HttpStatus.CREATED);
    }

}
