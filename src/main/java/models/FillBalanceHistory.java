package models;

import enums.PaymentType;

import java.time.LocalDate;

public class FillBalanceHistory {
    private Long id;
    private LocalDate date;
    private Double amount;
    private Double totalAmount;
    private PaymentType paymentType;
    private User user;

    public FillBalanceHistory(Long id, LocalDate date, Double amount, Double totalAmount, PaymentType paymentMethod, User user) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.totalAmount = totalAmount;
        this.paymentType = paymentMethod;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentType getPaymentMethod() {
        return paymentType;
    }

    public void setPaymentMethod(PaymentType paymentMethod) {
        this.paymentType = paymentMethod;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("%1$-5s",id) +
                String.format("%1$-15s",date) +
                String.format("%1$-15s",amount) +
                String.format("%1$-15s",totalAmount) +
                String.format("%1$-10s",paymentType) +
                String.format("%1$-25s",user.getFirstName() + " " + user.getLastName() + "( " +user.getRole()+ " )");
    }
}
