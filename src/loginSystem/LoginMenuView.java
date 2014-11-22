package loginSystem;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginMenuView {
	private JTextField jt= new JTextField(30);
	private JPasswordField pf = new JPasswordField(30);
	private JFrame controllingFrame;
	//final JFrame frame=new JFrame("Login");
	LoginFrame frame =new LoginFrame();

	
	public void loginMenu(){
		jt.setText(null);
		pf.setText(null);
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(992,448);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		panel.setLayout(new GridLayout(7,1,5,10));
		
		JLabel enterUser = new JLabel("If you have an account enter your username enter it here");
		JLabel enterPass = new JLabel("If you have an account enter your Password here");
		
		JButton login = new JButton("To Login click here");
		JButton newUser = new JButton("IF you do not have an account click here to create one");
		JButton deleteUser = new JButton("To delete your Account click here");
		
		newUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			NewAccountView newAccount = new NewAccountView();
			newAccount.NewAccountView();	
			}
			
		});	
		
		deleteUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				DeleteAccountView deleteAccount = new DeleteAccountView();
				deleteAccount.DeleteAccountView();	
			}
			
		});	
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					AccountManager accountManager = new AccountManager();
					if(accountManager.isUser(jt.getText(), pf.getText())==true){
						frame.dispose();
						PlayGameView playGame = new PlayGameView();
						playGame.playMenu();
						System.out.println("Username entered correctly");
					}
					else{
						 JOptionPane.showMessageDialog(controllingFrame,
					                "Wrong username or password");
						 jt.setText(null);
						 pf.setText(null);
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				
			}
		});	
		
		
		panel.add(enterUser);
		panel.add(jt);
		panel.add(enterPass);
		panel.add(pf);
		panel.add(login);
		panel.add(newUser);
		panel.add(deleteUser);
		frame.add(panel);
	}
	
}
