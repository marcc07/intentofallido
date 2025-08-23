package Clinic.Clinic.domain.model.ValOb;

import java.util.Currency;

public class Money {
    private final long amount;
    private final Currency currency;
    
    private Money(long amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    public static Money of(long amount, String currencyCode) {
        if (amount < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        Currency currency = Currency.getInstance(currencyCode);
        return new Money(amount, currency);
    }
    
    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("No se pueden sumar diferentes monedas");
        }
        return new Money(this.amount + other.amount, this.currency);
    }
    
    public Money multiply(int quantity) {
        return new Money(this.amount * quantity, this.currency);
    }
    
    public boolean isNonNegative() {
        return amount >= 0;
    }
    
    public long getAmount() { return amount; }
    public Currency getCurrency() { return currency; }
}