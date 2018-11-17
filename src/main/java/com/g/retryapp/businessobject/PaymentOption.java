package com.g.retryapp.businessobject;

public class PaymentOption {
    private String accountNumber;
    private String type;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PaymentOption{" +
                "accountNumber='" + accountNumber + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
