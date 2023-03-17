package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {
    public static void main(String[] args) {
        new WelcomePage();
    }
    public WelcomePage(){
        setTitle("Welcome");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        getContentPane().add(panel);

        JButton btnLogin = new JButton("Log in");
        panel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //navigate to login page
                LoginPage login = new LoginPage();
                login.login();
                setVisible(false);
            }
        });



        JButton btnCreateAccount = new JButton("Create an account");
        panel.add(btnCreateAccount);

        btnCreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //navigate to create account page
                CreateAccountPage createAccount = new CreateAccountPage();
                createAccount.createAccount();
                setVisible(false);
            }
        });

        setVisible(true);
    }

    public void welcomePage() {
    }


}