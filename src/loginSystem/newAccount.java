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


public class newAccount {
	JTextField NameTF = new JTextField(30);
	JTextField UserTF= new JTextField(30);
	JPasswordField PassPF = new JPasswordField(30);	
	
	
	public void newAccountWindow(final JFrame frame){
		NameTF.setText(null);
		UserTF.setText(null);
		PassPF.setText(null);
		final LoginPanel panel = new LoginPanel();

		panel.setLayout(new GridLayout(7,1,5,10));
		
		JLabel enterName = new JLabel("          Enter your name");
		JLabel enterUser = new JLabel("			Enter your desired username");
		JLabel enterPass = new JLabel("			Enter your desired Password");
		
		JButton makeUser = new JButton("Click here to create your account");
		
		makeUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				String Name =NameTF.getText();
				String User=UserTF.getText();
				String Pass=PassPF.getText();
				
				
				try {
					if(UsernameAndPasswordValid.valid(User, Pass)){
						try {
							CSVwriter.CSVwriter(Name, User, Pass);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Entered user is "+User+" and pass is "+Pass);
						 frame.remove(panel);
				         frame.revalidate();
				         frame.validate();
				         frame.removeAll();
						LoginMenu.main(null, frame);	
					}
				} catch (HeadlessException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//end if
				
			}
			
		});	
		panel.add(enterName);
		panel.add(NameTF);
		panel.add(enterUser);
		panel.add(UserTF);
		panel.add(enterPass);
		panel.add(PassPF);
		panel.add(makeUser);
		frame.add(panel);
		
	}
	public static void main(String[] args, JFrame frame){
		newAccount nonStaticNA = new newAccount();
		nonStaticNA.newAccountWindow(frame);
	}
}
