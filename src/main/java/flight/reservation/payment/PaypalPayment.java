package flight.reservation.payment;

public class PaypalPayment implements PaymentStrategy {

    private final String username;
    private final String email;


    public PaypalPayment(String username, String email) {
        // Validate credentials using the dummy Paypal.DATA_BASE
        if (Paypal.DATA_BASE.containsKey(username) && Paypal.DATA_BASE.get(username).equals(email)) {
            this.username = username;
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid PayPal credentials.");
        }
    }

    @Override
    public void pay(double amount) {
        // Dummy payment processing
        System.out.println("Paid $" + amount + " using PayPal account: " + email);
    }
}
