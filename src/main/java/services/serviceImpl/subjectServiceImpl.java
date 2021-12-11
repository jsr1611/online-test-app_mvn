package services.serviceImpl;

import enums.Currency;
import models.Subject;
import models.Test;
import realization.main;
import services.subjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class subjectServiceImpl implements subjectService {
    private Scanner scanner;
    @Override
    public Subject addSubject() {
        scanner = new Scanner(System.in);
        System.out.println("ADD NEW SUBJECT");
        System.out.print("Subject: ");
        String subject = "";
        double price = -1;
        price = scanner.nextDouble();
        Currency currency = paymentServiceImpl.getCurrencyTag();
        List<Test> testList = new ArrayList<>();
        try {
            subject = scanner.nextLine();
            testList = AddTestLoop();
            Subject subjectAdded = new Subject(main.subjects.size() + 1L,
                    subject,
                    testList,
                    testList.size() * 100,
                    price,
                    currency);
            main.subjects.add(subjectAdded);
            return subjectAdded;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public boolean updateSubject(Long id) {
        scanner = new Scanner(System.in);
        String newName = "";
        for (Subject subject : main.subjects) {
            if(subject.getId().equals(id)){
                System.out.print("Enter new name: ");
                newName = scanner.nextLine();
                subject.setName(newName);
                List<Test> testList = AddTestLoop();
                subject.setTestList(testList);
                System.out.println("Subject was successfully updated!");
                return true;
            }
        }
        return false;
    }

    public List<Test> AddTestLoop(){
        List<Test> testList = new ArrayList<>();
        while (true) {
            Test newTest = main.testService.createTest();
            if(newTest != null){
                testList.add(newTest);
                System.out.println("Continue to add more tests? 'y' to continue.");
                String choice = scanner.next();
                if(!choice.equals("y")){
                    break;
                }
            }
            else {
                System.out.println("Error in creating a test!");
            }

        }
        return testList;
    }

    @Override
    public boolean deleteSubject(Long id) {
        for (Subject subject : main.subjects) {
            if(subject.getId().equals(id)){
                main.subjects.remove(subject);
                return true;
            }
        }
        return false;
    }

    @Override
    public void updatePrice(Long subjectId) {
        scanner = new Scanner(System.in);
        Subject subject = findById(subjectId);
        System.out.println("Test price for " + subject.getName() + ": "+ subject.getPrice());
        System.out.print("Enter the new price: ");
        double newPrice = -1;
        newPrice = scanner.nextDouble();
        subject.setPrice(newPrice);
        System.out.println("Updated test price: " + subject.getPrice());
        System.out.println("Subject test price has been successfully updated.");
    }

    public Subject findById(Long subjectId) {
        Subject subjectSelected = null;
        for (Subject subject : main.subjects) {
            if(subject.getId().equals(subjectId)){
                subjectSelected = subject;
            }
        }
        return subjectSelected;
    }
}
