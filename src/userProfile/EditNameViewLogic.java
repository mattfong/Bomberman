package userProfile;

import loginSystem.Account;
import loginSystem.AccountManager;
import loginSystem.LoginMenuView;

public class EditNameViewLogic {

    public static void editNameLogic(String newName) {
	UserProfile user = UserProfile.getInstance();
	String username = LoginMenuView.justUsername;
	String currentUsername = user.getAccountManager().getAccount(username).getUserName();

	System.out.println(currentUsername);

	System.out.println(username);

	AccountManager accountManager = new AccountManager();
	// Account acc = accountManager.getAccount(username);
	// Account acc = getAccountManager;

	// System.out.println(acc.getUserName());

	// System.out.println(user.getName());
    }
}
