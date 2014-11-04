package loginSystem;
import java.io.FileReader;
import java.io.IOException;


public class CSVReader {
	
	public static void CSVreader() throws IOException{
		CSVReader reader = new CSVReader(new FileReader("Your file.csv"));
		String [] nextLine;
		Account acc;
		
		while((nextLine=reader.readNext()) !=null)
		{
			acc = new Account(nextLine);
			
			System.out.println("Username is : "+acc.User+ " with password "+acc.Pass);
		}
	}
	
	public static boolean checkUser(String Username, String Password) throws IOException{
		CSVReader reader = new CSVReader(new FileReader("Your file.csv"));
		String [] nextLine;
		Account acc;
		
		while((nextLine=reader.readNext()) !=null)
		{
			acc = new Account(nextLine);
			
			System.out.println("Username is : "+acc.User+ " with password "+acc.Pass);
			if(Username.equals(acc.User)&&Password.equals(acc.Pass)){
				return true;
			}
		}
		
		return false;
	}
	/*
	public static void main(String[] args) throws IOException{
		CSVReader reader = new CSVReader(new FileReader("Your file.csv"));
		String [] nextLine;
		Account acc;
		
		while((nextLine=reader.readNext()) !=null)
		{
			acc = new Account(nextLine);
			
			System.out.println("Name is : "+acc.User+ " with $"+acc.Pass);
		}
	}
	*/
}
