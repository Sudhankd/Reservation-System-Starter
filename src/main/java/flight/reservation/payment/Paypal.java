package flight.reservation.payment;

public class PaypalPayment implements PaymentStrategy {
    private String username;
    private String email;

    public PaypalPayment(String username, String email) {
        // Verify credentials using the dummy database from the Paypal class
        if (Paypal.DATA_BASE.containsKey(username) && Paypal.DATA_BASE.get(username).equals(email)) {
            this.username = username;
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid PayPal credentials");
        }
    }

    @Override
    public void pay(double amount) {
        // Dummy payment processing via PayPal
        System.out.println("Payment of $" + amount + " made using PayPal account: " + email);
    }
}
