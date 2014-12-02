package menuView.panels;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import menuView.PanelTransitionManager;
import menuView.menuLogic.LoginMenuPanelLogic;
import userProfile.NewAccountPanelLogic;
import userProfile.UserProfile;

/**
 * @author Philip Hoddinott, inital upload by [kirth was this you?]
 *         <philip.hoddinott@mail.mcgill.ca>
 * @version 1.7 (current version number of program)
 * @since 2014-12-1 (the version of the package this class was first added to)
 */
public class NewAccountPanel extends JPanel {

    private PanelTransitionManager manager = PanelTransitionManager.getInstance();
    private final JTextField nameField = new JTextField(30);
    private final JTextField userNameField = new JTextField(30);
    private final JPasswordField passwordField = new JPasswordField(30);
    private final JPasswordField confirmPasswordField = new JPasswordField(30);

    /**
     * This calls the initUI for the NewAccountPanel
     */
    public NewAccountPanel() {
	initUI();
    }

    /**
     * This is creates the NewAccountPanel. It has two textfields to put a name,
     * a usernamne in, and a password frield to put a password in, and a
     * passwordfield to confirm the password. It also has two buttons. One to
     * create the password, and one to go back to the login menu. Finally it has
     * four lablels to tell the user what to put in each textfield
     */
    private void initUI() {
	setLayout(new GridLayout(6, 1, 5, 10));

	nameField.setText(null);
	passwordField.setText(null);
	confirmPasswordField.setText(null);

	JLabel newAccountLabel = new JLabel("Create New Account");
	newAccountLabel.setFont(new Font("Miriam", Font.BOLD, 18));
	JLabel empty = new JLabel("");

	JLabel enterName = new JLabel("Enter your name");
	JLabel enterUser = new JLabel("Enter your desired username");
	JLabel enterPass = new JLabel("Enter your desired Password");
	JLabel enterConfirmPass = new JLabel("Confirm your desired Password");

	JButton makeUser = new JButton("Click here to create your account");
	makeUser.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		LoginMenuPanelLogic loginLogic = new LoginMenuPanelLogic();
		String password = passwordField.getText();
		String confirmPassowrd = confirmPasswordField.getText();
		boolean check = loginLogic.newAccountLogic(nameField.getText(), userNameField.getText(), passwordField.getText(), confirmPasswordField.getText(), 0);
		if (check == true) {
		    try {
			UserProfile.getInstance().setUserProfile(userNameField.getText());
			manager.displayPlayGameMenu();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		} else {
		    nameField.setText(null);
		    userNameField.setText(null);
		    passwordField.setText(null);
		    confirmPasswordField.setText(null);
		}
	    }
	});

	JButton goBack = new JButton("Go back to login menu");
	goBack.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		manager.displayLoginMenu();
	    }
	});

	add(newAccountLabel);
	add(empty);
	add(enterName);
	add(nameField);
	add(enterUser);
	add(userNameField);
	add(enterPass);
	add(passwordField);
	add(enterConfirmPass);
	add(confirmPasswordField);
	add(makeUser);
	add(goBack);

    }

}
