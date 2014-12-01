package menuView;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DeleteAccountPanel extends JPanel {

	public DeleteAccountPanel (){
		initUI();
	}
	
	private void initUI() {
		setLayout(new GridLayout(7,2,5,10));
		JTextField UserTF = new JTextField(30);
		JPasswordField PassPF = new JPasswordField(30);
		UserTF.setText(null);
		PassPF.setText(null);
		
		JLabel loginInfo = new JLabel(
				"Enter the login account you want to delete");
		JLabel enterUser = new JLabel("Username");
		JLabel enterPass = new JLabel("Password");

		JButton deleteUser = new JButton("Click here to delete your account");
		deleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JButton goBack = new JButton("Go back to login menu");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		
		add(loginInfo);
		add(enterUser);
		add(UserTF);
		add(enterPass);
		add(PassPF);
		add(deleteUser);
		add(goBack);	
			
	}
}
