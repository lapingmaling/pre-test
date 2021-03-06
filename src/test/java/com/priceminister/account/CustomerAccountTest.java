package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;
import org.junit.rules.ExpectedException;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertEquals(customerAccount.getBalance(),new Double(0.0D));
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        customerAccount.add(1.0);
        assertTrue(customerAccount.getBalance()>0);
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
        exception.expect(IllegalBalanceException.class);
        customerAccount.withdrawAndReportBalance(2.0,rule);
    }

    @Test
    public void testWithdrawAndReportBalanceIllegalBalanceWithNegativeWithdraw() throws IllegalBalanceException {
        exception.expect(IllegalBalanceException.class);
        customerAccount.withdrawAndReportBalance(-2.0,rule);
    }
    
    // Also implement missing unit tests for the above functionalities.

}
