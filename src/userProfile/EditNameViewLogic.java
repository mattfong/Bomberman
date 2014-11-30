package userProfile;

import loginSystem.Account;
import loginSystem.AccountManager;
import loginSystem.LoginMenuView;

public class EditNameViewLogic {

	public static void editNameLogic(String newName) {
		String username = LoginMenuView.justUsername;
		System.out.println(username);

		AccountManager accountManager = new AccountManager();

		Account acc = accountManager.getAccount(username);
		
		System.out.println(acc.getName());
	}
}
