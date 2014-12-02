package menuView.panels;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import userProfile.UserProfile;
import loginSystem.AccountManager;
import loginSystem.CSVreader;
import menuView.LoginMenuPanelLogic;
import menuView.PanelTransitionManager;

/**
 * This is the login panel, and it has been redesigned. 
 * Phil designed the previous login panel.
 * @author Kirththiga Murugupillai
 */
public class LoginMenuPanel extends JPanel {

	private PanelTransitionManager manager = PanelTransitionManager
			.getInstance();
	private AccountManager accountManager = new AccountManager();
	private LoginMenuPanelLogic loginMenuPanelLogic = new LoginMenuPanelLogic();

	public LoginMenuPanel() {
		initUI();
	}

	private void initUI() {
		setLayout(new GridLayout(5, 2, 5, 10));
		JLabel loginMenuLabel = new JLabel("Login Menu");
		loginMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		JLabel empty = new JLabel("");

		final JTextField userNameField = new JTextField(30);
		final JPasswordField passwordField = new JPasswordField(30);
		userNameField.setText(null);
		passwordField.setText(null);
		// String userName;

		JLabel enterUserName = new JLabel("Enter Username: ");
		JLabel enterPassword = new JLabel("Enter Password:");

		JButton loginButton = new JButton("Login ");
		JButton newAccountButton = new JButton("Create new account");
		JButton deleteAccountButton = new JButton("Delete Account");
		JButton supriseButton = new JButton("Click here for a suprise");

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    Boolean isCorrectID = loginMenuPanelLogic.loginCheck(userNameField, passwordField);
			    if(isCorrectID){
			    	try {
			    		UserProfile.getInstance().setUserProfile(userNameField.getText());
						manager.displayPlayGameMenu();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		newAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.displayNewAccountMenu();
			}
		});

		deleteAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.displayDeleteAccountMenu();
			}
		});

		supriseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
				Desktop d = Desktop.getDesktop();
				/*
				 * When pressed it opens the URL for the youtube video in the
				 * default browser. Due to a possibility of failure with
				 * browsers it is surrounded with try caches
				 */
				try {
					d.browse(new URI(url));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});

		add(loginMenuLabel);
		add(empty);
		add(enterUserName);
		add(userNameField);
		add(enterPassword);
		add(passwordField);
		add(loginButton);
		add(deleteAccountButton);
		add(newAccountButton);
		add(supriseButton);
	}

}
