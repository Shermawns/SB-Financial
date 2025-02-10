package com.main.S.B.Financial.utils;

import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.Random;

@Configuration
public class GenerateConfigs {

    public String generateCardNumber() {
        var random = new Random();
        StringBuilder numberAccount = new StringBuilder("0");

        for (int i = 0; i < 15; i++) {
            numberAccount.append(random.nextInt(10));

                if ((i + 1) % 4 == 0 && i != 14) {
                    numberAccount.append(" ");
                }
        }

        return numberAccount.toString();
    }

    public String generateNumberAccount() {
        var random = new Random();
        StringBuilder numberAccount = new StringBuilder("0");

        for (int i = 0; i < 9; i++) {
            numberAccount.append(random.nextInt(10));
        }

        return numberAccount.toString();
    }

    public LocalDate generateValidateDate(){

        var entryDate = LocalDate.now();

        return entryDate.plusYears(10);
    }

    public Integer generateCvv(){
        var random = new Random();
        StringBuilder numberAccount = new StringBuilder("0");

        for (int i = 0; i < 3; i++) {
            numberAccount.append(random.nextInt(10));
        }

        return Integer.parseInt(numberAccount.toString());
    }

}
