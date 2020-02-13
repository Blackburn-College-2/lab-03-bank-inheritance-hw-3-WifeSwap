/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankInheritance;

import java.util.Calendar;

/**
 *
 * @author Gabl
 */
public class Transaction {
    
    private static Calendar time = Calendar.getInstance();
    private String timeString = time.getTime().toString();
    private Money oldBalance;
    private Money change;
    private Money newBalance;

    public Transaction(Money old, Money change) {
        oldBalance = new Money(old.getCurrency(), old.getAmount());
        this.change = new Money(change.getCurrency(), change.getAmount());
        this.newBalance = new Money(old.getCurrency(), old.getAmount() + change.getAmount());
    }
    public static void generateStatement(Transaction[] t){
        System.out.println("Old Balance\t  Change\t New Balance \tDate");
        for(int i = 0; i < t.length; i++){
            System.out.println(t[i].toString());
        }
    }
    @Override
    public String toString(){
        return (oldBalance.getCurrency().symbol + String.format("%.02f",Math.abs(oldBalance.getAmount()/10000.0)) +
                "\t\t" + change.getCurrency().symbol+ String.format("%.02f",(change.getAmount()/10000.0)) + "\t\t" + 
                newBalance.getCurrency().symbol+ String.format("%.02f",Math.abs(newBalance.getAmount()/10000.0)) + "\t"+
                timeString);
        
    }
}
