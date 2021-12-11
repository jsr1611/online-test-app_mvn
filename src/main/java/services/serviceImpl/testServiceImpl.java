package services.serviceImpl;

import models.Answer;
import models.Question;
import models.Subject;
import models.Test;
import realization.main;
import services.testService;

import java.util.*;

public class testServiceImpl implements testService {
    private Long testID = 1L;
    private Scanner scanner;

    @Override
    public Test createTest() {

        boolean continueTestCreation = true;
        List<Question> questionList = new ArrayList<>();
        Answer answer1 = null;
        Answer answer2 = null;
        Answer answer3 = null;
        int qCounter = 1;
        int aCounter = 1;
        while (continueTestCreation) {
            scanner = new Scanner(System.in);
            System.out.println("Question " + qCounter++);
            try {
                answer1 = new Answer(1L, "", false);
                answer2 = new Answer(2L, "", false);
                answer3 = new Answer(3L, "", true);
                String questionText = "";
                System.out.println("Question text: ");
                questionText = scanner.nextLine();
                boolean questionComplete = false;
                while (!questionComplete){
                    int counter = 0;
                    System.out.println(questionText);
                    answer1 = addAnswer(answer1.getId());
                    answer2 = addAnswer(answer2.getId());
                    answer3 = addAnswer(answer3.getId());
                    Answer[] answers = {answer1, answer2, answer3};
                    for (Answer answer : answers) {
                        if(answer.isCorrect()){
                            counter++;
                        }
                    }
                    if(counter == 1){
                        questionComplete = true;
                    }
                    else {
                        if(counter > 1){
                            System.out.println("There shouldn't be more than one correct answer. Please enter answers from the beginning!");
                        }
                        else {
                            System.out.println("Something went wrong! Check answers below: ");
                            System.out.println(answer1);
                            System.out.println(answer2);
                            System.out.println(answer3);
                        }
                    }
                }

                Set<Answer> answers = new HashSet<>();
                answers.add(answer1);
                answers.add(answer2);
                answers.add(answer3);

                Question question = new Question(1L, questionText, answers,5);
                questionList.add(question);

            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.print("Add more question? 'y' to continue: ");
            String stopHere = scanner.next();
            if(!stopHere.equals("y")){
                continueTestCreation = false;
            }
        }
        Test test = new Test(testID,
                questionList,
                100 * questionList.size(), 0);

        return test;
    }

    private Answer addAnswer(Long id) {
        scanner = new Scanner(System.in);
        System.out.print("Answer " + id + ": ");
        String answer = scanner.nextLine();
        System.out.println("Is it correct answer? 'y' for yes, 'n' for no.");
        String isTrue = scanner.next();
        boolean isCorrect = isTrue.equals("y");
        return new Answer(id, answer, isCorrect);
    }

    @Override
    public boolean updateTest(Long id, Long subjectId) {
        for (Subject subject : main.subjects) {
            if(subject.getId().equals(subjectId)){
                for (Test test : subject.getTestList()) {
                    if(test.getId().equals(id)){
                        System.out.println(test);
                        // TODO: 12/5/21 edit what? logic insertion is required
                        System.out.println("The test above was successfully updated!");
                        return true;
                    }
                }

            }
        }
    return false;
    }

    @Override
    public boolean deleteTest(Long id, Long subjectId) {
        for (Subject subject : main.subjects) {
            if(subject.getId().equals(subjectId)){
                for (Test test : subject.getTestList()) {
                    if(test.getId().equals(id)){
                        subject.getTestList().remove(test);
                        System.out.println(test);
                        System.out.println("The test above was successfully deleted!");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
