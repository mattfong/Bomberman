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
		setLayout(new GridLayout(5,2,5,10));
		JLabel loginMenuLabel = new JLabel("Load Menu");
		loginMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		
		JTextField userNameField = new JTextField(30);
		JPasswordField passwordField = new JPasswordField(30);
		
		JLabel enterUserName = new JLabel("Enter Username: ");
		JLabel enterPassword = new JLabel("Enter Password:");
		
		JButton login = new JButton("Login ");
		JButton newAccount = new JButton("Create new account");
		JButton deleteAccount = new JButton("Delete Account");
		JButton suprise=new JButton("Click here for a suprise");
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//dispose();
			}		
		});
		
		newAccount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//dispose();
			}		
		});	
		
		deleteAccount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				//dispose();
			}		
		});
		
		suprise.addActionListener(new ActionListener(){
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
		add(login);
		add(deleteAccount);
		add(newAccount);
		add(suprise);
	}
}
