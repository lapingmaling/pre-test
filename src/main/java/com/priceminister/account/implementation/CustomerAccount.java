package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private Double balance = 0.0D;

    public void add(Double addedAmount) {
        this.balance += addedAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) 
    		throws IllegalBalanceException {
        Double resultingAccountingBalance = new Double(balance - withdrawnAmount);
        if (!rule.withdrawPermitted(resultingAccountingBalance)) {
            throw new IllegalBalanceException(withdrawnAmount);
        }
        return resultingAccountingBalance;
    }

}
