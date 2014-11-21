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

public class DeleteAccountView {

	private JTextField UserTF= new JTextField(30);
	private JPasswordField PassPF = new JPasswordField(30);
	final JFrame frame=new JFrame("Delete your account");
	
	public void DeleteAccountView(){
		UserTF.setText(null);
		PassPF.setText(null);
		
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(992,448);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		panel.setLayout(new GridLayout(6,1,5,10));
		
		JLabel loginInfo = new JLabel("Enter the login account you want to delete");
		JLabel enterUser = new JLabel("Username");
		JLabel enterPass = new JLabel("Password");
		JButton deleteUser = new JButton("Click here to delete your account");
		
		deleteUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				String User=UserTF.getText();
				String Pass=PassPF.getText();
				AccountManager accountManager = new AccountManager();
				CSVreader reader = new CSVreader();
				CSVwriter writer = new CSVwriter();
				
				try {
					accountManager.setAccounts(reader.CSVreader());
					System.out.println("AM in try:" + accountManager.numberOfAccounts() + "," + accountManager.getAccounts());
					accountManager.deleteAccount(User);
					System.out.println("AM:" + accountManager.numberOfAccounts() + "," + accountManager.getAccounts());	
					writer.CSVwriterList(accountManager.getAccounts());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
				LoginMenu loginMenu = new LoginMenu();
				loginMenu.loginMenu();	
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
	
}