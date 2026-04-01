package SmartToll_Service;
public class Payment{
    public void process(String VehicleNo,double amount){
        System.out.println("Payment Successful for "+VehicleNo+" Amount: "+amount);
    }
}