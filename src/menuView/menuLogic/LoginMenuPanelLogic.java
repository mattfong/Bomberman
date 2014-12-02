package menuView.menuLogic;

import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;
import gameplay.world.Level;
import gameplay.world.World;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import loginSystem.Account;
import loginSystem.AccountManager;
import loginSystem.CSVreader;
import loginSystem.CSVwriter;
import menuView.PanelTransitionManager;

/**
 * @author Philip Hoddinott<philip.hoddinott@mail.mcgill.ca>
 * @version 1.7 (current version number of program)
 * @since 2014-12-1 (the version of the package this class was first added to)
 */
/**
 * @author HP
 *
 */
/**
 * @author HP
 *
 */
public class LoginMenuPanelLogic {

    private JFrame controllingFrame;
    private final String csvAccountsFile = "UserPass.csv";
    private PanelTransitionManager manager = PanelTransitionManager.getInstance();

    public LoginMenuPanelLogic() {

    }

    /**
     * This will check that the username and password match valid accounts/ If
     * they match, it will return true, else it will return false and make a
     * frame pop up to tell the User.
     * 
     * @param userNameField
     * @param passwordField
     * @return
     */
    public Boolean loginCheck(JTextField userNameField, JPasswordField passwordField) {

	String userName = userNameField.getText();

	AccountManager accountManager = new AccountManager();
	String csvAccountsFile = "UserPass.csv";
	CSVreader reader = new CSVreader();

	try {
	    accountManager.setAccounts(reader.CSVreaderAccounts(csvAccountsFile));
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	if (accountManager.isUser(userNameField.getText(), passwordField.getText())) {
	    Account acc = accountManager.getAccount(userName);
	    GameStateManager manager = GameStateManager.getInstance();

	    GameState gameState = new GameState(acc.getUserName(), acc.getName());
	    gameState.setWorld(new World(31, 13, Level.L1));
	    manager.setCurrentGameState(gameState);

	    return true;

	}

	else {
	    /*
	     * If the wrong username/password was entered the input feilds will
	     * be cleared and a message will be displayed to the user informing
	     * them of their error
	     */
	    JOptionPane.showMessageDialog(controllingFrame, "Wrong username or password");
	    userNameField.setText(null);
	    passwordField.setText(null);
	    return false;

	}

    }

    /**
     * This checks if the username and password match the requirements.
     * 
     * This sends the username and password through a string of if/else
     * statements. They check that all the requirements are met. If a
     * requirement is not met it will return false and display a controlling
     * frame with a message about what is wrong.
     * 
     * And even more explanations to follow in consecutive paragraphs separated
     * by HTML paragraph breaks.
     *
     * @param This
     *            is sent the username and password for an account the user
     *            wants to create
     * @return This returns true or false, depending on the username and
     *         password. It will also summon a controlling frame that tells the
     *         user what is wrong
     *
     */
    public boolean valid(String userName, String password) throws HeadlessException, IOException {
	int passLength = password.length();
	int userLength = userName.length();
	boolean userValid = userName.matches("\\w+");
	boolean passValid = password.matches("\\w+");
	boolean upperLowerCase = false, passUpperCase = false, passLowerCase = false;
	boolean areThereNumbers = password.matches(".*\\d+.*");
	int i = 0;
	AccountManager accountManager = new AccountManager();

	if (userName.equals("utest")) {
	    // THIS IS FOR DEBUGGING PURPOSES,
	    userValid = true;
	    passValid = true;
	    passLength = 9;
	    userLength = 9;
	    upperLowerCase = true;
	    passUpperCase = true;
	    passLowerCase = false;
	    return true;
	}

	else if (accountManager.isUsername(userName)) {
	    JOptionPane.showMessageDialog(controllingFrame, "Username already exists ");
	    return false;
	}

	else if (userLength < 6) {// checks for appropriate size
	    JOptionPane.showMessageDialog(controllingFrame, "Username should be longer than 6 charicters, you have only " + userLength);
	    return false;
	}

	else if (passLength < 8) {
	    JOptionPane.showMessageDialog(controllingFrame, "Password should be longer than 8 charicters, you have only " + passLength);
	    return false;
	}

	else if (!(userValid)) {
	    JOptionPane.showMessageDialog(controllingFrame, "Username has non acceptable charicters");
	    return false;
	}// Checks for non-appropriate characters in user

	for (i = 0; i < passLength - 1; i++) {
	    upperLowerCase = Character.isUpperCase(password.charAt(i));
	    if (upperLowerCase) {
		passUpperCase = true;
	    }// end else
	}
	if (!passUpperCase) {
	    JOptionPane.showMessageDialog(controllingFrame, "Password needs one uppercase letter");
	    return false;
	}
	for (i = 0; i < passLength - 1; i++) {
	    upperLowerCase = Character.isLowerCase(password.charAt(i));
	    if (upperLowerCase) {
		passLowerCase = true;
	    }// end else
	}
	if (!passLowerCase) {
	    JOptionPane.showMessageDialog(controllingFrame, "Password needs one lowercase letter");
	    return false;
	}
	// gets an upper or lower case

	else if (!areThereNumbers) {
	    JOptionPane.showMessageDialog(controllingFrame, "Password needs one number");
	    return false;
	}

	else if (passValid) {
	    JOptionPane.showMessageDialog(controllingFrame, "Password must have one speical charicetr");
	    return false;
	}// password needs one speical case
	 // password must have one of each the following:upper case, lower case,
	 // number special

	else {
	    return true;
	}
    }

    /**
     * Added logic for new account and integrated the validation.
     * 
     * @author Kirththiga Murugupillai
     * @param name
     * @param username
     * @param password
     * @param confirmPassword
     * @param score
     * @return
     */
    public boolean newAccountLogic(String name, String username, String password, String confirmPassword, int score) {
	boolean check = false;
	boolean validate = false;

	if (password.equals(confirmPassword)) {

	    AccountManager accountManager = new AccountManager();
	    CSVreader reader = new CSVreader();
	    try {
		accountManager.setAccounts(reader.CSVreaderAccounts(csvAccountsFile));
	    } catch (IOException e1) {
		e1.printStackTrace();
	    }

	    // This checks that all parameters have been met
	    try {
		// These write to the Database, making a new account for the
		// user
		CSVwriter writer = new CSVwriter();
		writer.CSVwriterAccounts(csvAccountsFile, name, username, password, 0);
	    } catch (IOException e) {
		e.printStackTrace();
	    }

	    System.out.println("Entered user is " + username + " and pass is " + password);
	    // This makes a new gamestate for the new account It then disposes
	    // the frame and goes to the playgameMenu

	    GameState gameState = new GameState(username, name);
	    GameStateManager gManager = GameStateManager.getInstance();
	    gManager.setCurrentGameState(gameState);
	    try {
		validate = valid(username, password);
		if (validate == true) {
		    check = password.equals(confirmPassword);
		}
	    } catch (HeadlessException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else {
	    JOptionPane.showMessageDialog(controllingFrame, "Password and confirm Password do not match");
	}
	return check;

    }
}
