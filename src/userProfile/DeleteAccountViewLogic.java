package userProfile;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import loginSystem.AccountManager;
import loginSystem.CSVreader;
import loginSystem.CSVwriter;
import loginSystem.LoginMenuView;
/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version 1.7 (current version number of program)
 * @since 2014-12-1 (the version of the package this class was first added to)
 */
public class DeleteAccountViewLogic {
	private static JFrame controllingFrame;

	public static void deleteAccountViewLogic(String User, String Pass) {

		// JFrame controllingFrame;
		String csvAccountsFile = "UserPass.csv";

		// this sets up a CSV reader and write to read and write to the CSV files
		 
		AccountManager accountManager = new AccountManager();
		CSVreader reader = new CSVreader();
		CSVwriter writer = new CSVwriter();

		try {
			// The account messanger trys to find an account matching the entered detailes
			
			accountManager.setAccounts(reader.CSVreaderAccounts(csvAccountsFile));
			System.out.println("AM in try:" + accountManager.numberOfAccounts()
					+ "," + accountManager.getAccounts());

			accountManager.deleteAccount(User); // and if one is found it deltes it
											
			System.out.println("AM:" + accountManager.numberOfAccounts() + ","
					+ accountManager.getAccounts());
			writer.CSVwriterAccountsList(csvAccountsFile,
					accountManager.getAccounts());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// After that is done the frame disposes and the loginMenu is brought up again
		
		LoginMenuView.main(null);
	}
}
