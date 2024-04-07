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
    AccountManager accountManager = new AccountManager(); //AccountManager class object
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

                //Set only accountCreator panel visible
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

                //Set only transactionKiosk panel to visible
                accountCreator.setVisible(false);
                transactionKiosk.setVisible(true);
                balanceInquiry.setVisible(false);
                transactionHistory.setVisible(false);
            }
        });
         
        JButton balanceButton = new JButton("Balance Inquiry");
        balanceButton.setPreferredSize(new Dimension(200,100));
        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Set only balanceInquiry panel to visible
                accountCreator.setVisible(false);
                transactionKiosk.setVisible(false);
                balanceInquiry.setVisible(true);
                transactionHistory.setVisible(false);
            }
        });

        JButton transactionHButton = new JButton("Transaction History");
        transactionHButton.setPreferredSize(new Dimension(200,100));
        transactionHButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Set only transactionHistory visible
                accountCreator.setVisible(false);
                transactionKiosk.setVisible(false);
                balanceInquiry.setVisible(false);
                transactionHistory.setVisible(true);
            }
        });

        //Logo Panel -------------------------------------------------------------
        logoPanel.setLayout(null); //No layout manager
        logoPanel.setBackground(Color.GRAY);
        logoPanel.setBounds(0,0,700,100);

        //BB logo (colors and squares)
        JLabel logo = new JLabel("BB");
        logo.setBackground(Color.RED);
        logo.setForeground(Color.RED);
        logo.setBounds(15,5,70,70);
        logo.setOpaque(true);

        //Text within the BB logo
        JLabel logoText = new JLabel(" BB");
        logoText.setForeground(Color.GRAY);
        logoText.setBackground(new Color(150,0,0));
        logoText.setBounds(25,15,75,75);
        logoText.setFont(new Font("Times", Font.BOLD, 35));
        logoText.setOpaque(true);

        //Bank of Banking title
        JLabel title = new JLabel("Bank of Banking");
        title.setBounds(150,25,400,50);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Times", Font.BOLD, 30));

        //Add labels to panel
        logoPanel.add(logoText);
        logoPanel.add(logo);
        logoPanel.add(title);

        //Button Panel -------------------------------------------------------------
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.setBounds(0,100,700,100);

        //Add buttons to panel
        buttonPanel.add(createAccountButton); 
        buttonPanel.add(transactionKButton);
        buttonPanel.add(balanceButton);
        buttonPanel.add(transactionHButton);

        //Master Panel -------------------------------------------------------------
        masterPanel.setBounds(0,0,700,700);
        masterPanel.setLayout(null);

        //Add panels to master panel
        masterPanel.add(logoPanel);
        masterPanel.add(buttonPanel);   
        masterPanel.add(functionPane);

        //Function Pane -------------------------------------------------------------
        functionPane.setBounds(0,200,700,700);
        functionPane.setOpaque(true);

        //Add panels to layered pane
        functionPane.add(accountCreator, Integer.valueOf(0));    
        functionPane.add(transactionKiosk, Integer.valueOf(0));
        functionPane.add(balanceInquiry, Integer.valueOf(0));
        functionPane.add(transactionHistory, Integer.valueOf(0));

        //Account Creator Panel -------------------------------------------------------------
        accountCreator.setBounds(0,0,700,500);
        accountCreator.setLayout(null);
        accountCreator.setOpaque(true);
        accountCreator.setVisible(false);

        //Title
        JLabel accountLabel = new JLabel("Account Creation");
        accountLabel.setFont(new Font("Times", Font.BOLD, 20));
        accountLabel.setBounds(25,25,200,25);
        accountCreator.add(accountLabel);

        //Enter labels
        JLabel accountCNameLabel = new JLabel("Enter account name here:"); //Account name field label
        accountCNameLabel.setFont(new Font("Times", Font.BOLD, 15));
        accountCNameLabel.setBounds(25,100,200,20);
        accountCreator.add(accountCNameLabel);

        JLabel accountCInitialDepositLabel = new JLabel("Enter initial deposit here here:    $"); //Initial deposit field label
        accountCInitialDepositLabel.setFont(new Font("Times", Font.BOLD, 15));
        accountCInitialDepositLabel.setBounds(25,200,300,20);
        accountCreator.add(accountCInitialDepositLabel);

        JLabel accountCTypeLabel = new JLabel("Enter account type here:"); //Account type field label
        accountCTypeLabel.setFont(new Font("Times", Font.BOLD, 15));
        accountCTypeLabel.setBounds(25,300,200,20);
        accountCreator.add(accountCTypeLabel);

        //Text Areas
        JTextField accountCNameField = new JTextField(); //Account name field
        accountCNameField.setBounds(250,90,300,50);
        accountCreator.add(accountCNameField);

        JTextField accountCInitialDepositField = new JTextField(); //Initial deposit field
        accountCInitialDepositField.setBounds(300,190,150,50);
        accountCreator.add(accountCInitialDepositField);

        JTextField accountCTypeField = new JTextField(); //Account type field
        accountCTypeField.setBounds(250,290,300,50);
        accountCreator.add(accountCTypeField);

        //Creation button
        JButton generateAccount = new JButton("Create Account");
        generateAccount.setBounds(25,360,125,75);
        generateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Try to check if the input is a real integer
                try {

                    //If the integer is positive or 0
                    if (Double.parseDouble(accountCInitialDepositField.getText()) >= 0) {

                        String newAccountNumber = accountManager.newAccount(accountCNameField.getText(), accountCTypeField.getText(), accountCInitialDepositField.getText());
                        JOptionPane.showMessageDialog(null, ("Your account was created successfully!\nYour new account number is " + newAccountNumber), "Account Creation Completed", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {

                        JOptionPane.showMessageDialog(null, "Initial Deposit amount invalid!\nMust be greater than or equal to 0", "Initial Deposit Invalid", JOptionPane.ERROR_MESSAGE);
                    }

                }
                catch (Exception i) {

                    JOptionPane.showMessageDialog(null, "Initial Deposit amount invalid!\nMust be a valid integer", "Initial Deposit Invalid", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        accountCreator.add(generateAccount);

        
        //Transaction Kiosk Panel -------------------------------------------------------------
        transactionKiosk.setBounds(0,0,700,500);
        transactionKiosk.setLayout(null);
        transactionKiosk.setOpaque(true);
        transactionKiosk.setVisible(false);

        //Title
        JLabel transactionLabel = new JLabel("Transaction"); //Transaction title label
        transactionLabel.setFont(new Font("Times", Font.BOLD, 20));
        transactionLabel.setBounds(25,25,200,25);
        transactionKiosk.add(transactionLabel);

        //Enter labels
        JLabel accountTNumLabel = new JLabel("Enter account number here:"); //Account number field label
        accountTNumLabel.setFont(new Font("Times", Font.BOLD, 15));
        accountTNumLabel.setBounds(25,100,225,20);
        transactionKiosk.add(accountTNumLabel);

        JLabel transactionAmountLabel = new JLabel("Enter transaction amount here:    $"); //Transaction amount field label
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

                //Try to see if integer is a valid integer
                try {

                    //Validate that the given number is not negative or 0
                    if (Double.parseDouble(transactionAmountField.getText()) > 0) {

                        //Validate that the given number is not more than 1,000,000
                        if (Double.parseDouble(transactionAmountField.getText()) <= 1000000) {

                            //Check if account number is valid
                            if (accountManager.validateAccountNumber(accountNumField.getText())) {

                                //Generate transaction
                                accountManager.newTransaction(accountNumField.getText(), "Deposit", Double.parseDouble(transactionAmountField.getText()), false);
                                JOptionPane.showMessageDialog(null, "Your deposit was sucessfully processed", "Deposit Completed", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else {

                                JOptionPane.showMessageDialog(null, "Account Number Invalid!\nMust be a valid account number", "Account Number Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {

                            JOptionPane.showMessageDialog(null, "Deposit amount invalid!\nCannot deposit more than $1,000,000 at a time", "Deposit Invalid", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Deposit amount invalid!\nMust be greater than 0", "Deposit Invalid", JOptionPane.ERROR_MESSAGE);
                    }

                }
                catch (Exception i) {

                    JOptionPane.showMessageDialog(null, "Deposit amount invalid!\nMust be a valid integer", "Deposit Invalid", JOptionPane.ERROR_MESSAGE);

                }
            }
        });
        transactionKiosk.add(generateDeposit);

        //Withdrawal button
        JButton generateWithdrawal = new JButton("Withdraw");
        generateWithdrawal.setBounds(175,300,125,75);
        generateWithdrawal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Check if the given integer is a valid integer
                try {

                    //Validate that the given number is not negative or 0
                    if (Double.parseDouble(transactionAmountField.getText()) > 0) {

                        //Check if account number is valid
                        if (accountManager.validateAccountNumber(accountNumField.getText())) {

                            //Generate transaction
                            if (accountManager.newTransaction(accountNumField.getText(), "Withdraw", Double.parseDouble(transactionAmountField.getText()), false)) {

                                JOptionPane.showMessageDialog(null, "Your withdrawal was sucessfully processed", "Withdrawal Completed", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else {

                                JOptionPane.showMessageDialog(null, "Withdrawal amount invalid!\nWithdrawal cannot exceed account balance", "Withdrawal Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {

                            JOptionPane.showMessageDialog(null, "Account Number Invalid!\nMust be a valid account number", "Account Number Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                    else {

                        JOptionPane.showMessageDialog(null, "Withdrawal amount invalid!\nMust be greater than 0", "Withdrawal Invalid", JOptionPane.ERROR_MESSAGE);
                    }

                }
                catch (Exception i) {

                    JOptionPane.showMessageDialog(null, "Withdrawal amount invalid!\nMust be a valid integer", "Withdrawal Invalid", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        transactionKiosk.add(generateWithdrawal);

        //Balance Inquiry Panel -------------------------------------------------------------
        balanceInquiry.setBounds(0,0,700,500);
        balanceInquiry.setLayout(null);
        balanceInquiry.setOpaque(true);
        balanceInquiry.setVisible(false);

        //Title
        JLabel balanceInquiryLabel = new JLabel("Balance Inquiry"); //Balance inquiry title label
        balanceInquiryLabel.setFont(new Font("Times", Font.BOLD, 20));
        balanceInquiryLabel.setBounds(25,25,200,25);
        balanceInquiry.add(balanceInquiryLabel);

        //Enter labels
        JLabel accountBILabel = new JLabel("Enter account number here:"); //Account number field label
        accountBILabel.setFont(new Font("Times", Font.BOLD, 15));
        accountBILabel.setBounds(25,100,225,20);
        balanceInquiry.add(accountBILabel);

        //Text Areas
        JTextField accountBField = new JTextField(); //Account number field
        accountBField.setBounds(250,90,300,50);
        balanceInquiry.add(accountBField);

        //Balance label
        JLabel returnedBalanceLabel = new JLabel("Balance: ");
        returnedBalanceLabel.setFont(new Font("Times", Font.BOLD, 50));
        returnedBalanceLabel.setBounds(25,300,400,50);
        returnedBalanceLabel.setOpaque(true);
        returnedBalanceLabel.setVisible(true);
        balanceInquiry.add(returnedBalanceLabel);

        //Inquiry button
        JButton generateBalanceInquiry = new JButton("Inquire");
        generateBalanceInquiry.setBounds(560,80,125,75);
        generateBalanceInquiry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //If the account number is valid
                if (accountManager.validateAccountNumber(accountBField.getText())) {

                    //Run balance inquiry and return balance
                    String returnedBalance = accountManager.balanceInquiry(accountBField.getText());
                    returnedBalanceLabel.setText("Balance: $" + returnedBalance);
                }
                else {

                    JOptionPane.showMessageDialog(null, "The given account number is invalid, please try again", "Invalid Account Number", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        balanceInquiry.add(generateBalanceInquiry);

        //Transaction History Panel -------------------------------------------------------------
        transactionHistory.setBounds(0,0,700,500);
        transactionHistory.setLayout(null);
        transactionHistory.setOpaque(true);
        transactionHistory.setVisible(false);

        //Title
        JLabel transactionHistoryLabel = new JLabel("Transaction History"); //Transaction history title label
        transactionHistoryLabel.setFont(new Font("Times", Font.BOLD, 20));
        transactionHistoryLabel.setBounds(25,25,250,25);
        transactionHistory.add(transactionHistoryLabel);

        //Enter labels
        JLabel accountTHNumberLabel = new JLabel("Enter account number here:"); //Account number field label
        accountTHNumberLabel.setFont(new Font("Times", Font.BOLD, 15));
        accountTHNumberLabel.setBounds(25,100,225,20);
        transactionHistory.add(accountTHNumberLabel);

        //Text Areas
        JTextField accountTHNumberField = new JTextField(); //Account number field
        accountTHNumberField.setBounds(250,90,300,50);
        transactionHistory.add(accountTHNumberField);

        //Balance label
        JLabel transactionsListingLabel = new JLabel("Transactions");
        transactionsListingLabel.setFont(new Font("Times", Font.BOLD, 30));
        transactionsListingLabel.setBounds(25,150,400,50);
        transactionsListingLabel.setOpaque(true);
        transactionsListingLabel.setVisible(true);

        JTextArea returnedTransactionsArea = new JTextArea("");
        returnedTransactionsArea.setFont(new Font("Times", Font.PLAIN, 20));
        returnedTransactionsArea.setBounds(25,200,600,250);
        returnedTransactionsArea.setEditable(false); //Lock field to not be editable
        returnedTransactionsArea.setOpaque(true);
        returnedTransactionsArea.setVisible(true);

        transactionHistory.add(transactionsListingLabel);
        transactionHistory.add(returnedTransactionsArea);

        //Inquiry button
        JButton generateTransactionHistory = new JButton("History");
        generateTransactionHistory.setBounds(560,80,125,75);
        generateTransactionHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //If the account number is valid
                if (accountManager.validateAccountNumber(accountTHNumberField.getText())) {

                    //Run transactionHistory and return history string
                    String returnedTransactions = accountManager.transactionHistory(accountTHNumberField.getText());
                    returnedTransactionsArea.setText("Account Number,Transaction Amount,Date\n" + returnedTransactions);
                }
                else {

                    JOptionPane.showMessageDialog(null, "The given account number is invalid, please try again", "Invalid Account Number", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        transactionHistory.add(generateTransactionHistory);

        //Frame -------------------------------------------------------------
        frame.add(masterPanel);
        frame.setSize(700,700);
        frame.setMinimumSize(new Dimension(700,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bank Operator");
        frame.setLayout(null); //No layout manager for custom positioning
        frame.pack();
        frame.setVisible(true);

    }
}
