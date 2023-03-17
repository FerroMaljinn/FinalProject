package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    public static void main(String[] args){
        new HomePage();
    }
    public void displayClasses(){

    }

    public HomePage(){
        setTitle("Home\nWelcome ");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        getContentPane().add(panel);

        JButton btnBalance = new JButton("Balance");
        panel.add(btnBalance);
        btnBalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //navigate to page to check balance
                BalancePage balance = new BalancePage();
                balance.balance();
            }
        });


        JButton btnManageAccount = new JButton("Manage Account");
        panel.add(btnManageAccount);
        btnManageAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //navigate to page to check balance
                ManageAccountPage manageAccount = new ManageAccountPage();
                manageAccount.manageAccount();
            }
        });


        JButton btnOverdraft = new JButton("Overdraft");
        panel.add(btnOverdraft);
        btnOverdraft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OverdraftPage overdraft = new OverdraftPage();
                overdraft.overdraft();
            }
        });


        JButton btnLogout = new JButton("Log out");
        panel.add(btnLogout);
        btnLogout.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomePage welcomePage = new WelcomePage();
                welcomePage.welcomePage();
                setVisible(false);
            }
        }));
        setVisible(true);
    }

    public void home() {
    }
}
