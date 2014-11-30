package userProfile;

import java.io.IOException;

import gameplay.Level;
import gameplay.World;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;
import loginSystem.Account;
import loginSystem.AccountManager;
import loginSystem.CSVreader;
import loginSystem.PlayGameView;

public class LoginMenuViewLogic {
	
	//private 
	
	public static void loginMenuLogic(String username){
		
		AccountManager accountManager = new AccountManager();
		
		CSVreader reader = new CSVreader();
		try {
			accountManager.setAccounts(reader.CSVreaderAccounts());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Account acc = accountManager.getAccount(username); 
		GameStateManager manager = GameStateManager.getInstance();
		
		GameState gameState = new GameState(acc.getUserName(), acc.getName());
		gameState.setWorld(new World(31, 13,Level.L1));
		manager.setCurrentGameState(gameState); /*Matt I don't actuly know what this does*/
		
			
		
		System.out.println("Username entered correctly");

		PlayGameView.main(null); /*The frame disposes and the PlayGameView class is opened*/
	}
	

}