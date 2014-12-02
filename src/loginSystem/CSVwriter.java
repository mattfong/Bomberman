package loginSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

public class CSVwriter {

    // private final String csvAccountsFile = "UserPass.csv";
    private final String csvAccountsFileTemp = "UserPassTemp.csv";
    private List<Account> accounts = new ArrayList<Account>();
    private AccountManager accountManager = new AccountManager();

    public CSVwriter() {
	super();
    }

    /**
     * Writes the new account information in a CSV file, and adds the
     * information into the account manager.
     * 
     * @param fileName
     * @param name
     * @param userName
     * @param password
     * @param totalScore
     * @throws IOException
     */
    public void CSVwriterAccounts(String fileName, String name, String userName, String password, int totalScore) throws IOException {

	// Creates a CSV file if it does not exist, and appends data to the file
	CSVWriter writer = new CSVWriter(new FileWriter((fileName), true), ',');
	Account newUser = new Account();
	newUser.setName(name);
	newUser.setUserName(userName);
	newUser.setPassword(password);
	newUser.setTotalScore(totalScore);

	accounts.add(new Account(newUser.getName(), newUser.getUserName(), newUser.getPassword(), newUser.getTotalScore()));
	accountManager.setAccounts(accounts);
	writer.writeNext(newUser.toCSVEntry());
	writer.close();
    }

    /**
     * Writes the list of accounts in a CSV file, after a user has deleted their
     * account. The new list is stored in a temporary file, then the original
     * file is overwritten.
     * 
     * @param fileName
     * @param accounts
     * @throws IOException
     */
    public void CSVwriterAccountsList(String fileName, List<Account> accounts) throws IOException {
	File CSVfile = new File(fileName);
	File tempCSV = new File(csvAccountsFileTemp);
	CSVWriter writer = new CSVWriter(new FileWriter((csvAccountsFileTemp), true), ',');

	for (int i = 0; i < accounts.size(); i++) {
	    Account acc = accounts.get(i);
	    writer.writeNext(acc.toCSVEntry());
	}

	deleteCSVFile(fileName);
	writer.close();
	tempCSV.renameTo(CSVfile);
    }

    /**
     * Checks if the CSV file exists in order to delete the file.
     * 
     * @param csv
     */
    public void deleteCSVFile(String csv) {
	File CSVfile = new File(csv);

	if (CSVfile.exists()) {
	    CSVfile.delete();
	    System.out.println("CSV:" + CSVfile.delete());
	}
    }

}
