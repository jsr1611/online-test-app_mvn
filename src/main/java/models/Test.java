package models;

import java.util.List;

public class Test {
    private Long id;
    private List<Question> questions;
    private Integer totalPoints;
    private Integer userPoints;

    public Test(Long id, List<Question> questions, Integer totalPoints, Integer userPoints) {
        this.id = id;
        this.questions = questions;
        this.totalPoints = totalPoints;
        this.userPoints = userPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Integer getTotalPoints() {
        totalPoints = 0;
        for (Question question : questions) {
            totalPoints+= question.getScore();
        }
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Integer getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(Integer userPoints) {
        this.userPoints = userPoints;
    }

    @Override
    public String toString() {
        StringBuilder questionsStr = new StringBuilder();
        for (Question question : questions) {
            questionsStr.append("QUESTIONS\n").append(question).append("\n");
        }
        return String.format("%1$-5s", id) +
                String.format("%1$-20s", questions.size()) +
                String.format("%1$-15s",totalPoints) +
                String.format("%1$-15s",userPoints) + "\n" +
                questionsStr.toString();

    }
}
