package models;

import enums.Currency;

public class Account {
    private Long id;
    private Long accountNumber;
    private Integer password;
    private Double balance;
    private Currency currency;
    private boolean isActive;

    public Account(Long id, Long accountNumber, Integer password, Double balance, Currency currency, boolean isActive) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = balance;
        this.currency = currency;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    public void addBalance(Double amount){
        this.balance += amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return String.format("%1$-5s",id) +
                String.format("%1$-15s", accountNumber) +
                String.format("%1$-15s", balance + " " + currency) +
                String.format("%1$-10s",isActive);
    }

    /**
     * Refill balance and return the current balance amount
     * @param amount amount to refill
     * @return current balance
     */
    public Double refill(Double amount) {
        balance += amount;
        return balance;
    }
}
