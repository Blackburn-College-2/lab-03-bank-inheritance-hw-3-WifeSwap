/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankInheritance;

/**
 *
 * @author Gabl
 */
public class SavingsAccount extends Account{
    private double interestRate;
    public Money accruedBalance;
    public SavingsAccount(Money m, double d){
        super(m);
        interestRate = d;
        accruedBalance = new Money(balance.getCurrency(),0);
    }
    @Override    
    public void withdraw(Money m) {
        updateBalance();
        m.setAmount(-1*m.getAmount());
        transactions.add(new Transaction(balance,m));
        history.add(m);
        updateBalance();
        accrue();
    }
    public void accrue(){
        updateBalance();
        accruedBalance.setAmount(balance.getAmount());
        history.add(Money.multiply(accruedBalance, interestRate));
    }
    
}
