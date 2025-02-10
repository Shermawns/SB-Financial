package com.main.S.B.Financial.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@AllArgsConstructor
@Entity
@Table(name = "tb_credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_owner_id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankId;

    private String card_number;

    private LocalDate validate_date;

    private Integer cvv;

    private BigDecimal credit_limit;

    private BigDecimal invoice;

    private BigDecimal minimum_payment;

    public CreditCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public BankAccount getBankId() {
        return bankId;
    }

    public void setBankId(BankAccount bankId) {
        this.bankId = bankId;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public LocalDate getValidate_date() {
        return validate_date;
    }

    public void setValidate_date(LocalDate validate_date) {
        this.validate_date = validate_date;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public BigDecimal getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(BigDecimal credit_limit) {
        this.credit_limit = credit_limit;
    }

    public BigDecimal getInvoice() {
        return invoice;
    }

    public void setInvoice(BigDecimal invoice) {
        this.invoice = invoice;
    }

    public BigDecimal getMinimum_payment() {
        return minimum_payment;
    }

    public void setMinimum_payment(BigDecimal minimum_payment) {
        this.minimum_payment = minimum_payment;
    }
}
