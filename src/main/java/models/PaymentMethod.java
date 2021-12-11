package models;

import enums.PaymentType;

import java.time.LocalDate;
import java.util.Map;

public class PaymentMethod {
    private Long id;
    private Map<PaymentType, Boolean> methods;
    private models.Account account;
    private LocalDate dateAdded;

    public PaymentMethod(Long id, Map<PaymentType, Boolean> methods, models.Account account, LocalDate dateAdded) {
        this.id = id;
        this.methods = methods;
        this.account = account;
        this.dateAdded = dateAdded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<PaymentType, Boolean> getMethods() {
        return methods;
    }

    public void setMethods(Map<PaymentType, Boolean> methods) {
        this.methods = methods;
    }
    public void addMethod(PaymentType method){
        boolean methodExists = false;
        for (Map.Entry<PaymentType, Boolean> methodsMap : methods.entrySet()) {
            if(methodsMap.getKey().equals(method)){
                methodsMap.setValue(true);
                methodExists = true;
            }
        }
        if(!methodExists){
            methods.put(method, true);
        }
    }


    /**
     * Check if certain payment method is activated or deactivated. if it is unavailable return null.
     * @param type payment method
     * @return return boolean or null if not exists
     */
    public Boolean isActive(PaymentType type){
        for(Map.Entry<PaymentType, Boolean> method : methods.entrySet()){
            if(method.getKey().equals(type)){
                return method.getValue();
            }
        }
        return null;
    }

    public Boolean activateMethod(PaymentType type){
        for (Map.Entry<PaymentType, Boolean> method : methods.entrySet()) {
            if(method.getKey().equals(type)){
                method.setValue(true);
                return true;
            }

        }
        return false;
    }
    public Boolean deactivate(PaymentType type){
        for (Map.Entry<PaymentType, Boolean> method : methods.entrySet()) {
            if(method.getKey().equals(type)){
                method.setValue(false);
                return true;
            }

        }
        return false;
    }

    public models.Account getAccount() {
        return account;
    }

    public void setAccount(models.Account account) {
        this.account = account;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        StringBuilder methodsStr = new StringBuilder();
        for (Map.Entry<PaymentType, Boolean> method : methods.entrySet()) {
            String active = method.getValue() ? "OK" : "X";
            methodsStr.append(method.getKey())
                    .append("(")
                    .append(active)
                    .append("), ");
        }
        return String.format("%1$-5s", id) +
                String.format("%1$-15s", methodsStr) +
                String.format("%1$-15s", account.getAccountNumber()) +
                String.format("%1$-15s", dateAdded);
    }
}
