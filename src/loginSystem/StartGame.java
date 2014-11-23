package loginSystem;

import loginSystem.LoginMenuView;


public class StartGame {
		
	public static void main(String[] args) {
		LoginMenuView loginM = new LoginMenuView();
		
		PlayGameView PG = new PlayGameView();
		PG.playMenu();
		//loginM.loginMenu();	
		
	}
}
