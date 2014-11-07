package loginSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class deleteAccount {

	static JTextField UserTF= new JTextField(30);
	static JPasswordField PassPF = new JPasswordField(30);
	
	public static void deleteAccount(){
		//UserTF.setText(null);
		//PassPF.setText(null);
		
		final JFrame frame=new JFrame("Delete your account");
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);

		panel.setLayout(new GridLayout(6,1,5,10));
		
		JLabel loginInfo = new JLabel("Enter the login account you want to delete");
		JLabel enterUser = new JLabel("Username");
		JLabel enterPass = new JLabel("Password");
		JButton deleteUser = new JButton("Click here to delete your account");
		
		deleteUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				String User=UserTF.getText();
				String Pass=PassPF.getText();
				try {
					CSVreader.deleteAccount(User, Pass);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Deleting user "+User);
				frame.dispose();
				LoginMenu.loginMenu();	
			}
			
		});	
		
		panel.add(loginInfo);
		panel.add(enterUser);
		panel.add(UserTF);
		panel.add(enterPass);
		panel.add(PassPF);
		panel.add(deleteUser);
		frame.add(panel);
	}
	
	public static void main(String[] args){
		deleteAccount();
	}
}
