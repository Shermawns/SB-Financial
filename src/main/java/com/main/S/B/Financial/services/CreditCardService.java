package com.main.S.B.Financial.services;

import com.main.S.B.Financial.models.CreditCard;
import com.main.S.B.Financial.repositories.CreditCardRepository;
import com.main.S.B.Financial.utils.GenerateConfigs;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepositor;
    private final GenerateConfigs generateConfigs;

    public CreditCardService(CreditCardRepository creditCardRepositor, GenerateConfigs generateConfigs) {
        this.creditCardRepositor = creditCardRepositor;
        this.generateConfigs = generateConfigs;
    }

    public CreditCard save(CreditCard creditCard){
        return creditCardRepositor.save(creditCard);
    }
}
