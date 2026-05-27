package SmartToll_DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDb {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/smart_toll",
                "root",
                "Ankit@2005"
            );

            System.out.println("✅ Database Connected Successfully!");

            con.close();

        } catch (Exception e) {
            System.out.println("❌ Connection Failed");
            e.printStackTrace();
        }
    }
}