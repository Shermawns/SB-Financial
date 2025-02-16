package com.main.S.B.Financial.models;
import com.main.S.B.Financial.models.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
@Table(name = "tb_users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CPF(message = "Invalid CPF. Please enter a valid CPF following the format XXX.XXX.XXX-XX.")
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Email(message = "Invalid email address. Please enter a valid email in the format example@domain.com.")
    private String email;

    private String password;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BankAccount> bank_account = new ArrayList<>();

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<CreditCard> creditCards = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.ROLE_CLIENT;

    public User() {
    }

    public User(Long id, String name, String cpf, Address address, String email, String password, List<BankAccount> bank_account, List<CreditCard> creditCards, UserRole role) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.email = email;
        this.password = password;
        this.bank_account = bank_account;
        this.creditCards = creditCards;
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ROLE_ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BankAccount> getBank_account() {
        return bank_account;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }


    public List<CreditCard> getCreditCards() {
        return creditCards;
    }


}
