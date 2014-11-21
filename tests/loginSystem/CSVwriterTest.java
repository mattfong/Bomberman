package loginSystem;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CSVwriterTest {

	CSVwriter writer;
	Account acc;
	AccountManager accManager;
	
	@Before
	public void setUp() throws Exception {
		writer = new CSVwriter();
		acc = new Account();
		accManager = new AccountManager();
	}

	@Test
	public void test() throws IOException {
		writer.CSVwriter("Demo1 Game1", "Demo11", "Demo111@");
		assertTrue("Username matches: ", acc.getUserName().equals(accManager.getAccounts()));
	}

}