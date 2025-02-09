


// Main Class

import logic.InventoryPanelManager;
import loginInterface.loginInterface;
import loginInterface.loginLogic;
import panels.NavigationBar;
import panels.header;
import javax.swing.*;
import java.awt.*;

/**
 * Driver Class used for running the program
 */
public class Driver {
 public static void main(String[] args) {
        JFrame frame = new JFrame("Inventory Monitoring Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 850);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

//        Add login interface
        loginInterface loginInterface = new loginInterface();
        frame.add(loginInterface,BorderLayout.CENTER);

        InventoryPanelManager panelManager = new InventoryPanelManager();
        NavigationBar navBar = new NavigationBar(panelManager);
        header head = new header();
        panelManager.setVisible(false);
        navBar.setVisible(false);
        head.setVisible(false);


        loginInterface.loginButton.addActionListener(e -> {
            char[] passwordChars = loginInterface.passwordText.getPassword();
            String password = new String(passwordChars);

            String username = loginInterface.userText.getText();

            String Password = loginLogic.hashPassword(password);
            System.out.println("hash " + Password);
            String authenticate = loginLogic.authenticateUser(username,Password);
            System.out.println(username + " " + password);
            if (authenticate != null && authenticate.equals(username)) {
                System.out.println("Login Successful");
                loginInterface.setVisible(false);
                panelManager.showPanel("home");
                frame.add(navBar, BorderLayout.WEST);
                frame.add(panelManager, BorderLayout.CENTER);
                frame.add(head, BorderLayout.NORTH);

                panelManager.setVisible(true);
                navBar.setVisible(true);
                head.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(frame,"Incorrect Password or Username\nDEFAULT USERNAME : admin\nDEFAULT PASSWORD:admin");
            }
        });
        loginLogic.addEnterKeyListener(loginInterface.passwordText,loginInterface.loginButton);
        frame.setVisible(true);
        }
    }


