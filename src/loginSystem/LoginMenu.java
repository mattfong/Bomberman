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


public class LoginMenu {
	static JTextField jt= new JTextField(30);
	static JPasswordField pf = new JPasswordField(30);
	private static JFrame controllingFrame;

	
	public static void loginMenu(){
		jt.setText(null);
		pf.setText(null);
		final JFrame frame=new JFrame("Login");
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);

		panel.setLayout(new GridLayout(7,1,5,10));
		
		JLabel enterUser = new JLabel("Enter your username");
		JLabel enterPass = new JLabel("Enter your Password");
		
		JButton login = new JButton("To Login click here");
		JButton newUser = new JButton("To create a username click here");
		JButton deleteUser = new JButton("Delete Account");
		
		newUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			newAccount.newAccount();	
			}
			
		});	
		
		deleteUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			deleteAccount.deleteAccount();	
			}
			
		});	
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					if(CSVreader.checkUser(jt.getText(), pf.getText())==true){
						frame.dispose();
						PlayGame.playMenu();
						System.out.println("Username entered correctly");
					}
					else
						 JOptionPane.showMessageDialog(controllingFrame,
					                "Wrong username or password");
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
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
	
	public static void main(String[] args){
		loginMenu();
	}
}
