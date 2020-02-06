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
public class Money {

    Currency currency;
    long amount;

    public Money(Currency currency, double amount) {
        this.currency = currency;
        this.amount = (long) (amount * 100.0);
    }

    public Money add(Money input) {
        if (input.currency.name.equals(this.currency.name)) {
            this.amount = input.amount + this.amount;
        }
        return this;
    }
    public Money subtract(Money input) {
        if (input.currency.name.equals(this.currency.name)) {
            this.amount = this.amount - input.amount;
        }
        return this;
    }
    public String getAmountString(){
        return String.format("%.02f",(this.amount/100.0));
    }
    @Override
    public String toString(){
        return currency.symbol+getAmountString();
    }
}
