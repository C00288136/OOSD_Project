import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class MyGUI extends JFrame implements ActionListener {

    // Constructor for GUI
    public MyGUI() {

        // Set up the frame
        setTitle("GUI with Buttons");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout with center alignment

        // Create buttons
        JButton connectButton = new JButton("Connect");
        JButton disconnectButton = new JButton("Disconnect");
        JButton connectionStatusButton = new JButton("Show Connection Status");
        JButton showTableButton = new JButton("Show Table");

        // Add action listeners to buttons
        connectButton.addActionListener(this);
        disconnectButton.addActionListener(this);
        connectionStatusButton.addActionListener(this);
        showTableButton.addActionListener(this);

        // Add buttons to the frame
        add(connectButton);
        add(disconnectButton);
        add(connectionStatusButton);
        add(showTableButton);

        // Make the frame visible
        setVisible(true);
    }

    // ActionListener implementation for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        // Perform different actions based on the button clicked
        switch (actionCommand) {
            case "Connect":
                JOptionPane.showMessageDialog(this, "Connecting...");
                // Add your connect logic here
                DatabaseConnector dataConnect = new DatabaseConnector();
                Connection connection = dataConnect.connect();
                
                if (connection != null) {
                    JOptionPane.showMessageDialog(this, "Connected to the database!");
                } else {
                    JOptionPane.showMessageDialog(this, "Connection failed.");
                }
                break;
            case "Disconnect":
                JOptionPane.showMessageDialog(this, "Disconnecting...");
                // Add your disconnect logic here
                break;
            case "Show Connection Status":
                // Add your show connection status logic here
                break;
            case "Show Table":
                JOptionPane.showMessageDialog(this, "Showing Table...");
                // Add your show table logic here
                break;
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new MyGUI();
    }
}
