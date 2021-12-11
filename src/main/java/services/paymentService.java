package services;

import enums.PaymentType;
import models.User;

import java.util.List;

public interface paymentService {
    PaymentType addPaymentMethod();

    boolean editPaymentMethod(PaymentType method);

    boolean deletePaymentMethod(PaymentType method);

    boolean refillBalance(Long id, Double amount, User user);

    void printAllMethods();

    List<PaymentType> getAllActiveMethods();

    Boolean acceptPayment(PaymentType paymentType, Double amount);
}
