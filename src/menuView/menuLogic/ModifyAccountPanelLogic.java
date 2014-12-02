package menuView.menuLogic;

import java.io.IOException;

import userProfile.UserProfile;
import loginSystem.Account;
import loginSystem.CSVwriter;
/**
 * This class contains the logic for modifying the parameters name and password.
 * @author Kirththiga Murugupillai
 *
 */
public class ModifyAccountPanelLogic {
	
	private UserProfile user;
	private final String csvAccountsFile = "UserPass.csv";
	
	public ModifyAccountPanelLogic(){
		
		user = UserProfile.getInstance();
	}
	
	/**
	 * The method takes in two parameters and does the necessary changes for the Account. 
	 * @param newName
	 * @param newPassword
	 */
	public void modifyAccountParameters(String newName, String newPassword) {
		String currentUserName = user.getUserName();
		String currentName = user.getAccountManager().getAccount(currentUserName).getName();
		String currentPassword = user.getAccountManager().getAccount(currentUserName).getPassword();
		int currentTotalScore = user.getAccountManager().getAccount(currentUserName).getTotalScore();
		
		user.getAccountManager().deleteAccount(currentUserName);
		
		if(newName.length() != 0 && (newName.equals(currentName) == false)) {
			user.getAccountManager().addAccount(new Account(newName, currentUserName, currentPassword, currentTotalScore));
		} 
		else if (newPassword.length() !=0  && (newPassword.equals(currentPassword) == false)) {
			user.getAccountManager().addAccount(new Account(currentName, currentUserName, newPassword, currentTotalScore));
		} 
		else if(newName.length() != 0 && (newName.equals(currentName) == false) && newPassword.length() !=0  && (newPassword.equals(currentPassword) == false)){
			user.getAccountManager().addAccount(new Account(newName, currentUserName, newPassword, currentTotalScore));
		} 
		else {
			user.getAccountManager().addAccount(new Account(currentName, currentUserName, currentPassword, currentTotalScore));
		}
		
		CSVwriter writer = new CSVwriter();
		
		try {
			writer.CSVwriterAccountsList(csvAccountsFile, user.getAccountManager().getAccounts());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
