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
    
    public void newAccount(String accountHolderName, String accountType, String initialDeposit) {

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
            }


    public void newTransaction(String accountNumber, String action, int actionAmount) {

        //Variables
        String filename; //Undefined for later flexibility
        BufferedWriter fileWriter;
        BufferedReader reader = null; //Buffered reader
        String line = ""; //Line string for storing each line

        //Change account balance -------------------------------------------------------------

        //Variables
        filename = "accounts.csv"; //Filename for accounts
        int accountFoundTracker = 0;
    
        //Tries the code
        try {
            //Instantiating file reader
            reader = new BufferedReader(new FileReader(filename)); //Passes file reader which passes filename

            //Iterate through each line
            while((line = reader.readLine()) != null) {

                //Split line string at each comma and store
                String[] accountString = line.split(","); //Split by comma

                //Find account
                if (accountString[0].equals(accountNumber)) {

                    //Calculate new balance and convert to string
                    String newBalance = Integer.toString(Integer.parseInt(accountString[3]) + actionAmount);

                    //Replace balance with new balance in line string
                    line.replace(accountString[3], newBalance);

                    accountFoundTracker++;
                }
            }

            if (accountFoundTracker == 0) {

                System.out.println("Account Not Found");
                //ADD POP UP
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

        //Write transaction -------------------------------------------------------------

        filename = "transactions.csv"; //Filename for transactions

        //Get date
        Calendar calendar = Calendar.getInstance(); //Instantiate calendar
        String day, month, year;

        //If day is <10th
        if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {

            //Put 0 in front
            day = "0" + Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        }
        else {
            day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
        }

        //If month is <10th
        if (calendar.get(Calendar.MONTH) < 10) {
    
            //Put 0 in front
            month = "0" + Integer.toString(calendar.get(Calendar.MONTH));
        }
        else {
            month = Integer.toString(calendar.get(Calendar.MONTH));
        }

        year = Integer.toString(calendar.get(Calendar.YEAR)); //Year string

        String date = (day + "-" + month + "-" + year); //Sets string to Day-Month-Year

        //Write at end of file the transaction
        try {

            fileWriter = new BufferedWriter(new FileWriter(filename, true)); //Passes file writer which passes filename
            fileWriter.write(System.lineSeparator() + accountNumber + "," + action + "," + date); //Writes to file
            fileWriter.close(); //Close writer

        } catch (IOException e) {
            
            e.printStackTrace();
        }

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
        String transactions = "";

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
}
