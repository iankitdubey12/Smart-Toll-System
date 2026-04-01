package Transaction;
import SmartToll_Model.Vehicle;
public class TransactionLog{
    public void log(Vehicle v,double amount){
        System.out.println("Vehicle: "+v.getLicensePlate());
        System.out.println("Type of Vehicle: "+v.getVehicleType());
        System.out.println("Amount: "+amount);
    }
}