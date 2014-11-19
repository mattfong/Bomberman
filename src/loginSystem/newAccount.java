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
	static JTextField NameTF = new JTextField(30);
	static JTextField UserTF= new JTextField(30);
	static JPasswordField PassPF = new JPasswordField(30);	
	
	public static void newAccount(){
		UserTF.setText(null);
		PassPF.setText(null);
		
		final JFrame frame=new JFrame("Make an account");
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(992,448);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

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
						frame.dispose();
						LoginMenu.loginMenu();	
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
	public static void main(String[] args){
		newAccount();
	}
}
