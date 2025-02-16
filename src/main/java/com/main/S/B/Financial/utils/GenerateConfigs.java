package com.main.S.B.Financial.utils;

import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.Random;

@Configuration
public class GenerateConfigs {

    private static final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

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

    public String generateRandomPixKey(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 32; i++){
            int index = random.nextInt(characters.length());
            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString();

    }

}
