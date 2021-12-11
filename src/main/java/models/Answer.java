package models;

public class Answer {
    private Long id;
    private String answerStr;
    private Boolean isCorrect;

    public Answer(Long id, String answer, Boolean correct) {
        this.id = id;
        this.answerStr = answer;
        this.isCorrect = correct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerStr() {
        return answerStr;
    }

    public void setAnswerStr(String answer) {
        this.answerStr = answer;
    }

    public Boolean isCorrect() {
        return isCorrect;
    }

    public void setAsCorrect(Boolean correct) {
        this.isCorrect = correct;
    }

    @Override
    public String toString() {
        return String.format("%1$-5s", id) +
                String.format("%1$-20s", answerStr) +
                String.format("%1$-5s", isCorrect());
    }
}
