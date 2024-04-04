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
    JPanel logoPanel = new JPanel(); //Logo panel
    JPanel buttonPanel = new JPanel(); //Panel to hold panel control buttons
    JLayeredPane functionPane = new JLayeredPane(); //Layered pane for all method panes
    JPanel accountCreator = new JPanel(); //Panel to create accounts from
    JPanel transactionKiosk = new JPanel(); //Panel to handle transactions
    JPanel balanceInquiry = new JPanel(); //Panel for balance inquiries
    JPanel transactionHistory = new JPanel(); //Panel for transaction history
    
    public void run() {

        //Master Buttons -------------------------------------------------------------
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setPreferredSize(new Dimension(200,100));
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                accountCreator.setVisible(true);
                transactionKiosk.setVisible(false);
                balanceInquiry.setVisible(false);
                transactionHistory.setVisible(false);
            }
        });

        JButton transactionKButton = new JButton("Process Transaction");
        transactionKButton.setPreferredSize(new Dimension(200,100));
        transactionKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                accountCreator.setVisible(false);
                transactionKiosk.setVisible(true);
                balanceInquiry.setVisible(false);
                transactionHistory.setVisible(false);
            }
        });
         
        JButton balanceButton = new JButton("Create Account");
        balanceButton.setPreferredSize(new Dimension(200,100));
        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                accountCreator.setVisible(false);
                transactionKiosk.setVisible(false);
                balanceInquiry.setVisible(true);
                transactionHistory.setVisible(false);
            }
        });

        JButton transactionHButton = new JButton("Create Account");
        transactionHButton.setPreferredSize(new Dimension(200,100));
        transactionHButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                accountCreator.setVisible(false);
                transactionKiosk.setVisible(false);
                balanceInquiry.setVisible(false);
                transactionHistory.setVisible(true);
            }
        });

        //Logo Panel -------------------------------------------------------------
        logoPanel.setLayout(null);
        logoPanel.setBackground(Color.GRAY);
        logoPanel.setBounds(0,0,700,100);

        JLabel logo = new JLabel("BB");
        logo.setBackground(Color.RED);
        logo.setForeground(Color.RED);
        logo.setBounds(15,5,70,70);
        logo.setOpaque(true);

        JLabel logoText = new JLabel(" BB");
        logoText.setForeground(Color.GRAY);
        logoText.setBackground(new Color(150,0,0));
        logoText.setBounds(25,15,75,75);
        logoText.setFont(new Font("Times", Font.BOLD, 35));
        logoText.setOpaque(true);

        JLabel title = new JLabel("Bank of Banking");
        title.setBounds(150,25,400,50);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Times", Font.BOLD, 30));

        logoPanel.add(logoText);
        logoPanel.add(logo);
        logoPanel.add(title);

        //Button Panel -------------------------------------------------------------
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.setBounds(0,100,700,100);
        buttonPanel.add(createAccountButton); 
        buttonPanel.add(transactionKButton);
        buttonPanel.add(balanceButton);
        buttonPanel.add(transactionHButton);

        //Master Panel -------------------------------------------------------------
        //masterPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        masterPanel.setBounds(0,0,700,700);
        //masterPanel.setLayout(new GridLayout(3, 1));
        masterPanel.setLayout(null);
        //masterPanel.setBackground(new Color(0,0,0));
        masterPanel.add(logoPanel);
        masterPanel.add(buttonPanel);   
        masterPanel.add(functionPane);

        //Function Pane -------------------------------------------------------------
        //functionPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 500, 500));
        functionPane.setBounds(0,200,700,700);
        functionPane.setOpaque(true);

        functionPane.add(accountCreator, Integer.valueOf(0));    
        functionPane.add(transactionKiosk, Integer.valueOf(0));
        functionPane.add(balanceInquiry, Integer.valueOf(0));
        functionPane.add(transactionHistory, Integer.valueOf(0));

        //Account Creator Panel -------------------------------------------------------------
        //accountCreator.setBorder(BorderFactory.createEmptyBorder(0,0,400,400));
        accountCreator.setBounds(0,0,700,500);
        accountCreator.setLayout(null);
        accountCreator.setOpaque(true);
        accountCreator.setVisible(false);
        //accountCreator.setBackground(Color.BLUE);

        //Title
        JLabel accountLabel = new JLabel("Account Creation");
        accountLabel.setFont(new Font("Times", Font.BOLD, 20));
        accountLabel.setBounds(25,25,200,25);
        accountCreator.add(accountLabel);

        //Enter labels
        JLabel accountCNameLabel = new JLabel("Enter account name here:"); //Account name field
        accountCNameLabel.setFont(new Font("Times", Font.BOLD, 15));
        accountCNameLabel.setBounds(25,100,200,20);
        accountCreator.add(accountCNameLabel);

        JLabel accountCInitialDepositLabel = new JLabel("Enter initial deposit here here:    $"); //Initial deposit field
        accountCInitialDepositLabel.setFont(new Font("Times", Font.BOLD, 15));
        accountCInitialDepositLabel.setBounds(25,200,300,20);
        accountCreator.add(accountCInitialDepositLabel);

        JLabel accountCTypeLabel = new JLabel("Enter account type here:"); //Account type field
        accountCTypeLabel.setFont(new Font("Times", Font.BOLD, 15));
        accountCTypeLabel.setBounds(25,300,200,20);
        accountCreator.add(accountCTypeLabel);

        //Text Areas
        JTextField accountCName = new JTextField(); //Account name field
        accountCName.setBounds(250,90,300,50);
        accountCreator.add(accountCName);

        JTextField accountCInitialDeposit = new JTextField(); //Initial deposit field
        accountCInitialDeposit.setBounds(300,190,150,50);
        accountCreator.add(accountCInitialDeposit);

        JTextField accountCType = new JTextField(); //Account type field
        accountCType.setBounds(250,290,300,50);
        accountCreator.add(accountCType);

        //Creation button
        JButton generateAccount = new JButton("Create Account");
        generateAccount.setBounds(25,360,125,75);
        generateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Lesgooo");
            }
        });
        accountCreator.add(generateAccount);

        
        //Transaction Kiosk Panel -------------------------------------------------------------
        transactionKiosk.setBounds(0,0,700,500);
        transactionKiosk.setLayout(null);
        transactionKiosk.setOpaque(true);
        transactionKiosk.setVisible(false);

        //Title
        JLabel transactionLabel = new JLabel("Transaction");
        transactionLabel.setFont(new Font("Times", Font.BOLD, 20));
        transactionLabel.setBounds(25,25,200,25);
        transactionKiosk.add(transactionLabel);

        //Enter labels
        JLabel accountTNumLabel = new JLabel("Enter account number here:"); //Account number field
        accountTNumLabel.setFont(new Font("Times", Font.BOLD, 15));
        accountTNumLabel.setBounds(25,100,225,20);
        transactionKiosk.add(accountTNumLabel);

        JLabel transactionAmountLabel = new JLabel("Enter transaction amount here:    $"); //Transaction amount field
        transactionAmountLabel.setFont(new Font("Times", Font.BOLD, 15));
        transactionAmountLabel.setBounds(25,200,300,20);
        transactionKiosk.add(transactionAmountLabel);

        //Text Areas
        JTextField accountNumField = new JTextField(); //Account number field
        accountNumField.setBounds(250,90,300,50);
        transactionKiosk.add(accountNumField);

        JTextField transactionAmountField = new JTextField(); //Transaction amount field
        transactionAmountField.setBounds(300,190,150,50);
        transactionKiosk.add(transactionAmountField);

        //Deposit button
        JButton generateDeposit = new JButton("Deposit");
        generateDeposit.setBounds(25,300,125,75);
        generateDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Where's that damn mule");
            }
        });
        transactionKiosk.add(generateDeposit);

        //Withdrawal button
        JButton generateWithdrawal = new JButton("Withdraw");
        generateWithdrawal.setBounds(175,300,125,75);
        generateWithdrawal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Supercredits found");
            }
        });
        transactionKiosk.add(generateWithdrawal);

        //Balance Inquiry Panel -------------------------------------------------------------
        balanceInquiry.setBounds(0,0,700,500);
        balanceInquiry.setLayout(null);
        balanceInquiry.setOpaque(true);
        balanceInquiry.setVisible(false);

        //Title
        JLabel balanceInquiryLabel = new JLabel("Balance Inquiry");
        balanceInquiryLabel.setFont(new Font("Times", Font.BOLD, 20));
        balanceInquiryLabel.setBounds(25,25,200,25);
        balanceInquiry.add(balanceInquiryLabel);

        //Enter labels
        JLabel accountBILabel = new JLabel("Enter account number here:"); //Account number field
        accountBILabel.setFont(new Font("Times", Font.BOLD, 15));
        accountBILabel.setBounds(25,100,225,20);
        balanceInquiry.add(accountBILabel);

        //Text Areas
        JTextField accountBField = new JTextField(); //Account number field
        accountBField.setBounds(250,90,300,50);
        balanceInquiry.add(accountBField);

        //Inquiry button
        JButton generateBalanceInquiry = new JButton("Inquire");
        generateBalanceInquiry.setBounds(560,80,125,75);
        generateBalanceInquiry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Here are the numbers");
            }
        });
        balanceInquiry.add(generateBalanceInquiry);

        //Transaction History Panel -------------------------------------------------------------
        transactionHistory.setBounds(0,0,700,500);
        transactionHistory.setLayout(null);
        transactionHistory.setOpaque(true);
        transactionHistory.setVisible(false);

        //Title
        JLabel transactionHistoryLabel = new JLabel("Transaction History");
        transactionHistoryLabel.setFont(new Font("Times", Font.BOLD, 20));
        transactionHistoryLabel.setBounds(25,25,250,25);
        transactionHistory.add(transactionHistoryLabel);

        //Enter labels
        JLabel accountTHNumberLabel = new JLabel("Enter account number here:"); //Account number field
        accountTHNumberLabel.setFont(new Font("Times", Font.BOLD, 15));
        accountTHNumberLabel.setBounds(25,100,225,20);
        transactionHistory.add(accountTHNumberLabel);

        //Text Areas
        JTextField accountTHNumberField = new JTextField(); //Account number field
        accountTHNumberField.setBounds(250,90,300,50);
        transactionHistory.add(accountTHNumberField);

        //Inquiry button
        JButton generateTransactionHistory = new JButton("History");
        generateTransactionHistory.setBounds(560,80,125,75);
        generateTransactionHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("FOR SUPER EARTH!!!!");
            }
        });
        transactionHistory.add(generateTransactionHistory);

        //Frame -------------------------------------------------------------
        frame.add(masterPanel);
        frame.setSize(700,700);
        frame.setMinimumSize(new Dimension(700,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bank Operator");
        frame.setLayout(null);
        frame.pack();
        frame.setVisible(true);

    }
}
