package loginSystem;
import java.io.BufferedReader;
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
	
	public static void deleteAccount(String userName, String password) throws IOException{
		
		// Reading the Original CSV file
		File file = new File(csv);
	
		//Creating a temporary CSV file when deleting the users
		File tmp = File.createTempFile("tmp", ".csv");
		Scanner sc = new Scanner(file);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
		
		String[] record;
		
		// Reading through the CSV file line by line
		while(sc.hasNext()){
			String data = sc.next();
			record = data.split(",");
			String name = "\"" + userName + "\"";
			String pwd = "\"" + password + "\"";
			String u = "\"" + record[0] + "\"";
			String p = "\"" + record[1] + "\"";
			
			// Writing all the users and passwords except the one we are deleting to a temporary file
			if(u.equals(name) && p.equals(pwd)){
				System.out.println("Deleting account, username: " + userName + ", password: " + password);
			} else {
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
	
	public static boolean checkUser(String username, String password) throws IOException{
		String csvFileToRead = "Test.csv";  
		  BufferedReader br = null;  
		  String line = "";  
		  String splitBy = ",";  
		  username="\""+username+"\"";
		  password="\""+password+"\"";
		  try {  
			  
			   br = new BufferedReader(new FileReader(csvFileToRead));  
			   while ((line = br.readLine()) != null) {  
			  
				   String[] cars = line.split(splitBy);  
				   if(username.equals(cars[1])&&password.equals(cars[2]))
					   return true;
			   }  
			  
		  } catch (FileNotFoundException e) {  
			   e.printStackTrace();  
		  } catch (IOException e) {  
			  e.printStackTrace();  
		  } finally {  
			   if (br != null) {  
				   try {  
					   br.close();  
				   } catch (IOException e) {  
					   e.printStackTrace();  
				   }  
			   }  
		  }  
			  
		  
		return false;
	}
	
	public static boolean checkUsernameOnly(String user) throws IOException{
		
		
		String csvFileToRead = "Test.csv";  
		  BufferedReader br = null;  
		  String line = "";  
		  String splitBy = ",";  
		  user="\""+user+"\"";
		  try {  
			  
			   br = new BufferedReader(new FileReader(csvFileToRead));  
			   while ((line = br.readLine()) != null) {  
			  
				   String[] account = line.split(splitBy);  
				   if(user.equals(account[1]))
					   return true;
			   }  
			  
		  } catch (FileNotFoundException e) {  
			   e.printStackTrace();  
		  } catch (IOException e) {  
			  e.printStackTrace();  
		  } finally {  
			   if (br != null) {  
				   try {  
					   br.close();  
				   } catch (IOException e) {  
					   e.printStackTrace();  
				   }  
			   }  
		  }  
		return false;
		
		/*
		CSVReader reader = new CSVReader(new FileReader(csv));
		String [] nextLine;
		Account acc;
		
		// Reading through the CSV file line by line
		while((nextLine=reader.readNext()) !=null){
			acc = new Account(nextLine);
			
			// Checking if the user already exists in the database
			if(Username.equals(acc.User)){
				return true;
			}
		}
		
		reader.close();
		
		return false;
		*/
	}
	
}
