package loginSystem;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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

	@Test
	public void CSVreaderAccountsTest() throws IOException {
		accounts = reader.CSVreaderAccounts(csvFileTest3);
		System.out.println(accounts.size() + " " + reader.CSVreaderAccounts(csvFileTest3).size());
		assertEquals("Size of accounts list: ", accounts.size(), reader.CSVreaderAccounts(csvFileTest3).size());
	}

}
