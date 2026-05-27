package SmartToll_Service;
public class Payment {
    public void process(String plate, double amount) {
        System.out.println("Payment processed for: " + plate);
        System.out.println("Amount: " + amount);
    }
}