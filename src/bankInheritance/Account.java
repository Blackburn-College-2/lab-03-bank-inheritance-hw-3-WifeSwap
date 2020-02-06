/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankInheritance;

/**
 *
 * @author jonathan.gabl
 */
public class Account {

    Money balance;

    public Account(Money balance) {
        this.balance = balance;
    }

    public void withdraw(Money m) {
        balance.subtract(m);
    }

    public void deposit(Money m) {
        balance.add(m);
    }

    public Money getBalance() {
        return balance;
    }
    public String printBalance(){
        return balance.toString();
    };
}
