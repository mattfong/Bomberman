package loginSystem;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;


public class CSVreader {
	
	private final String csvAccountsFile = "UserPass.csv";
	private final String csvHighScore = "HighScore.csv";
	private AccountManager accountManager = new AccountManager();
	
	public CSVreader() {
		super();
	}

	public List<Account> CSVreaderAccounts() throws IOException{
		
		CSVReader reader = new CSVReader(new FileReader(csvAccountsFile));
		
		List<String[]> records = reader.readAll();
		Iterator<String[]> i = records.iterator();
		
		// Reading through the CSV file line by line, and adding to accounts
		while(i.hasNext()){
			String[] record = i.next();
			accountManager.addAccount(new Account(record[0], record[1], record[2], Integer.parseInt(record[3])));
		}
		
		reader.close();
		System.out.println(accountManager.getAccounts());
		return accountManager.getAccounts();
	}
	
}
