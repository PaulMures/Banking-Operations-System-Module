//Name: Banking Operations
//Developer: Paul Muresan
//Date:
//Description: 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bank {

    //Instantiation
    JFrame frame = new JFrame(); //JFrame
    JPanel masterPanel = new JPanel(); //Master panel to hold all other panels
    JPanel buttonPanel = new JPanel(); //Panel to hold panel control buttons
    JPanel accountCreator = new JPanel(); //Panel to create accounts from
    JPanel transactionKiosk = new JPanel(); //Panel to handle transactions
    JPanel balanceInquiry = new JPanel(); //Panel for balance inquiries
    JPanel transactionHistory = new JPanel(); //Panel for transaction history
    
    public void run() {

        //Buttons
        JButton b1 = new JButton("HIDE SCREEN");
        b1.setPreferredSize(new Dimension(50,25));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                accountCreator.setVisible(true);
                transactionKiosk.setVisible(false);
                balanceInquiry.setVisible(false);
                transactionHistory.setVisible(false);
            }
        });

        JButton b2 = new JButton("UNHIDE SCREEN");
        b2.setPreferredSize(new Dimension(50,25));
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                accountCreator.setVisible(false);
                transactionKiosk.setVisible(true);
                balanceInquiry.setVisible(false);
                transactionHistory.setVisible(false);
            }
        });
         
        //Button Panel
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.add(b1); 
        buttonPanel.add(b2);

        //Master Panel
        masterPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        masterPanel.setLayout(new GridLayout(1, 6));
        //masterPanel.setBackground(new Color(0,0,0));
        masterPanel.add(buttonPanel);   
        masterPanel.add(accountCreator);    
        //masterPanel.add(transactionKiosk);
        //masterPanel.add(balanceInquiry);
        //masterPanel.add(transactionHistory);

        //Account Creator Panel
        accountCreator.setBorder(BorderFactory.createEmptyBorder(200, 200, 100, 200));
        accountCreator.setLayout(new GridLayout(3, 3));
        //accountCreator.setBackground(new Color(0,0,0));

        JLabel accountLabel = new JLabel("Poggers");
        accountCreator.add(accountLabel);
        
        //Transaction Kiosk Panel
        transactionKiosk.setBorder(BorderFactory.createEmptyBorder(200, 200, 100, 200));
        transactionKiosk.setLayout(new GridLayout(3, 3));
        transactionKiosk.setBackground(new Color(0,0,0));

        //Balance Inquiry Panel
        balanceInquiry.setBorder(BorderFactory.createEmptyBorder(200, 200, 100, 200));
        balanceInquiry.setLayout(new GridLayout(3, 3));
        balanceInquiry.setBackground(new Color(0,0,0));

        //Transaction History Panel
        transactionHistory.setBorder(BorderFactory.createEmptyBorder(200, 200, 100, 200));
        transactionHistory.setLayout(new GridLayout(3, 3));
        transactionHistory.setBackground(new Color(0,0,0));

        //Frame
        frame.add(masterPanel, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bank Operator");
        frame.pack();
        frame.setVisible(true);

    }
}
