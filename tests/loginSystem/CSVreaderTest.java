package loginSystem;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the CSVreader class, and checking if the contents are there.
 * @author Kirththiga Murugpillai
 *
 */
public class CSVreaderTest {
	
	private CSVreader reader;
	private List<Account> accounts;
	String csvFileTest3;
	
	@Before
	public void setUp() throws Exception {
		reader = new CSVreader();
		accounts = new ArrayList<Account>();
		csvFileTest3 = "UserPassTest3.csv";
	}
	
	/**
	 * Testing if both objects are the same. The contents in the CSVfile and the list.
	 * @throws IOException
	 */
	@Test
	public void CSVreaderAccountsTest() throws IOException {
		accounts = reader.CSVreaderAccounts(csvFileTest3);
		assertSame(accounts, reader.CSVreaderAccounts(csvFileTest3));
	}

}
