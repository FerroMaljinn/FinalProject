package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage {

    private User [] userAccounts;

    private String [] userAccount;
    public void login() {
        userAccounts = new User [10];
        try (BufferedReader br = new BufferedReader(new FileReader("accounts.csv"))) {
            String line;
            int i = 0;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println(line);
                User tempUser = new User(values[0], values[1], values[2]);
                userAccounts[i] = tempUser;
                i++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        frame.add(panel);

        JLabel lblEmail = new JLabel("Email: ");
        panel.add(lblEmail);

        JTextField txtEmail = new JTextField();
        panel.add(txtEmail);

        JLabel lblPassword = new JLabel("Password: ");
        panel.add(lblPassword);

        JTextField txtPassword = new JTextField();
        panel.add(txtPassword);

        JButton btnLogin = new JButton("Login");
        panel.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //error message
                if (userAccounts[0] == null) {
                    JOptionPane.showMessageDialog(null, "No account found. Please create an account first.");
                    return;
                }

                //retrieve entered email and password
                String enteredEmail = txtEmail.getText();
                String enteredPassword = txtPassword.getText();
                //code to remove spaces or extra characters
                // if (enteredEmail.equals(userAccount[1].replaceAll("[\\[\\]]","")) && Arrays.equals(enteredPassword, userAccount[2].toCharArray())) {

                //compare entered email and password to stored user accounts
                //add for loop to iterate between all accounts
                //10 is fixed value - to consider
                //for (int i = 0; i < userAccounts.length; i++) {
                    //while (userAccounts[i] != null) {
                        if (userAccounts[0].getEmail().equals(enteredEmail) && userAccounts[0].getPassword().equals(enteredPassword)) {
                            JOptionPane.showMessageDialog(null, "Successful login");
                            HomePage homePage = new HomePage();
                            homePage.displayClasses();
                            frame.setVisible(false);
                            //allow user to access desired functionality
                        } else {
                            System.out.println(userAccounts[0].getPassword());
                            System.out.println(enteredPassword);
                            JOptionPane.showMessageDialog(null, "Incorrect email or password, please try again.");
                        }
                    }
        });

        JButton btnCancel = new JButton("Cancel");
        panel.add(btnCancel);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        frame.setVisible(true);
    }
}