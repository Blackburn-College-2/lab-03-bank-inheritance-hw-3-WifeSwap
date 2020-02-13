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
public class Loan extends Account{
    private double interestRate;
    public Money LoanBalance;
    public Loan(Money m, double d){
        super(m);
        interestRate = d;
        LoanBalance = new Money(balance.getCurrency(),0);
    }
    public Money getLoan(){
        return LoanBalance;
    }
    
    @Override    
    public void withdraw(Money m) {
        m.setAmount(-1*m.getAmount());
        history.add(m);
        accrue();
    }
    @Override    
    public void deposit(Money m) {
        m.setAmount(m.getAmount());
        history.add(m);
    }    
    public void accrue(){
        updateBalance();
        System.out.println(balance);
       LoanBalance.setAmount(balance.getAmount());
       history.add(Money.multiply(LoanBalance, interestRate));
    }    
    public void printHistory(){
        for(int i=0; i< history.size(); i++){
            if(history.get(i).getAmount() < 0){
                System.out.println("Withdrew " + history.get(i));
            }else{
                System.out.println("Deposited "+ history.get(i));
            }
        }
    }
}
