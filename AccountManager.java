//
//
//
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

public class AccountManager {
    
    public String newAccount(String accountHolderName, String accountType, String initialDeposit) {

                //Variables
                String filename = "accounts.csv"; //Filename
                BufferedReader reader = null; //Buffered reader
                String line = ""; //Line string for storing each line
                BufferedWriter fileWriter;
                boolean accountNumberValid = false; //Valid account number tracking
                Random random = new Random(); //Random
                String newAccountNumber = "Not Generated"; //New Account Number string, currently ungenerated
        
                //Tries the code
                try {
                    //Instantiating file reader
                    reader = new BufferedReader(new FileReader(filename)); //Passes file reader which passes filename
                    fileWriter = new BufferedWriter(new FileWriter(filename, true)); //Passes file writer which passes filename
        
                    do {

                        newAccountNumber = ""; //Set newAccountNumber to blank

                        //Run 5 times to generate a 5 digit number
                        for (int i = 0; i < 5; i++) {

                        //Generate account number
                        newAccountNumber = newAccountNumber + Integer.toString(random.nextInt(7));

                        }

                        int identicalNumberTracker = 0; //Keeping track of identical account numbers

                        //Check account number
                        while((line = reader.readLine()) != null) {

                            //Split line string at each comma and store
                            String[] accountString = line.split(","); //Split by comma
        
                            if (accountString[0].equals(newAccountNumber)) {
        
                                //If there's an identical number, add to tracker
                                identicalNumberTracker++;
                            }
                        }

                        if (identicalNumberTracker == 0) {

                            //If there are no identical numbers, the program can proceed
                            accountNumberValid = true;
                        }

                    } while (accountNumberValid == false);

                    //Write at end of file account info
                    fileWriter.write(System.lineSeparator() + newAccountNumber + "," + accountHolderName + "," + accountType + "," + initialDeposit);
                    fileWriter.close();

                    //Create transaction
                    newTransaction(newAccountNumber, "Deposit", Double.parseDouble(initialDeposit));
                }
                catch(Exception e) { //Catches all exceptions
        
                    System.out.println("ERROR!!!!");
                    e.printStackTrace();
                }
                finally {
        
                    //Closing reader
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                //Return account number
                return newAccountNumber;
            }

    public boolean newTransaction(String accountNumber, String action, double actionAmount) {

        //Update balance method, return boolean value
        boolean balanceUpdated = updateBalance(accountNumber, action ,actionAmount);

        //If balance was valid and updated, proceed to writing into transactions.csv
        if (balanceUpdated) {

                //Write transaction -------------------------------------------------------------

            //Variables
            BufferedWriter fileWriter = null;
            String filename = "transactions.csv"; //Filename for transactions

            //Get date
            Calendar calendar = Calendar.getInstance(); //Instantiate calendar
            String day, month, year;

            //If day is <10th
            if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {

                //Put 0 in front
                day = "0" + Double.toString(calendar.get(Calendar.DAY_OF_MONTH));
            }
            else {
                day = Double.toString(calendar.get(Calendar.DAY_OF_MONTH));
            }

            //If month is <10th
            if (calendar.get(Calendar.MONTH) < 10) {
        
                //Put 0 in front
                month = "0" + Double.toString(calendar.get(Calendar.MONTH));
            }
            else {
                month = Double.toString(calendar.get(Calendar.MONTH));
            }

            year = Double.toString(calendar.get(Calendar.YEAR)); //Year string

            String date = (day + "-" + month + "-" + year); //Sets string to Day-Month-Year

            //Write at end of file the transaction
            try {

                fileWriter = new BufferedWriter(new FileWriter(filename, true)); //Passes file writer which passes filename, with append = true
                fileWriter.write(System.lineSeparator() + accountNumber + "," + action + " " + actionAmount + "," + date); //Writes to file
                fileWriter.close(); //Close writer
                return true;

            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }

        //If balance was not valid, return false
        return false;
    }

    public String balanceInquiry(String accountNumber) {

        //Variables
        String filename = "accounts.csv"; //Filename
        BufferedReader reader = null; //Buffered reader
        String line = ""; //Line string for storing each line
        String balance = "";

        //Tries the code
        try {
            //Instantiating file reader
            reader = new BufferedReader(new FileReader(filename)); //Passes file reader which passes filename
            int lineCounter = 0; //Line counter to track line number

            //Iterate through each line
            while((line = reader.readLine()) != null) {

                //If statement to skip the first line
                if (lineCounter != 0) {
                    //Split line string at each comma and store
                    String[] accountString = line.split(","); //Split by comma

                    if (accountString[0].equals(accountNumber)) {

                        balance = accountString[3];
                    }
                }
                ++lineCounter;
            }
        }
        catch(Exception e) { //Catches all exceptions

            System.out.println("ERROR!!!!");
            e.printStackTrace();
        }
        finally {

            //Closing reader
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return balance;
    }

    public String transactionHistory(String accountNumber) {

        //Variables
        String filename = "transactions.csv"; //Filename
        BufferedReader reader = null; //Buffered reader
        String line = ""; //Line string for storing each line
        String transactions = ""; //Transaction history string

        //Tries the code
        try {
            //Instantiating file reader
            reader = new BufferedReader(new FileReader(filename)); //Passes file reader which passes filename
            int lineCounter = 0; //Line counter to track line number

            //Iterate through each line
            while((line = reader.readLine()) != null) {

                //If statement to skip the first line
                if (lineCounter != 0) {
                    //Split line string at each comma and store
                    String[] accountString = line.split(","); //Split by comma

                    if (accountString[0].equals(accountNumber)) {
                        
                        //Add to history string
                        transactions = transactions + "\n" + line;
                    }
                }
                ++lineCounter;
            }
        }
        catch(Exception e) { //Catches all exceptions

            System.out.println("ERROR!!!!");
            e.printStackTrace();
        }
        finally {

            //Closing reader
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return transactions;

    }

    public boolean updateBalance(String accountNumber, String action, double actionAmount) {

        //Variables
        String filename = "accounts.csv"; //Filename
        BufferedReader reader = null; //Buffered reader
        BufferedWriter fileWriter = null; //Buffered writer
        String line = ""; //Line string for storing each line
        String accountsRewrite = "";
        String newBalance = "";

        //Tries the code
        try {
            //Instantiating file reader
            reader = new BufferedReader(new FileReader(filename)); //Passes file reader which passes filename

            //Iterate through each line
            while((line = reader.readLine()) != null) {

                //Split line string at each comma and store
                String[] accountString = line.split(","); //Split by comma

                if (accountString[0].equals(accountNumber)) {

                    //If withdrawal
                    if (action.equals("Withdraw")) {

                        if (actionAmount > Double.parseDouble(accountString[3])) {

                            return false;

                        }
                        else {

                            //New balance
                            newBalance = Double.toString((Double.parseDouble(accountString[3])) - (actionAmount));
                        }
                        
                    }
                    else { //Deposit

                        //New balance
                        newBalance = Double.toString((Double.parseDouble(accountString[3])) + (actionAmount));
                    }

                    //Rewrite line then store
                    accountsRewrite = accountsRewrite + line.replace(accountString[3], newBalance) + System.lineSeparator();

                }
                else {

                    accountsRewrite = accountsRewrite + line + System.lineSeparator();
                }
            }

            //Write new file
            fileWriter = new BufferedWriter(new FileWriter(filename)); //Passes file writer which passes filename, with append = false
            fileWriter.write(accountsRewrite); //Writes to file
            fileWriter.close(); //Close writer
            return true;

        }
        catch(Exception e) { //Catches all exceptions

            System.out.println("ERROR!!!!");
            e.printStackTrace();
        }
        finally {

            //Closing reader
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //If all goes wrong, return false
        return false;
    }

    public boolean validateAccountNumber(String accountNumber) {

        //Variables
        BufferedReader reader = null; //Buffered reader
        String filename = "accounts.csv";
        String line = ""; //Line string for storing each line
        int validAccountTracker = 0;

        //Tries the code
        try {
            //Instantiating file reader
            reader = new BufferedReader(new FileReader(filename)); //Passes file reader which passes filename

            //Iterate through each line
            while((line = reader.readLine()) != null) {

                //Split line string at each comma and store
                String[] accountString = line.split(","); //Split by comma

                //If the account has been found
                if (accountString[0].equals(accountNumber)) {
                    
                    validAccountTracker++;
                }
            }

            if (validAccountTracker > 0) {

                //Account exists
                return true;
            }
            else {

                //Account doesn't exist
                return false;
            }
        }
        catch(Exception e) { //Catches all exceptions

            System.out.println("ERROR!!!!");
            e.printStackTrace();
        }
        finally {

            //Closing reader
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //If all goes wrong return false
        return false;
    }

}
