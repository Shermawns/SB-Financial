package com.main.S.B.Financial.services;

import com.main.S.B.Financial.models.BankAccount;
import com.main.S.B.Financial.models.PixKey;
import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.models.enums.PixType;
import com.main.S.B.Financial.repositories.BankAccountRepository;
import com.main.S.B.Financial.repositories.PixRepository;
import com.main.S.B.Financial.repositories.UserRepository;
import com.main.S.B.Financial.utils.GenerateConfigs;
import org.springframework.stereotype.Service;

import java.util.IllegalFormatCodePointException;
import java.util.List;

@Service
public class PixService {

    private final PixRepository pixRepository;
    private final GenerateConfigs generateConfigs;
    private final BankAccountRepository bankAccountRepository;
    private final UserRepository userRepository;

    public PixService(PixRepository pixRepository, GenerateConfigs generateConfigs, BankAccountRepository bankAccountRepository, UserRepository userRepository) {
        this.pixRepository = pixRepository;
        this.generateConfigs = generateConfigs;
        this.bankAccountRepository = bankAccountRepository;
        this.userRepository = userRepository;
    }


    public PixKey createPixKey(Long userId, Long bankId, PixType pixType){


        User user = userRepository.findById(userId).orElseThrow();
        BankAccount bankAccount = bankAccountRepository.findById(bankId).orElseThrow();

        if (user.getPixKeys().size() >= 5){
            throw new RuntimeException("You almost have 5 pix keys registered ");
        }

        String pixKey;

        switch (pixType) {
            case RANDOM:
                pixKey = generateConfigs.generateRandomPixKey();
                break;
            case CPF:
                pixKey = user.getCpf();
                break;
            case EMAIL:
                pixKey = user.getEmail();
                break;
            default:
                throw new IllegalArgumentException("Invalid type of pix key");
        }

        PixKey pix = new PixKey();
        pix.setUser(user);
        pix.setBankAccount(bankAccount);
        pix.setPixType(pixType);
        pix.setKey(pixKey);

        pixRepository.save(pix);

        return pix;
    }

    public List<PixKey> findPixKeysByUserId(Long userId) {
        return pixRepository.findByUserId(userId);
    }
}
