package models;

import enums.Role;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Account account;
    private PaymentMethod paymentMethod;
    private Role role;
    private Boolean signedIn;

    public User(Long id, String firstName, String lastName, String email, String password, Role role, Account account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.account = account;
        this.signedIn = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Boolean getSignedIn() {
        return signedIn;
    }

    public void setSignedIn(Boolean signedIn) {
        this.signedIn = signedIn;
    }

    @Override
    public String toString() {
        return String.format("%1$-5s",id) +
                String.format("%1$-10s",firstName)+
                String.format("%1$-10s",lastName) +
                String.format("%1$-15s",email) +
                String.format("%1$-10s",password) +
                String.format("%1$-10s",account.getAccountNumber())+
                String.format("%1$-15s", account.getBalance())+
                String.format("%1$-15s",role) +
                String.format("%1$-5s",signedIn);
    }
}
