package flight.reservation.payment;

import java.util.Date;

public class CreditCardPayment implements PaymentStrategy {

    private final CreditCard creditCard;

    public CreditCardPayment(String number, Date expiryDate, String cvv) {
        // Use the existing CreditCard class
        this.creditCard = new CreditCard(number, expiryDate, cvv);
    }

    @Override
    public void pay(double amount) {
        // Check if the card is valid and has enough funds
        if (creditCard.isValid() && creditCard.getAmount() >= amount) {
            creditCard.setAmount(creditCard.getAmount() - amount);
            System.out.println("Paid $" + amount + " using Credit Card.");
            System.out.println("Remaining card balance: $" + creditCard.getAmount());
        } else {
            System.out.println("Credit Card payment failed: Invalid card or insufficient funds.");
        }
    }
}
