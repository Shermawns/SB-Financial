package com.main.S.B.Financial.services;

import com.main.S.B.Financial.models.CreditCard;
import com.main.S.B.Financial.repositories.CreditCardRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepositor;

    public CreditCardService(CreditCardRepository creditCardRepositor) {
        this.creditCardRepositor = creditCardRepositor;
    }

    public CreditCard save(CreditCard creditCard){
        return creditCardRepositor.save(creditCard);
    }
}
