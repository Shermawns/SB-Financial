package com.main.S.B.Financial.container;

import com.main.S.B.Financial.container.TestContainers;
import com.main.S.B.Financial.models.Address;
import com.main.S.B.Financial.models.User;
import com.main.S.B.Financial.models.enums.UserRole;
import com.main.S.B.Financial.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest extends TestContainers {


    @Autowired
    private UserRepository userRepository;

    private User savedUser;



    @BeforeEach
    void setUp() {
        Address address = new Address();
        address.setStreet("Rua Exemplo");
        address.setCity("São Paulo");
        address.setState("SP");
        address.setZipCode("01000-000");

        User user = new User();
        user.setName("Shermann");
        user.setCpf("555555555");
        user.setEmail("shermann@example.com");
        user.setPassword("securepassword");
        user.setAddress(address);
        user.setRole(UserRole.ROLE_CLIENT);

        savedUser = userRepository.save(user);
    }

    @AfterEach
    void cleanDatabase() {
        userRepository.deleteAll();
    }


    @Test
    void findById(){
        Optional<User> foundUser = userRepository.findById(savedUser.getId());
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getId()).isEqualTo(savedUser.getId());
        assertThat(foundUser.get().getName()).isEqualTo("Shermann");
        assertThat(foundUser.get().getEmail()).isEqualTo("shermann@example.com");

        assertThat(foundUser.get().getAddress().getStreet()).isEqualTo("Rua Exemplo");
        assertThat(foundUser.get().getAddress().getCity()).isEqualTo("São Paulo");
        assertThat(foundUser.get().getAddress().getState()).isEqualTo("SP");
        assertThat(foundUser.get().getAddress().getZipCode()).isEqualTo("01000-000");
    }
}
