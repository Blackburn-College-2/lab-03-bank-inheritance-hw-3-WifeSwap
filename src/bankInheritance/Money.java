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

    private Currency currency;
    private long amount;

    public Money(Currency currency, double amount) {
        this.currency = currency;
        this.amount = (long) (amount * 100.0);
    }
/**
 * adds the input to the current amount stored in the money
 * @param input money to add to the current money
 * @return updated money
 */
    public Money add(Money input) {
        if (input.currency.name.equals(this.currency.name)) {
            this.amount = input.amount + this.amount;
        }
        return this;
    }
/**
 * subtracts the input from the current amount stored in the money
 * @param input money to subtract from the current money
 * @return updated money
 */
    public Money subtract(Money input) {
        if (input.currency.name.equals(this.currency.name)) {
            this.amount = this.amount - input.amount;
        }
        return this;
    }
    /**
     * formats the amount to have 2 decimal places
     * @return formatted string of money without a currency symbol
     */
    private String getAmountString(){
        return String.format("%.02f",Math.abs(this.amount/100.0));
    }
    public Currency getCurrency(){
        return currency;
    }
    public long getAmount(){
        return amount;
    }
    public void setAmount(long amount){
        this.amount = amount;
    }
    /**
     * formats the currency symbol and the amount 
     * @return concatenated string of symbol and formatted amount 
     */
    @Override
    public String toString(){
        return currency.symbol+getAmountString();
    }
}
