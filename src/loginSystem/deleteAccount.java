package loginSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class deleteAccount {

	static JTextField UserTF= new JTextField(30);
	
	public static void deleteAccount(){
		final JFrame frame=new JFrame("Delete your account");
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 400);

		panel.setLayout(new GridLayout(5,1,5,10));
		
		JLabel enterUser = new JLabel("Enter the username of the account you want to delete");
		JButton deleteUser = new JButton("Click here to delete your account");
		
		deleteUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				String User=UserTF.getText();
				try {
					CSVreader.deleteAccount(User);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Deleting user "+User);
				frame.dispose();
				LoginMenu.loginMenu();	
			}
			
		});	
		
		panel.add(enterUser);
		panel.add(UserTF);
		panel.add(deleteUser);
		frame.add(panel);
	}
	
	public static void main(String[] args){
		deleteAccount();
	}
}
