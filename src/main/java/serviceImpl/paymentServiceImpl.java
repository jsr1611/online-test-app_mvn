package serviceImpl;

import enums.Currency;
import enums.PaymentType;
import models.*;
import realization.main;
import services.paymentService;

import java.time.LocalDate;
import java.util.*;

public class paymentServiceImpl implements paymentService {
    private static Scanner scanner;
    @Override
    public PaymentType addPaymentMethod() {
        PaymentType paymentType = null;
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("\nAdd Payment Method Menu");
            paymentType = null;
            int choice = -1;
            Double initialBalance = 0.0;
            try {
                System.out.print("\nChoose payment type: ");
                System.out.println("1. PayMe");
                System.out.println("2. CLICK");
                System.out.println("3. Cash");
                System.out.println("0. Cancel\n");
                System.out.print("Payment method: ");
                choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        paymentType = PaymentType.PayMe;
                        break;
                    case 2:
                        paymentType = PaymentType.CLICK;
                        break;
                    case 3:
                        paymentType = PaymentType.CASH;
                        break;
                }

                main.currentUser.getPaymentMethod().addMethod(paymentType);

            }catch (Exception e){
                e.printStackTrace();
            }

            if(paymentType != null){
                main.currentUser.getPaymentMethod().addMethod(paymentType);
                break;
            }
            else {
                System.out.println("Error in user input for payment method creation.");
            }

        }
        return paymentType;
    }

    @Override
    public boolean editPaymentMethod(PaymentType method) {
        scanner = new Scanner(System.in);
        System.out.println("\nEdit Payment Method Menu");
        PaymentType type = null, userSelectedMethod = null;
//
//        Set<Map.Entry<PaymentType, Boolean>> entries = main.adminPaymentMethod.getMethods().entrySet();
//        for (main.adminPaymentMethod.getMethods().entrySet()) {
//            if(entries.getKey().equals(main.currentUser)){
//                for (Map.Entry<PaymentType, Boolean> userPayMethod : payMethod.getValue().getMethods().entrySet()) {
//                    if(userPayMethod.getKey().equals(method)){
//                        Boolean isActive = userPayMethod.getValue();
//                        System.out.println(userPayMethod.getKey() + " is " + (isActive ? "activated" : "deactivated") +".");
//                        System.out.println("Do you want to " + (isActive ? "deactivate" : "activate" + " it?"));
//                        String userResponse = "";
//                        if(userPayMethod.getValue()){
//                            System.out.print("You are about to deactivate this payment method. Enter 'y' to finish the process: ");
//                            userResponse = scanner.next();
//                            if(userResponse.equals("y")){
//                                payMethod.getValue().deactivate(method);
//                                System.out.println("Payment method " + method + " was successfully deactivated.");
//                                return true;
//                            }
//                        }
//                        else {
//                            System.out.print("You are about to activate this payment method. Enter 'y' to finish the process: ");
//                            userResponse = scanner.next();
//                            if(userResponse.equals("y")){
//                                payMethod.getValue().activateMethod(method);
//                                System.out.println("Payment method " + method + " was successfully activated.");
//                                return true;
//                            }
//                        }
//                    }
//                }
//            }
//        }
        System.out.println("There was no change in payment method: " + method);
        return false;
    }

    @Override
    public boolean deletePaymentMethod(PaymentType method) {
        for (Map.Entry<PaymentType, Boolean> methods : main.currentUser.getPaymentMethod().getMethods().entrySet()) {
            if(methods.getKey().equals(method)){
                return main.currentUser.getPaymentMethod().deactivate(method);
            }
        }
        return false;
    }

    @Override
    public boolean refillBalance(Long id, Double amount, User user) {
        double balance = 0;
        LocalDate date = LocalDate.now();

        for (User user1 : main.users) {
            if(user1.equals(user)){
                balance = user1.getAccount().refill(amount);
                System.out.println("Current balance: " + balance);
                FillBalanceHistory history = new FillBalanceHistory(main.balanceHistories.size()+1L,
                        date, amount, balance, null, main.currentUser);
                main.balanceHistories.add(history);
                return true;
            }
        }
        return false;
    }


    @Override
    public void printAllMethods() {
        Boolean isActive = null;
        int counter = 0;
        for (Map.Entry<PaymentType, Boolean> method : main.adminPaymentMethod.getMethods().entrySet()) {
            isActive = method.getValue();
            if(isActive){
                System.out.println(counter++ +" " + method.getKey() + "("+ (isActive ? " activated" : "deactivated" +")"));
            }
        }
    }



    public List<PaymentType> getAllActiveMethods() {
        Boolean isActive;
        List<PaymentType> activeMethods = new ArrayList<>();
        int counter = 1;
        for (Map.Entry<PaymentType, Boolean> method : main.adminPaymentMethod.getMethods().entrySet()) {
            isActive = method.getValue();
            if(isActive){
                activeMethods.add(method.getKey());
            }
        }
        return activeMethods;
    }


    public static Currency getCurrencyTag() {
        int counterWhileLoop = 3;
        while (counterWhileLoop-- > 0) {
            scanner = new Scanner(System.in);
            Currency currency = null;
            int counter = 1;
            for (Currency currencyVal : Currency.values()) {
                System.out.println(counter++ + ". " + currencyVal);
            }
            System.out.print("Choose currency: ");
            int currencyChosen = -1;
            currencyChosen = scanner.nextInt();
            switch (currencyChosen) {
                case 1:
                    currency = Currency.UZS;
                    break;
                case 2:
                    currency = Currency.USD;
                    break;
                case 3:
                    currency = Currency.RUB;
                    break;
                default:
                    System.out.println("Wrong input! Please, try again.");
                    break;
            }
            if(currency != null){
                return currency;
            }
        }
        return null;
    }

    @Override
    public Boolean acceptPayment(PaymentType paymentType, Double amount) {
        scanner = new Scanner(System.in);
        String userResponse = "";
        if(paymentType.equals(PaymentType.CLICK) || paymentType.equals(PaymentType.PayMe)){
            if(main.currentUser.getAccount().getBalance() > amount){
                main.adminPaymentMethod.getAccount().addBalance(amount);
                main.currentUser.getAccount().addBalance(-1 * amount);
                return true;
            }else {
                System.out.println("Not enough money in the account balance. Want to recharge your balance? Enter 'y' to continue.");
            }
        }else
        {
            boolean paymentSuccess = false;
            int counter = 5;
            while (!paymentSuccess && --counter > 0){
                System.out.println("Enter the test price amount by hand: " + amount);
                userResponse = scanner.next();
                try {
                    if(userResponse.equals(amount.toString())){
                        System.out.println("Payment successful!");
                        return true;
                    }
                    else {
                        System.out.println("Payment amount didn't match. Please, try again!");
                    }

                }catch (InputMismatchException e){
                    System.out.println("Wrong input. Please, try again!");
                }
            }
        }
        return false;
    }
}
