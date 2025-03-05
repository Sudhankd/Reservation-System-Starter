package flight.reservation.payment;

import java.util.Date;

public class CreditCardPayment implements PaymentStrategy {
    private CreditCard creditCard;

    public CreditCardPayment(String number, Date expiryDate, String cvv) {
        // Instantiate a CreditCard using the existing class
        this.creditCard = new CreditCard(number, expiryDate, cvv);
    }

    @Override
    public void pay(double amount) {
        // Check if the card is valid and has enough funds (dummy logic here)
        if (creditCard.isValid() && creditCard.getAmount() >= amount) {
            creditCard.setAmount(creditCard.getAmount() - amount);
            System.out.println("Payment of $" + amount + " made using Credit Card. Remaining balance: $" + creditCard.getAmount());
        } else {
            System.out.println("Credit Card payment failed: Invalid card or insufficient funds.");
        }
    }
}
