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
import javax.swing.SwingUtilities;


public class LoginMenuView {
	JTextField jt= new JTextField(30);
	JPasswordField pf = new JPasswordField(30);
	private JFrame controllingFrame;
	private final AccountManager accountManager = new AccountManager();
	//LoginFrame frame =new LoginFrame();
	public static String justUsername=null;
	
	
	public void loginMenu(){
		jt.setText(null);
		pf.setText(null);
		final JFrame f = new JFrame("Login menu");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7,1,5,10));
		
		
		
		JLabel enterUser = new JLabel("If you have an account enter your username enter it here");
		JLabel enterPass = new JLabel("If you have an account enter your Password here");
		
		JButton login = new JButton("To Login click here");

		JButton newUser = new JButton("IF you do not have an account click here to create one");
		JButton deleteUser = new JButton("To delete your Account click here");
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {				
				try {
					if(accountManager.isUser(jt.getText(), pf.getText())==true){
						justUsername=jt.getText();
						f.dispose();
						//PlayGameView playGame = new PlayGameView();
						//playGame.playMenu();
						PlayGameView.main(null);
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
		newUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
			f.dispose();
			NewAccountView.main(null);
			}
			
		});	
		
		deleteUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				DeleteAccountView.main(null);	
			}
			
		});	
		
		panel.add(enterUser);
		panel.add(jt);
		panel.add(enterPass);
		panel.add(pf);
		panel.add(login);
		panel.add(newUser);
		panel.add(deleteUser);
		f.add(panel);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(992,448);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
		
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				LoginMenuView LMV = new LoginMenuView();
				
				
				LMV.loginMenu();
			}
		});
	}
	
}