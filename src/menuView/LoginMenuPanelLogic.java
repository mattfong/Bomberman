package menuView;

import gameplay.Level;
import gameplay.World;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import loginSystem.Account;
import loginSystem.AccountManager;
import loginSystem.CSVreader;
import loginSystem.PlayGameView;

public class LoginMenuPanelLogic {
    
    private JFrame controllingFrame;
    
    public LoginMenuPanelLogic(){
	
    }
    
    public Boolean loginCheck(JTextField userNameField, JPasswordField passwordField) {

	userNameField.getText();
	passwordField.getText();
	String userName = userNameField.getName();
	
	AccountManager accountManager = new AccountManager();
	String csvAccountsFile = "UserPass.csv";
	CSVreader reader = new CSVreader();
	
	try {
	    accountManager.setAccounts(reader
		    .CSVreaderAccounts(csvAccountsFile));
	} catch (IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
	
	
	if (accountManager.isUser(userNameField.getText(),
		passwordField.getText())) {

	    Account acc = accountManager.getAccount(userName);
	    GameStateManager manager = GameStateManager.getInstance();

	    GameState gameState = new GameState(acc.getUserName(),
		    acc.getName());
	    gameState.setWorld(new World(31, 13, Level.L1));
	    manager.setCurrentGameState(gameState); 
	    
	    return true;

	}
	
	else{
		/*
		 * If the wrong username/password was entered the input feilds will be cleared and a message will be displayed
		 * to the user informing them of their error 
		 */
		JOptionPane.showMessageDialog(controllingFrame,
	                "Wrong username or password");
		 userNameField.setText(null);
		 passwordField.setText(null);
		 return false;
		 
	}
	

    }

}
