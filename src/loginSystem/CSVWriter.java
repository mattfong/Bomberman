package loginSystem;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {
	
	public static void CSVwriter(String User, String Pass) throws IOException{
		CSVWriter writer = new CSVWriter(new FileWriter("Your file.csv"), ',');
			
		Account newUser = new Account(User, Pass);

		writer.close();
		CSVReader.CSVreader();
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
