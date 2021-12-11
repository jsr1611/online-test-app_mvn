package models;

import enums.Currency;

import java.util.List;

public class Subject {
    private Long id;
    private String name;
    private List<models.Test> testList;
    private Integer totalPoints; // scores
    private Double price;
    private Currency currency;

    public Subject(Long id, String name, List<models.Test> testList, Integer totalPoints, Double price, Currency currency) {
        this.id = id;
        this.name = name;
        this.testList = testList;
        this.totalPoints = totalPoints;
        this.price = price;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<models.Test> getTestList() {
        return testList;
    }

    public void setTestList(List<models.Test> testList) {
        this.testList = testList;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return String.format("%1$-5s", id) +
                String.format("%1$-15s", name) +
                String.format("%1$-15s", testList.size()) +
                String.format("%1$-15s", totalPoints) +
                String.format("%1$-15s", price+" "+currency);

    }
}
