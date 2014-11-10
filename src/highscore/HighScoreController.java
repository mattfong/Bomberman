package highscore;

public class HighScoreController {
	
	//Testing new setup
	
	public static void main(String[]args){
	
		//HighScoreView view = new HighScoreView();
		HighScoreView newHighScoreView = displayHighScore();
		
		//System.out.println("anyCommand");
		
		//Will quickly close/hide the frame
		//exitHighScore(newHighScoreView);
	}
	

	

	//Closes or hides the HighScore Display
	public static void exitHighScore(HighScoreView view){ 
		view.f.dispose();
		//view.f.setVisible(false);
	}


	
	//Calls highscore display
	public static HighScoreView displayHighScore(){

		HighScoreView view = new HighScoreView();
		return view;
	}
	
	
	
}
