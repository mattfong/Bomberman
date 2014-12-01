package menuView;

import java.io.IOException;

import javax.swing.JFrame;

import userProfile.UserProfile;

/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @author [guys add your selves in here]
 * @version 1.7 (current version number of program)
 * @since 2014-12-1 (the version of the package this class was first added to)
 */
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
	 * This sets the specs for the panel
	 */
	private void initUI() {
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
	 * This displays the LoginMenuPanel of the frame it is the 1st Method
	 * called.
	 */
	public void displayLoginMenu() {
		LoginMenuPanel loginMenu = new LoginMenuPanel();
		frame.setContentPane(loginMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This displays the NewAccount Menu panel
	 */
	public void displayNewAccountMenu() {
		NewAccountPanel accountMenu = new NewAccountPanel();
		frame.setContentPane(accountMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This displays the DeleteAccountMenu panel
	 */
	public void displayDeleteAccountMenu() {
		DeleteAccountPanel deleteMenu = new DeleteAccountPanel();
		frame.setContentPane(deleteMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This displays the modifyAccount panel
	 */
	public void displayModifyAccount() {
		ModifyAccountPanel modifyAccount = new ModifyAccountPanel();
		frame.setContentPane(modifyAccount);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This displays the playgameMenu panel
	 */
	public void displayPlayGameMenu(String userName) {
		PlayGamePanel playMenu = new PlayGamePanel();
		frame.setContentPane(playMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This displays the displayLevel panel
	 */
	public void displayLevels() {
		LevelSelectPanel levelMenu = new LevelSelectPanel();
		frame.setContentPane(levelMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This displays the displaySaveLoad panel
	 */
	public void displaySaveLoad() {
		SaveLoadPanel saveLoadMenu = new SaveLoadPanel();
		frame.setContentPane(saveLoadMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This displays the displaySaveMenu panel
	 */
	public void displaySaveMenu() {
		SaveGameMenuPanel saveMenu = new SaveGameMenuPanel();
		frame.setContentPane(saveMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This displays the displayLoadMenu panel
	 */
	public void displayLoadMenu() {
		LoadGameMenuPanel loadMenu = new LoadGameMenuPanel();
		frame.setContentPane(loadMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This displays the DisplayHighScoreMenu panel
	 */
	public void displayHighscoreMenu() {
		HighScorePanel highScoreMenu = new HighScorePanel();
		frame.setContentPane(highScoreMenu);
		frame.invalidate();
		frame.validate();
	}

	/**
	 * This is the main Menu. It starts the game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PanelTransitionManager manager = PanelTransitionManager.getInstance();
		manager.displayLoginMenu();
	}
}
