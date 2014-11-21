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

	JTextField UserTF= new JTextField(30);
	JPasswordField PassPF = new JPasswordField(30);
	
	public void deleteAccountWindow(final JFrame frame){
		UserTF.setText(null);
		PassPF.setText(null);
		
		final LoginPanel panel = new LoginPanel();
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
				try {
					CSVreader.deleteAccount(User, Pass);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 frame.remove(panel);
		         frame.revalidate();
		         frame.validate();
		         frame.removeAll();
				LoginMenu.main(null,frame);	
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
	
	public static void main(String[] args, JFrame frame){
		deleteAccount nonStaticDA = new deleteAccount();
		nonStaticDA.deleteAccountWindow(frame);
	}
}
