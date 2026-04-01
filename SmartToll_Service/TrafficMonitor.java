package SmartToll_Service;
public class TrafficMonitor{
    private int vehicleCount=0;
    public void vehiclePassed(){
        vehicleCount++;
    }
    public int getTrafficDensity(){
        return vehicleCount;
    }
}


