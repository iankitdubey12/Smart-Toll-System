// javac -cp ".;lib/mysql-connector-j-9.7.0.jar" Main/*.java SmartToll_Model/*.java SmartToll_Service/*.java SmartToll_DB/*.java SmartToll_Police/*.java Transaction/*.java
//java -cp ".;lib/mysql-connector-j-9.7.0.jar" Main.SmartTollGUI
package Main;
import javax.swing.*;

import SmartToll_Model.Vehicle;
import SmartToll_Service.*;
import Transaction.TransactionLog;
import SmartToll_Police.PoliceDatabase;

import java.awt.*;

public class SmartTollGUI extends JFrame {

    JTextField vehicleField;
    JComboBox<String> typeBox;
    JTextArea output;

    TrafficMonitor tm = new TrafficMonitor();
    TollCalculator tc = new TollCalculator();
    Payment p = new Payment();
    TransactionLog t = new TransactionLog();

    public SmartTollGUI() {

        setTitle("Smart Toll System");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Vehicle No:"));
        vehicleField = new JTextField(20);
        add(vehicleField);

        add(new JLabel("Type:"));
        typeBox = new JComboBox<>(new String[]{"Car", "Truck", "Bus"});
        add(typeBox);

        JButton btn = new JButton("Process");
        add(btn);

        output = new JTextArea(10, 40);
        add(new JScrollPane(output));

        btn.addActionListener(e -> process());
    }

    public void process() {

        String num = vehicleField.getText();
        String type = (String) typeBox.getSelectedItem();

        Vehicle v = new Vehicle(num, type);

        if (PoliceDatabase.isStolen(num)) {
            output.setText("🚨 Stolen Vehicle Detected!");
            return;
        }

        tm.vehiclePassed();
        int traffic = tm.getTrafficDensity();

        double toll = tc.calculateToll(v, traffic);

        p.process(num, toll);
        t.log(v, toll);

        output.setText(
            "Vehicle: " + num +
            "\nType: " + type +
            "\nTraffic: " + traffic +
            "\nToll: " + toll
        );
    }

    public static void main(String[] args) {
        new SmartTollGUI().setVisible(true);
    }
}
