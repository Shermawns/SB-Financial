package com.main.S.B.Financial.controller;

import com.main.S.B.Financial.controller.requests.CreditCardRequest;
import com.main.S.B.Financial.controller.response.CreditCardResponse;
import com.main.S.B.Financial.mappers.CreditCardMapper;
import com.main.S.B.Financial.models.BankAccount;
import com.main.S.B.Financial.models.CreditCard;
import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.services.BankAccountService;
import com.main.S.B.Financial.services.CreditCardService;
import com.main.S.B.Financial.services.UserService;
import com.main.S.B.Financial.utils.GenerateConfigs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "api/V1/creditCard")
public class CreditCardController {

    private final CreditCardService creditCardService;
    private final GenerateConfigs generateConfigs;
    private final BankAccountService bankAccountService;
    private final CreditCardMapper creditCardMapper;
    private final UserService userService;

    public CreditCardController(CreditCardService creditCardService, GenerateConfigs generateConfigs, BankAccountService bankAccountService, CreditCardMapper creditCardMapper, UserService userService) {
        this.creditCardService = creditCardService;
        this.generateConfigs = generateConfigs;
        this.bankAccountService = bankAccountService;
        this.creditCardMapper = creditCardMapper;
        this.userService = userService;
    }


    @PostMapping(value = "/create")
    public ResponseEntity<CreditCardResponse> create(@RequestBody CreditCardRequest creditCardRequest, @AuthenticationPrincipal User user) {

        if (user.getBank_account() == null || user.getBank_account().isEmpty()) {
            throw new RuntimeException("The user doesn't have any bank account.");
        }

        BankAccount bankAccount = bankAccountService.findById(creditCardRequest.bankId())
                .orElseThrow(() -> new RuntimeException("Bank Account not found."));


        User user1 = userService.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("The user doesn't exist."));


        CreditCard newCreditCard = new CreditCard();
        newCreditCard.setUserId(user1);
        newCreditCard.setBankId(bankAccount);
        newCreditCard.setInvoice(BigDecimal.valueOf(0));
        newCreditCard.setMinimum_payment(BigDecimal.valueOf(0));
        newCreditCard.setCard_number(generateConfigs.generateCardNumber());
        newCreditCard.setValidate_date(generateConfigs.generateValidateDate());
        newCreditCard.setCvv(generateConfigs.generateCvv());
        newCreditCard.setCredit_limit(BigDecimal.valueOf(100));


        CreditCard savedCreditCard = creditCardService.save(newCreditCard);

        return ResponseEntity.status(HttpStatus.CREATED).body(creditCardMapper.toResponse(savedCreditCard));
    }

}
