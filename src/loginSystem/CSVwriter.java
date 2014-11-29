package loginSystem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

public class CSVwriter {
	
	private final String csvAccountsFile = "UserPass.csv";
	private final String csvAccountsFileTemp = "UserPassTemp.csv";
	private final String csvHighScore = "HighScore.csv";
	private List<Account> accounts = new ArrayList<Account>();
	private AccountManager accountManager = new AccountManager();
	
	public CSVwriter() {
		super();
	}

	public void CSVwriterAccounts(String name, String userName, String password) throws IOException{
		
		//Creates a CSV file if it does not exist, and appends data to the file
		CSVWriter writer = new CSVWriter(new FileWriter((csvAccountsFile), true), ',');	
		Account newUser = new Account();
		newUser.setName(name);
		newUser.setUserName(userName);
		newUser.setPassword(password);
		newUser.setTotalScore(0);
		
		accountManager.setAccounts(accounts);
		accounts.add(new Account(newUser.getName(), newUser.getUserName(), newUser.getPassword(), newUser.getTotalScore()));
		writer.writeNext(newUser.toCSVEntry());
		System.out.println(accounts);
		writer.close();
	}
	
	public void CSVwriterAccountsList(List<Account> accounts) throws IOException {
		File CSVfile = new File(csvAccountsFile);
		File tempCSV = new File(csvAccountsFileTemp);
		CSVWriter writer = new CSVWriter(new FileWriter((csvAccountsFileTemp), true), ',');	

		for(int i=0; i<accounts.size(); i++){
			Account acc = accounts.get(i);
			writer.writeNext(acc.toCSVEntry());
		}
		System.out.println("New List:" + accounts);
		deleteCSVFile(csvAccountsFile, csvAccountsFileTemp);
		writer.close();
		tempCSV.renameTo(CSVfile);
		System.out.println(tempCSV.renameTo(CSVfile));
	}
	
	public void deleteCSVFile(String csv, String csv2){
		File CSVfile = new File(csv);
		File tempCSV = new File(csv2);
		
		if(CSVfile.exists()){
			CSVfile.delete();
			System.out.println("CSV:" + CSVfile.delete());
		}
	}
	
}
