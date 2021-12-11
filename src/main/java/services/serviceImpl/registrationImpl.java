package services.serviceImpl;

import enums.Currency;
import enums.Role;
import models.Account;
import models.User;
import realization.main;
import services.registration;

import java.util.InputMismatchException;
import java.util.Scanner;

public class registrationImpl implements registration {
    private Scanner scanner;

    @Override
    public User findByEmail(String email) {
        for (User user : main.users) {
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean signUp() {
        scanner = new Scanner(System.in);

        String firstName = "", lastName = "", email = "", password = "";
        try {
            System.out.print("Enter your full name: ");
            String name = scanner.nextLine();
            if (name.contains(" ")) {
                firstName = name.substring(0, name.indexOf(" "));
                name = name.substring(name.indexOf(" "));
                lastName = name.trim();
            }
            else {
                firstName = name;
                lastName = " ";
            }
            boolean userExists = true;
            while (userExists) {
                System.out.print("Enter your email address: ");
                email = scanner.next();
                userExists = findByEmail(email) != null;
                if(userExists){
                    System.out.println("This email has already been taken by some other user. Please use a different email address.");
                }
            }

            System.out.print("Enter your password: ");
            password = scanner.next();
            System.out.println("Choose who you are: ");
            System.out.println("1. " + Role.APPLICANT);
            System.out.println("2. " + Role.ADMIN);
            String userType = scanner.next();
            Role chosenRole;
            if(userType.equals("1")){
                chosenRole = Role.APPLICANT;
            }
            else {
                chosenRole = Role.ADMIN;
            }
            String accountNumberStr = "";
            Long accountNumber = null;
            while (accountNumber == null) {
                System.out.print("Enter account number you want in the platform (13 digits): ");
                try {
                    accountNumberStr = scanner.next();
                    try {
                        accountNumber = Long.parseLong(accountNumberStr);
                        if(accountNumberStr.length() != 13){
                            System.out.println("Please, enter 13 digits! No more, no less!");
                            accountNumber = null;
                            continue;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Please, enter only numbers!");
                        accountNumber = null;
                        continue;
                    }
                    User accountExists = findByAccountNumber(accountNumber);
                    if (accountExists != null) {
                        accountNumber = null;
                        System.out.println("An account with the given number already exists in the database.");
                        System.out.println("Please, use a different account number.");
                    }
                    else
                    {
                        break;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            Currency currency = paymentServiceImpl.getCurrencyTag();

            Integer accountPassword = null;
            while (accountPassword == null){
                System.out.print("Enter account password (4 digits): ");
                String accountPasswordStr = scanner.next();
                try {
                    accountPassword = Integer.valueOf(accountPasswordStr);
                    if(accountPasswordStr.length() != 4){
                        System.out.println("Please, enter only 4 digits! No more, no less!");
                        accountPassword = null;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Please, enter only numbers!");
                    accountPassword = null;
                }
            }
            Account account1 = new Account(
                    main.users.size()+1L,
                    accountNumber,
                    accountPassword,
                    0.0, currency,
                    true);
            User user = new User(
                    main.users.size()+1L,
                    firstName,
                    lastName,
                    email,
                    password,
                    chosenRole,
                    account1);
            main.users.add(user);
            System.out.println("===================================");
            System.out.println("User registration was successful!");
            System.out.println("===================================");
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private User findByAccountNumber(Long accountNumber) {
        for (User user : main.users) {
            if(user.getAccount().getAccountNumber().equals(accountNumber)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean signIn() {
        scanner = new Scanner(System.in);
        String email = "", password = "";
        int counter = 5;
        boolean loginSuccess = false;
        while (loginSuccess == false && --counter > 0) {
            System.out.println("Enter 0 to previous menu: ");
            try {
                System.out.print("Enter your email address: ");
                email = scanner.next();
                if(email.equals("0"))
                {
                    return false;
                }

                System.out.print("Enter your password: ");
                password = scanner.next();
                if(password.equals("0"))
                {
                    return false;
                }

                User user = findByEmailAndPassword(email, password);
                if (user != null) {
                    System.out.println("Welcome, " + user.getFirstName() + "!");
                    main.currentUser = user;
                    loginSuccess = true;
                    return true;
                } else {
                    if (findByEmail(email) == null) {
                        System.out.println("User with the given email was not found in the database.");
                    } else {
                        System.out.println("Please, check your password, and try again!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(counter == 0){
            System.out.println("You have used 5 consecutive attempts to sign-in without success. Please, check your registration credentials and come back again!");
        }
        return false;


    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        for (User user : main.users) {
            if(user.getEmail().equals(email)){
                if(user.getPassword().equals(password)){
                    return user;
                }
            }
        }
        return null;
    }
}
