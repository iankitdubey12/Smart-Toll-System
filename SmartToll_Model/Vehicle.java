package SmartToll_Model;
public class Vehicle{
    private String licensePlate;
    private String vehicleType;
    private boolean isStolen;
    public Vehicle(String l,String v){
      this.licensePlate=l;
      this.vehicleType=v;
    }
    public String getLicensePlate(){
        return licensePlate;
    }
    public String getVehicleType(){
        return vehicleType;
    }
    public boolean isStolen(){
        return isStolen;
    }
    public void setStolen(boolean stolen){
        isStolen=stolen;
    }
}