package loginSystem;
import java.io.FileWriter;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVWriter;

public class CSVwriter {
	
	public static void CSVwriter(String User, String Pass) throws IOException{
		
		String csv = "UserPass.csv";
		
		//Creates a CSV file if it does not exist, and appends data to the file
		CSVWriter writer = new CSVWriter(new FileWriter((csv), true), ',');	
		Account newUser = new Account(User, Pass);
		writer.writeNext(newUser.toCSVEntry());
		writer.close();
	}
	
}
