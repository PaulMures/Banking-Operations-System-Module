//
//
//
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
                    fileWriter = new BufferedWriter(new FileWriter(filename)); //Passes file writer which passes filename
        
                    do {

                        newAccountNumber = ""; //Set newAccountNumber to blank

                        for (int i = 0; i < 6; i++) {

                        //Generate account number
                        newAccountNumber = newAccountNumber + Integer.toString(random.nextInt(7));
                        System.out.println(newAccountNumber); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!

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
                            System.out.println("account num valid");
                        }

                    } while (accountNumberValid == false);

                    //Write at end of file
                    while((line = reader.readLine()) != null) {

                        if((line = reader.readLine()) == null) {
        
                            //Write account info
                            fileWriter.write(newAccountNumber + "," + accountHolderName + "," + accountType + "," + initialDeposit);
                            fileWriter.close();
                        }
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
            }


    public void newTransaction(String accountHolderName, String action) {


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
