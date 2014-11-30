package menuView;

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

import loginSystem.NewAccountView;

public class LoginMenuView extends JPanel{

	public LoginMenuView() {
		initUI();
	}
	
	private void initUI() {
		setLayout(new GridLayout(8,2,5,10));
		JLabel loginMenuLabel = new JLabel("Login Menu");
		loginMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		
		JTextField userNameField = new JTextField(30);
		JPasswordField passwordField = new JPasswordField(30);
		userNameField.setText(null);
		passwordField.setText(null);
		
		JLabel enterUserName = new JLabel("Enter Username: ");
		JLabel enterPassword = new JLabel("Enter Password:");
		
		JButton loginButton = new JButton("Login ");
		JButton newAccountButton = new JButton("Create new account");
		JButton deleteAccountButton = new JButton("Delete Account");
		JButton supriseButton = new JButton("Click here for a suprise");
		
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//dispose();
			}		
		});
		
		newAccountButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//dispose();
			}		
		});	
		
		deleteAccountButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//dispose();
				MenuDisplay md = new MenuDisplay();
				md.goTo("deleteMenu");
			}		
		});
		
		supriseButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String url="https://www.youtube.com/watch?v=dQw4w9WgXcQ";
		    	Desktop d=Desktop.getDesktop();
		    	/*
		    	 * When pressed it opens the URL for the youtube video in the default browser. 
		    	 * Due to a possibility of failure with browsers it is surrounded with try caches
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
