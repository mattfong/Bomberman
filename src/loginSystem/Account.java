package loginSystem;

public class Account {
	String User;
	String Pass;
	
	public Account(String[] a){
		User=a[0];
		Pass=a[1];
		
	}
	
	public String[] toCSVEntry(){
		String[] entry = new String[]{User,Pass};
		return entry;
	}
	
	public Account(String Username, String Password){
		User =Username;
		Pass=Password;
	}

}
