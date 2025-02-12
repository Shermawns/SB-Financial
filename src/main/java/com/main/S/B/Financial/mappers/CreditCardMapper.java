package com.main.S.B.Financial.mappers;

import com.main.S.B.Financial.controller.response.CreditCardResponse;
import com.main.S.B.Financial.models.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {

    private final UserMapper userMapper;
    private final BankMapper bankMapper;
    public CreditCardMapper(UserMapper userMapper, BankMapper bankMapper) {
        this.userMapper = userMapper;
        this.bankMapper = bankMapper;
    }

    public CreditCardResponse toResponse(CreditCard creditCard){
        return new CreditCardResponse(
                creditCard.getId(),
                userMapper.toResponse(creditCard.getUserId()),
                creditCard.getBankId(),
                creditCard.getCard_number(),
                creditCard.getValidate_date(),
                creditCard.getCvv(),
                creditCard.getCredit_limit(),
                creditCard.getInvoice(),
                creditCard.getMinimum_payment()
        );
    }
}
