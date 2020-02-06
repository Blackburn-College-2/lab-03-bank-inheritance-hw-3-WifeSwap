/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankInheritance;

/**
 *
 * @author paul.kline
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Currency currency = new Currency("Dollars","$");
        Money money = new Money(currency,12.4);
        Money money3 = new Money(currency, 12.4);
        Money money2 = new Money(currency,5);
        Account account = new Account(money);
        System.out.println(account.printBalance());
        account.deposit(money2);
        System.out.println(account.printBalance());
        account.withdraw(money3);
        System.out.println(account.printBalance());
    }
    
}
