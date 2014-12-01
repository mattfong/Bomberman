package userProfile;

import java.io.IOException;

import loginSystem.Account;
import loginSystem.CSVwriter;

public class ModifyAccountViewLogic {
	
	private UserProfile user;
	private final String csvAccountsFile = "UserPass.csv";
	
	public ModifyAccountViewLogic(){
		
		user = UserProfile.getInstance();
	}
	
	public void modifyAccountParameters(String newName, String newPassword) {
		String currentUserName = user.getUserName();
		String currentName = user.getAccountManager().getAccount(currentUserName).getName();
		String currentPassword = user.getAccountManager().getAccount(currentUserName).getPassword();
		int currentTotalScore = user.getAccountManager().getAccount(currentUserName).getTotalScore();
		
		user.getAccountManager().deleteAccount(currentUserName);
		
		if(newName.length() != 0 && (newName.equals(currentName) == false)) {
			user.getAccountManager().addAccount(new Account(newName, currentUserName, currentPassword, currentTotalScore));
		} else if (newPassword.length() !=0  && (newPassword.equals(currentPassword) == false)) {
			user.getAccountManager().addAccount(new Account(currentName, currentUserName, newPassword, currentTotalScore));
		} else {
			user.getAccountManager().addAccount(new Account(newName, currentUserName, newPassword, currentTotalScore));
		}
		
		CSVwriter writer = new CSVwriter();
		
		try {
			writer.CSVwriterAccountsList(csvAccountsFile, user.getAccountManager().getAccounts());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
