package loginSystem;

import java.io.IOException;

public class Account {
	private String name;
	private String userName;
	private String password;
	
	
	public Account() {
		this.name = "";
		this.userName = "";
		this.password = "";
	}

	public Account(String name, String userName, String password) {
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

	public Account(String[] a){
		this.name=a[0];
		this.userName=a[1];
		this.password=a[2];
		
	}
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", userName=" + userName
				+ ", password=" + password + "]";
	}

	public String[] toCSVEntry(){
		String[] entry = new String[]{name, userName, password};
		return entry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
