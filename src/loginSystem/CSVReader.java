package loginSystem;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;


public class CSVreader {
	
	private static String csv = "testfile.csv";
	private static String emp = "emptyfile.csv";
	private static ArrayList<Account> accounts;
	
	public static void CSVreader() throws IOException{
		
		CSVReader reader = new CSVReader(new FileReader(emp));
		Account acc = new Account("", "");
		
		accounts = new ArrayList<Account>();
		List<String[]> records = reader.readAll();
		Iterator<String[]> i = records.iterator();
		
		while(i.hasNext()){
			String[] record = i.next();
			record[0] = acc.User;
			record[1]= acc.Pass;
			acc = new Account(record[0], record[1]);
			accounts.add(acc);
		}
		
		reader.close();
	}
	
	public static void removeUser(String User) throws IOException{

	}
	
	public static boolean checkUser(String Username, String Password) throws IOException{
		CSVReader reader = new CSVReader(new FileReader(emp));
		String [] nextLine;
		Account acc;
		
		while((nextLine=reader.readNext()) !=null)
		{
			acc = new Account(nextLine);
			if(Username.equals(acc.User)&&Password.equals(acc.Pass)){
				return true;
			}
		}
		reader.close();
		return false;
	}
	
/*	public static void main(String[] args) throws IOException{
		CSVReader reader = new CSVReader(new FileReader("Your file.csv"));
		String [] nextLine;
		Account acc;
		
		while((nextLine=reader.readNext()) !=null)
		{
			acc = new Account(nextLine);
			
			System.out.println("Name is : "+acc.User+ " with $"+acc.Pass);
		}
	}*/
}
