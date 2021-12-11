package models;

import java.time.LocalDate;

public class UserTestHistory {
    private Long id;
    private Long userId;
    private String subject;
    private models.Test test;
    private Integer score;
    private LocalDate date;


    public UserTestHistory(Long id, Long userId, String subject, models.Test test, Integer score, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.subject = subject;
        this.test = test;
        this.score = score;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public models.Test getTest() {
        return test;
    }

    public void setTest(models.Test test) {
        this.test = test;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%1$-5s", id) +
                String.format("%1$-20s", subject)+
                String.format("%1$-20s", score + " ("+getPercentage(score, test.getTotalPoints())+")") +
                String.format("%1$-20s",test.getTotalPoints()) +
                String.format("%1$-15s", date);
    }

    private Double getPercentage(Integer score, Integer totalPoints) {
        Double percentage = 0.0;
        percentage = (score * 100.0) / totalPoints;
        return percentage;
    }
}
