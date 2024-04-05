//
//
//
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccountManager {
    
    public void newAccount(String accountHolderName, String accountType, String initialDeposit) {



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

    public String transactionHistory() {

        String transactions = "";

        return transactions;
    }
}
