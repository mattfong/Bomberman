package userProfile;

import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.io.IOException;

import loginSystem.AccountManager;
import loginSystem.CSVreader;
import loginSystem.CSVwriter;
import loginSystem.PlayGameView;

public class NewAccountViewLogic {

	public static void newAccountLogic(String Name, String User, String Pass, int i){
		String csvAccountsFile = "UserPass.csv";
		AccountManager accountManager = new AccountManager();
		CSVreader reader = new CSVreader();
    	try {
    		accountManager.setAccounts(reader.CSVreaderAccounts());
    	} catch (IOException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}
		
		/* This checks that all paramiters have been met */
		try {
			
			// These write to the Database, making a new account for the user
		
			CSVwriter writer = new CSVwriter();
			writer.CSVwriterAccounts(csvAccountsFile, Name, User, Pass, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Entered user is " + User + " and pass is " + Pass);
		/*
		 * This makes a new gamestate for the new account
		 * It then disposes the frame and goes to the playgameMenu
		 */
		GameState gameState = new GameState(User, Name);
		GameStateManager manager = GameStateManager.getInstance();
		manager.setCurrentGameState(gameState);
		PlayGameView.main(null);
	}
}