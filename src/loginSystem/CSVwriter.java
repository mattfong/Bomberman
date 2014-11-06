package loginSystem;
import java.io.FileWriter;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class CSVwriter {
	
	public static void CSVwriter(String User, String Pass) throws IOException{
		String csv = "testfile.csv";
		String emp = "emptyfile.csv";

		CSVWriter writer = new CSVWriter(new FileWriter((emp), true), ',');	
		Account newUser = new Account(User, Pass);
		writer.writeNext(newUser.toCSVEntry());
		writer.close();
	}
	
	/*
	public static void main(String[] args) throws IOException{
		CSVWriter writer = new CSVWriter(new FileWriter("Your file.csv"), ',');
		
		String name="Philip";
		String money="5";
		
		Account bill = new Account(name, money);

		writer.writeNext(bill.toCSVEntry());
		writer.close();
		CSVreader.main(args);
		
	}
*/
}
