//for database connectivity
// javac -cp ".;lib/mysql-connector-j-9.7.0.jar" SmartToll_DB/TestDb.java
//java -cp ".;lib/mysql-connector-j-9.7.0.jar" SmartToll_DB.TestDb
package Transaction;

import SmartToll_Model.Vehicle;
import SmartToll_DB.DBConnection;
import java.sql.*;

public class TransactionLog {

    public void log(Vehicle v, double amount) {

        System.out.println("Vehicle: " + v.getLicensePlate());
        System.out.println("Amount: " + amount);

        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO transactions (license_plate, vehicle_type, amount) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, v.getLicensePlate());
            ps.setString(2, v.getVehicleType());
            ps.setDouble(3, amount);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}