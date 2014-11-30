package loginSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * This class performs operations on a list of Accounts.
 * @author Kirththiga Murugupillai
 *
 */
public class AccountManager {

	private List<Account> accounts = new ArrayList<Account>();
	
	public AccountManager() {
		super();
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * Adding an account into a list of Accounts.
	 * @param newAccount
	 */
	public void addAccount(Account newAccount){
		accounts.add(newAccount);
	}
	
	/**
	 * Determines the number of accounts on the list.
	 * @return size of list
	 */
	public int numberOfAccounts(){
		return accounts.size();
	}
	
	
	/**
	 * Deletes an account from a list, when a username is provided. 
	 * @param userName
	 */
	public void deleteAccount(String userName) {
		
		for(int i=0; i<numberOfAccounts(); i++){
			Account acc =accounts.get(i);
			if(userName.equals(acc.getUserName())){
				accounts.remove(i);
			}
		}
	}
	
	/**
	 * Obtaining a single account from a list of accounts.
	 * @param userName
	 * @return the current user's account
	 */
	public Account getAccount(String userName){
		Account acc = null;
		for(int i=0; i<numberOfAccounts(); i++){
			acc = accounts.get(i);
			if(userName.equals(acc.getUserName())){
				System.out.println("Account was found");
				return acc;
			}
		}
		return acc;
	}
	
	/**
	 * Checks if the username exists within the list of accounts.
	 * @param userName
	 * @return true if the username exists within the list, otherwise false
	 */
	public boolean isUsername(String userName) {
		
		for(int i=0; i<numberOfAccounts(); i++){
			Account acc = accounts.get(i);
			if(userName.equals(acc.getUserName())){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isUser(String userName, String password) {
		
		for(int i=0; i<numberOfAccounts(); i++){
			Account acc =accounts.get(i);
			if(userName.equals(acc.getUserName()) && password.equals(acc.getPassword())){
				return true;
			}
		}
		
		return false;
	}
	
}
