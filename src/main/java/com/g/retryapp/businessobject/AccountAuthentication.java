package com.g.retryapp.businessobject;

public class AccountAuthentication {
    private String accountNumber;
    private boolean isvalid;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isIsvalid() {
        return isvalid;
    }

    public void setIsvalid(boolean isvalid) {
        this.isvalid = isvalid;
    }

    @Override
    public String toString() {
        return "AccountAuthentication{" +
                "accountNumber='" + accountNumber + '\'' +
                ", isvalid=" + isvalid +
                '}';
    }
}
