package loginSystem;

import java.util.ArrayList;
import java.util.List;

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

	public void addAccount(Account newAccount){
		accounts.add(newAccount);
	}
	
	public int numberOfAccounts(){
		return accounts.size();
	}
	
	public void deleteAccount(String userName) {
		
		for(int i=0; i<numberOfAccounts(); i++){
			Account acc =accounts.get(i);
			if(userName.equals(acc.getUserName())){
				accounts.remove(i);
			}
		}
	}
	
	public Account getOneAccount(String userName){
		Account acc = null;
		for(int i=0; i<numberOfAccounts(); i++){
			acc = accounts.get(i);
			if(userName.equals(acc.getUserName())){
				return acc;
			}
		}
		return acc;
	}
	
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
