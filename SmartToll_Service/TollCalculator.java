package SmartToll_Service;
import SmartToll_Model.Vehicle;
public class TollCalculator{
    public double calculateToll(Vehicle v,int traffic){
        double baseRate;
        switch(v.getVehicleType()){
            case "Car": baseRate=30;
                        break;
            case "Truck": baseRate=100;
                        break;
            case "Bus": baseRate=50;
                        break;
            default: baseRate=50;
        }
        if(traffic>5){
            baseRate*=1.2;
        }
    return baseRate;
    }
}
