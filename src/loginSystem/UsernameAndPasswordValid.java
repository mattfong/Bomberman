package loginSystem;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UsernameAndPasswordValid {
	private static JFrame controllingFrame;
	public static boolean valid(String User, String Pass) throws HeadlessException, IOException{
		int passLength=Pass.length();
		int userLength=User.length();
		boolean userValid = User.matches("\\w+");
		boolean passValid = Pass.matches("\\w+");
		boolean ULcase=false, passUC=false, passLC=false;
		boolean areThereNumbers=Pass.matches(".*\\d+.*");
		int i=0;
		AccountManager accountManager = new AccountManager();
		
		if(User.equals("utest")){
			//THIS IS FOR DEBUGGING PURPOSES, 
			userValid=true;
			passValid=true;
			passLength=9;
			userLength=9;
			ULcase=true;
			passUC=true;
			passLC=false;
			return true;
		}
		
		else if(accountManager.isUsername(User)){
			JOptionPane.showMessageDialog(controllingFrame,
	                "Username already exists ");
			return false;
		}
		
		else if(userLength<6){//checks for appropreate size
			JOptionPane.showMessageDialog(controllingFrame,
	                "Username should be longer than 6 charicters, you have only "+userLength);
			return false;
		}
		
		else if(passLength<8){
			JOptionPane.showMessageDialog(controllingFrame,
	                "Password should be longer than 8 charicters, you have only "+passLength);
			return false;
		}
		
		else if(!(userValid)){
			JOptionPane.showMessageDialog(controllingFrame,
	                "Username has non acceptable charicters");
			return false;
		}//Checks for nnon-approreate claricters in user
		
		
		for(i=0;i<passLength-1;i++){
			ULcase=Character.isUpperCase(Pass.charAt(i));
			if(ULcase){
				passUC=true;
			}//end else
		}
		if(!passUC){
			JOptionPane.showMessageDialog(controllingFrame,
	                "Password needs one uppercase letter");
			return false;
		}
		 for(i=0;i<passLength-1;i++){
			ULcase=Character.isLowerCase(Pass.charAt(i));
			if(ULcase){
				passLC=true;
			}//end else
		}
		if(!passLC){
			JOptionPane.showMessageDialog(controllingFrame,
	                "Password needs one lowercase letter");
			return false;
		}
		//gets an upper or lower case
	
		else if(!areThereNumbers){
			JOptionPane.showMessageDialog(controllingFrame,
	                "Password needs one number");
			return false;
		}
		
		else if(passValid){
			JOptionPane.showMessageDialog(controllingFrame,
	                "Password must have one speical charicetr");
			return false;
		}//password needs one speical case
		//password must have one of each the following:upper case, lower case, number speical
		
		else
			return true;
		
	}
}
