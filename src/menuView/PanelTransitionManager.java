package menuView;

/**
 * The panelTransitionManager acts as the main JFrame, and coordinates 
 * the calls between the panels. This is a singleton class, which makes it easier
 * to centralize the transition between panels.
 * @author Kirththiga Murugupillai
 */

import gameplay.engine.GamePanel;
import gameplay.world.Level;
import gameplay.world.World;

import javax.swing.JFrame;

import menuView.panels.DeathPanel;
import menuView.panels.DeleteAccountPanel;
import menuView.panels.HighScorePanel;
import menuView.panels.LevelSelectPanel;
import menuView.panels.LoadGameMenuPanel;
import menuView.panels.LoginMenuPanel;
import menuView.panels.ModifyAccountPanel;
import menuView.panels.NewAccountPanel;
import menuView.panels.NewHighScorePanel;
import menuView.panels.PauseMenuPanel;
import menuView.panels.PlayGamePanel;
import menuView.panels.SaveGameMenuPanel;
import menuView.panels.SaveLoadPanel;
import userProfile.UserProfile;

public class PanelTransitionManager {

	private static PanelTransitionManager singleton = null;
	private JFrame frame;
	private UserProfile user = UserProfile.getInstance();
	private World cachedWorld;
	
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
	
	
	public void displayGamePanel(int level){
		Level lvl = Level.getLevelByNumber(level);
		GamePanel gamePanel= new GamePanel(lvl);

	frame.setContentPane(gamePanel);
		gamePanel.setFocusable(true);
	gamePanel.requestFocusInWindow();
		frame.invalidate();
		frame.validate();
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
		NewHighScorePanel highScoreMenu = new NewHighScorePanel();
		frame.setContentPane(highScoreMenu);
		frame.invalidate();
		frame.validate();
	}

    public void displayPauseMenu(World world) {
	cachedWorld=world;
	PauseMenuPanel pauseMenuView = new PauseMenuPanel();
	frame.setContentPane(pauseMenuView);
	frame.invalidate();
	frame.validate();
    }
    
    public void displayGamePanel(World world) {
	GamePanel gamePanel = new GamePanel(world);
	frame.setContentPane(gamePanel);
	gamePanel.setFocusable(true);
	gamePanel.requestFocusInWindow();
	frame.invalidate();
	frame.validate();
    }

    public void displayResumedGame() {
	GamePanel gamePanel = new GamePanel(cachedWorld);

	frame.setContentPane(gamePanel);
	gamePanel.setFocusable(true);
	gamePanel.requestFocusInWindow();
	frame.invalidate();
	frame.validate();
    }

	
	/**
	 * This methods displays the death panel when Bomberman dies.
	 */
	public void displayDeathMenu() {
		DeathPanel deathMenu = new DeathPanel();
		frame.setContentPane(deathMenu);
		frame.invalidate();
		frame.validate();
	}
	/**
	 * When the panel calls this method, the frame closes.
	 */
	public void closeMenu() {
		System.exit(0);
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
