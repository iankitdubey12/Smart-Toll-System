package Main;
import java.util.Scanner;
import SmartToll_Model.Vehicle;
import SmartToll_Service.*;
import Transaction.*;
public class SmartTollSystem{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        TrafficMonitor tm=new TrafficMonitor();
        TollCalculator tc=new TollCalculator();
        Payment p=new Payment();
        TransactionLog t=new TransactionLog();
        while(true){
        System.out.println("Enter Vehicle Number or Exit:");
        String num=sc.nextLine();
        if(num.equalsIgnoreCase("Exit")){
           System.out.println("Stopped");
           break;
        }
        System.out.println("Enter Vehicle Type(Car/Truck?Bus)");
        String type=sc.nextLine();
        Vehicle v=new Vehicle(num,type);
        tm.vehiclePassed();
        int traffic = tm.getTrafficDensity();
        double toll=tc.calculateToll(v,traffic);
        p.process(v.getLicensePlate(),toll);
        t.log(v,toll);
        System.out.println("Current Traffic Density:"+traffic);
    }
    sc.close();
        }
    }
