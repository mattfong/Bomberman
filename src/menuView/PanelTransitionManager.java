package menuView;

/**
 * The panelTransitionManager acts as the main JFrame, and coordinates 
 * the calls between the panels. This is a singleton class, which makes it easier
 * to centralize the transition between panels.
 * @author Kirththiga Murugupillai
 */

import java.io.IOException;
import javax.swing.JFrame;
import userProfile.UserProfile;

public class PanelTransitionManager {

	private static PanelTransitionManager singleton = null;
	private JFrame frame;
	private UserProfile user = UserProfile.getInstance();

	/**
	 * This creates the frame and goes to the initUI
	 */
	private PanelTransitionManager() {
		frame = new JFrame();
		initUI();
	}

	/**
	 * This gets the game instance and returns the singleton
	 * 
	 * @return
	 */
	public static PanelTransitionManager getInstance() {
		if (singleton == null) {
			singleton = new PanelTransitionManager();
		}
		return singleton;
	}
	
	/**
	 * This method sets the general frame attributes for the game.
	 */
	private void initUI(){
		frame.setSize(480, 440);
		frame.setTitle("Bomberman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	/**
	 * This methods displays the login panel and adds it to the main frame.
	 */
	public void displayLoginMenu(){
		LoginMenuPanel loginMenu = new LoginMenuPanel();
		frame.setContentPane(loginMenu);
		frame.invalidate();
		frame.validate();
	}
	
	/**
	 * This methods displays the new account panel and adds it to the main frame.
	 */
	public void displayNewAccountMenu() {
		NewAccountPanel accountMenu = new NewAccountPanel();
		frame.setContentPane(accountMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This methods displays the delete account panel and adds it to the main frame.
	 */
	public void displayDeleteAccountMenu() {
		DeleteAccountPanel deleteMenu = new DeleteAccountPanel();
		frame.setContentPane(deleteMenu);
		frame.invalidate();
		frame.validate();
	}
	
	/**
	 * This methods displays the modify account panel and adds it to the main frame.
	 */
	public void displayModifyAccount() {
		ModifyAccountPanel modifyAccount = new ModifyAccountPanel();
		frame.setContentPane(modifyAccount);
		frame.invalidate();
		frame.validate();
	}
	
	/**
	 * This methods displays the play game panel and adds it to the main frame.
	 */
	public void displayPlayGameMenu() {
		PlayGamePanel playMenu = new PlayGamePanel();
		frame.setContentPane(playMenu);
		frame.invalidate();
		frame.validate();
	}
	
	/**
	 * This methods displays the level panel and adds it to the main frame.
	 * The level panel consists of the levels the user has unlocked.
	 */
	public void displayLevels() {
		LevelSelectPanel levelMenu = new LevelSelectPanel();
		frame.setContentPane(levelMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This methods displays the save load panel and adds it to the main frame.
	 */
	public void displaySaveLoad() {
		SaveLoadPanel saveLoadMenu = new SaveLoadPanel();
		frame.setContentPane(saveLoadMenu);
		frame.invalidate();
		frame.validate();
	}
	
	/**
	 * This methods displays the save panel and adds it to the main frame.
	 */
	public void displaySaveMenu() {
		SaveGameMenuPanel saveMenu = new SaveGameMenuPanel();
		frame.setContentPane(saveMenu);
		frame.invalidate();
		frame.validate();
	}
	
	/**
	 * This methods displays the load panel and adds it to the main frame.
	 */
	public void displayLoadMenu() {
		LoadGameMenuPanel loadMenu = new LoadGameMenuPanel();
		frame.setContentPane(loadMenu);
		frame.invalidate();
		frame.validate();
	}
	
	/**
	 * This methods displays the highscore panel and adds it to the main frame.
	 */
	public void displayHighscoreMenu() {
		HighScorePanel highScoreMenu = new HighScorePanel();
		frame.setContentPane(highScoreMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * The main method which starts the game.
	 * @param args
	 */
	public static void main(String[] args) {
		PanelTransitionManager manager = PanelTransitionManager.getInstance();
		manager.displayLoginMenu();
	}
}
