package loginSystem;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

public class CSVwriter {
	
	private final String csv = "UserPass.csv";
	private final String csv2 = "UserPassTemp.csv";
	private List<Account> accounts = new ArrayList<Account>();
	private AccountManager accountManager = new AccountManager();
	
	public void CSVwriter(String name, String userName, String password) throws IOException{
		
		//Creates a CSV file if it does not exist, and appends data to the file
		CSVWriter writer = new CSVWriter(new FileWriter((csv), true), ',');	
		Account newUser = new Account();
		newUser.setName(name);
		newUser.setUserName(userName);
		newUser.setPassword(password);
		
		accountManager.setAccounts(accounts);
		accounts.add(new Account(newUser.getName(), newUser.getUserName(), newUser.getPassword()));
		writer.writeNext(newUser.toCSVEntry());
		System.out.println(accounts);
		writer.close();
	}
	
	public void CSVwriterList(List<Account> accounts) throws IOException {
		File CSVfile = new File(csv);
		File tempCSV = new File(csv2);
		CSVWriter writer = new CSVWriter(new FileWriter((csv2), true), ',');	

		for(int i=0; i<accounts.size(); i++){
			Account acc = accounts.get(i);
			writer.writeNext(acc.toCSVEntry());
		}
		System.out.println("New List:" + accounts);
		deleteCSVFile(csv, csv2);
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
