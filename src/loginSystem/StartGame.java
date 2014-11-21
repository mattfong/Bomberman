package loginSystem;

import loginSystem.LoginMenu;


public class StartGame {
	LoginFrame frame = new LoginFrame();	
	public static void main(String[] args)
	{
		StartGame start = new StartGame();
		
		//LoginMenu.main(null);	
		
		start.game();
		
	}
	
	
	public void game(){
		//LoginMenu.main(null, frame);
		PlayGame.main(null, frame);
	}
	
}
