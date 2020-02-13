/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankInheritance;

import java.util.ArrayList;

/**
 *
 * @author jonathan.gabl
 */
public abstract class Account {

    Money balance;
    ArrayList<Money> history = new ArrayList();
    ArrayList<Transaction> transactions = new ArrayList();

    public Account(Money balance) {        
        history.add(balance);
        this.balance=new Money(balance.getCurrency(),balance.getAmount());
    }

    /**
     * withdraw an amount of money and add the transaction to the history
     * @param m money to withdraw
     */
    public void withdraw(Money m) {
        updateBalance();
        m.setAmount(-1*m.getAmount());        
        transactions.add(new Transaction(balance,m));
        history.add(m);
        updateBalance();
    }
/**
     * deposit an amount of money and add the transaction to the history
     * @param m money to withdraw
     */
    public void deposit(Money m) {
        updateBalance();
        history.add(m);
        transactions.add(new Transaction(balance,m));
        updateBalance();
    }
/**
 * calculates the balance based off all transactions and sets the balance equal to that
 */
    public void updateBalance() {
        balance.subtract(balance,balance);
        for(int i = 0; i < history.size(); i++){
        balance.add(balance,history.get(i));
        }
    }
    /**
     * updates the balance and returns the balance
     * @return balance 
     */
    public Money getBalance(){
        updateBalance();
        return balance;
    }
    /**
     * returns formatted string
     * @return 
     */
    @Override
    public String toString(){
        updateBalance();        
        return balance.toString();
    };
    /**
     * prints history of every transaction
     */
    public void printHistory(){
        for(int i=0; i< history.size(); i++){
            if(history.get(i).getAmount() < 0){
                System.out.println("Withdrew " + history.get(i));
            }else{
                System.out.println("Deposited "+ history.get(i));
            }
        }
    }
    public Transaction[] getTransaction(){
        Transaction[] transactionArray = new Transaction[transactions.size()];
        for(int i = 0; i < transactions.size(); i++){
            transactionArray[i] = transactions.get(i);
        }
        return transactionArray;
    }
}
