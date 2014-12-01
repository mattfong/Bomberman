package menuView;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import loginSystem.AccountManager;
import loginSystem.CSVreader;
import loginSystem.CSVwriter;

public class DeleteAccountPanelLogic {

	private static JFrame controllingFrame;
	private PanelTransitionManager manager = PanelTransitionManager
			.getInstance();

	public static void DeleteAccount(String User, String Pass) {
		DeleteAccountPanelLogic DAPL = new DeleteAccountPanelLogic();

		DAPL.Delete(User, Pass);
	}

	public void Delete(String User, String Pass) {

		if (User.equals(null) || Pass.equals(null)) {

			// If there is nothing entered the an error message will pop
			// up for the user

			JOptionPane.showMessageDialog(controllingFrame,
					"Username or Password is empty");
		} else {
			// Deleteaccout panel logic

			String csvAccountsFile = "UserPass.csv";

			AccountManager accountManager = new AccountManager();
			CSVreader reader = new CSVreader();
			CSVwriter writer = new CSVwriter();
			try {
				// The account messanger trys to find an account matching the
				// entered detailes

				accountManager.setAccounts(reader
						.CSVreaderAccounts(csvAccountsFile));
				System.out.println("AM in try:"
						+ accountManager.numberOfAccounts() + ","
						+ accountManager.getAccounts());

				accountManager.deleteAccount(User); // and if one is found it
													// deltes it

				System.out.println("AM:" + accountManager.numberOfAccounts()
						+ "," + accountManager.getAccounts());
				writer.CSVwriterAccountsList(csvAccountsFile,
						accountManager.getAccounts());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// After that is done the frame disposes and the loginMenu is
			// brought up again

			manager.displayLoginMenu();
		}

	}
	/*
	 * 
	 * 
	 * public static void deleteAccountViewLogic(String User, String Pass) {
	 * 
	 * // JFrame controllingFrame; String csvAccountsFile = "UserPass.csv";
	 * 
	 * // this sets up a CSV reader and write to read and write to the CSV files
	 * 
	 * AccountManager accountManager = new AccountManager(); CSVreader reader =
	 * new CSVreader(); CSVwriter writer = new CSVwriter();
	 * 
	 * try { // The account messanger trys to find an account matching the
	 * entered detailes
	 * 
	 * accountManager.setAccounts(reader.CSVreaderAccounts(csvAccountsFile));
	 * System.out.println("AM in try:" + accountManager.numberOfAccounts() + ","
	 * + accountManager.getAccounts());
	 * 
	 * accountManager.deleteAccount(User); // and if one is found it deltes it
	 * 
	 * System.out.println("AM:" + accountManager.numberOfAccounts() + "," +
	 * accountManager.getAccounts());
	 * writer.CSVwriterAccountsList(csvAccountsFile,
	 * accountManager.getAccounts()); } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } // After that is done
	 * the frame disposes and the loginMenu is brought up again
	 * 
	 * LoginMenuView.main(null); } }
	 */
}
