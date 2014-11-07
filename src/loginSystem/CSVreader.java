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
	
	private static String csv = "UserPass.csv";
	private static ArrayList<Account> accounts;
	
	public static void CSVreader() throws IOException{
		
		CSVReader reader = new CSVReader(new FileReader(csv));
		Account acc = new Account("", "");
		
		accounts = new ArrayList<Account>();
		List<String[]> records = reader.readAll();
		Iterator<String[]> i = records.iterator();
		
		// Reading through the CSV file line by line, and adding to accounts
		while(i.hasNext()){
			String[] record = i.next();
			record[0] = acc.User;
			record[1]= acc.Pass;
			acc = new Account(record[0], record[1]);
			accounts.add(acc);
		}
		
		reader.close();
	}
	
	public static void deleteAccount(String userName) throws IOException{
		
		// Reading the Original CSV file
		File file = new File(csv);
		//Creating a temporary CSV file when deleting the users
		// In the quotations put your path to the folder
		String path = "";
		File tmp = File.createTempFile("tmp", ".csv", new File(path));
		
		Scanner sc = new Scanner(file);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
		System.out.println("File path: "+tmp.getAbsolutePath());
		
		String[] record;
		
		// Reading through the CSV file line by line
		while(sc.hasNext()){
			String data = sc.next();
			record = data.split(",");
			String name = "\"" + userName + "\""; 

			// Writing all the users and passwords except the one we are deleting to a temporary file
			if(!(record[0].equals(name))){
				String userPass = record[0] + "," + record[1];
				bw.write(userPass);
				bw.write("\n");
			}	
		}
		
		sc.close();
		bw.close();
		
		// Deleting the original CSV file and overwriting with the temporary file
		if(file.delete()){
			tmp.renameTo(file);
		}
	}
	
	public static boolean checkUser(String Username, String Password) throws IOException{
		CSVReader reader = new CSVReader(new FileReader(csv));
		String [] nextLine;
		Account acc;
		
		// Reading through the CSV file line by line
		while((nextLine=reader.readNext()) !=null){
			acc = new Account(nextLine);
			
			// Checking if the user already exists in the database
			if(Username.equals(acc.User)&&Password.equals(acc.Pass)){
				return true;
			}
		}
		
		reader.close();
		
		return false;
	}

}