package loginSystem;

import java.io.IOException;

public class Account {
	//String playerName;
	String User;
	String Pass;
	
	public Account(String[] a){
		//playerName=a[0];
		User=a[0];
		Pass=a[1];
		
	}
	
	public String[] toCSVEntry(){
		String[] entry = new String[]{/*playerName,*/ User,Pass};
		return entry;
	}
	
	public Account(/*String name, */String Username, String Password){
		//playerName=name;
		User =Username;
		Pass=Password;
	}

}
