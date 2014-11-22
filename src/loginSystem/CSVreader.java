package loginSystem;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import au.com.bytecode.opencsv.CSVReader;


public class CSVreader {
	
	private String csv = "UserPass.csv";
	private AccountManager accountManager = new AccountManager();
	
	public List<Account> CSVreader() throws IOException{
		
		CSVReader reader = new CSVReader(new FileReader(csv));
		
		List<String[]> records = reader.readAll();
		Iterator<String[]> i = records.iterator();
		
		// Reading through the CSV file line by line, and adding to accounts
		while(i.hasNext()){
			String[] record = i.next();
			accountManager.addAccount(new Account(record[0], record[1], record[2]));
		}
		
		reader.close();
		System.out.println(accountManager.getAccounts());
		return accountManager.getAccounts();
	}

}
