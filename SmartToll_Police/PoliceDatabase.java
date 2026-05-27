package SmartToll_Police;
import SmartToll_DB.DBConnection;
import java.sql.*;
public class PoliceDatabase {
    public static boolean isStolen(String plate) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT status FROM police_records WHERE license_plate=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, plate);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("status").equalsIgnoreCase("STOLEN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
