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
        Double resultingAccountingBalance = null;
        if (withdrawnAmount != null && rule != null ){
            resultingAccountingBalance = balance - withdrawnAmount;
            if (withdrawnAmount <= 0 || !rule.withdrawPermitted(resultingAccountingBalance)) {
                throw new IllegalBalanceException(withdrawnAmount);
            }
        }
        return resultingAccountingBalance;
    }
}
