package loginSystem;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the CSVwriter class, and some of the methods in accountManager were
 * also tested during this process. All the setters and getters methods in the
 * Account were tested.
 * 
 * @author Kirththiga Murugupilla
 *
 */
public class CSVwriterTest {

    CSVwriter writer;
    Account acc;
    AccountManager accManager;
    String csvFileTest, csvFileTest2, csvFileTest3;
    File CSVfile;

    @Before
    public void setUp() throws Exception {
	writer = new CSVwriter();
	acc = new Account();
	accManager = new AccountManager();
	csvFileTest = "UserPassTest.csv";
	csvFileTest2 = "UserPassTest2.csv";
	csvFileTest3 = "UserPassTest3.csv";
	CSVfile = new File(csvFileTest);
    }

    /**
     * Testing if 10 accounts can be created, and if the information entered in
     * a CSV file, also matches the information in account manager
     * 
     * @throws IOException
     */
    @Test
    public void CSVwriterAccountsTest() throws IOException {

	for (int i = 0; i < 10; i++) {
	    String name = "Tests" + i + " Trial";
	    String userName = "Tests" + i;
	    String password = "Tests@" + i;
	    int totalScore = 10;

	    accManager.addAccount(new Account(name, userName, password, totalScore));
	    writer.CSVwriterAccounts(csvFileTest, name, userName, password, totalScore);
	    assertEquals("Name matches: ", name, accManager.getAccount(userName).getName());
	    assertEquals("Username matches: ", userName, accManager.getAccount(userName).getUserName());
	    assertEquals("Password matches: ", password, accManager.getAccount(userName).getPassword());
	    assertEquals("Total Score matches: ", totalScore, accManager.getAccount(userName).getTotalScore());
	}
    }

    /**
     * Testing if a list of 10 accounts can be added to accountManager, and be
     * entered in a CSV file.
     * 
     * @throws IOException
     */
    @Test
    public void CSVwriterAccountsListTest() throws IOException {
	for (int i = 0; i < 10; i++) {
	    String name = "Tests" + i + " Trial";
	    String userName = "Tests" + i;
	    String password = "Tests@" + i;
	    int totalScore = 10;

	    accManager.addAccount(new Account(name, userName, password, totalScore));
	}
	writer.CSVwriterAccountsList(csvFileTest2, accManager.getAccounts());
	assertEquals("Accounts List size: ", 10, accManager.numberOfAccounts());
    }

    /**
     * Testing if the file exists after deleting it.
     */
    @Test
    public void deleteCSVFileTest() {
	writer.deleteCSVFile(csvFileTest);
	assertFalse(CSVfile.exists());
    }

}
