package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateAccountPage {
    private String[] userAccount = new String[3];
    public static boolean newAccountCreated = false;
    public void createAccount(){
        JFrame frame = new JFrame("Create an account");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        frame.add(panel);

        JLabel lblName = new JLabel("Name: ");
        panel.add(lblName);

        JTextField txtName = new JTextField();
        panel.add(txtName);

        JLabel lblEmail = new JLabel("Email: ");
        panel.add(lblEmail);

        JTextField txtEmail = new JTextField();
        panel.add(txtEmail);

        JLabel lblPassword = new JLabel("Password: ");
        panel.add(lblPassword);

        JTextField txtPassword = new JTextField();
        panel.add(txtPassword);

        JButton btnCreate = new JButton("Create");
        panel.add(btnCreate);

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String [] userAccount = new String[3];
                String name = txtName.getText();
                String email = txtEmail.getText();
                String password = txtPassword.getText();
                //code to store user information in array
                userAccount[0] = name;
                userAccount[1] = email;
                userAccount[2] = password;
                newAccountCreated = true;

                //write userAccount array to csv file
                try (FileWriter writer = new FileWriter("accounts.csv", true)){
                    for (int i = 0; i < userAccount.length; i++){
                        writer.append(userAccount[i]);
                        writer.append(',');
                    }
                    writer.append('\n');
                } catch (IOException ex){
                    ex.printStackTrace();
                }

                //navigate to loginPage
                LoginPage login = new LoginPage();
                login.login();
                frame.setVisible(false);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        panel.add(btnCancel);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    //check entered email is valid
    public static boolean isValidEmail(String txtEmail){
        if(txtEmail != null){
            Pattern p = Pattern.compile("^[A-Za-z].*?@mail\\\\.com$");
            Matcher m = p.matcher(txtEmail);
            return m.find();
        }
        return false;
    }
    //check entered password is secure
    private boolean isValidPassword(String password) {
        //check if password contains at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 digit
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            return true;
        }
        else{
            return false;
        }
    }

    public String[] getUserAccount() {
        return userAccount;
    }


}
