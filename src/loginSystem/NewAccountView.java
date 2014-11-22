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


public class NewAccountView {
	private JTextField NameTF = new JTextField(30);
	private JTextField UserTF= new JTextField(30);
	private JPasswordField PassPF = new JPasswordField(30);
	private JPasswordField ConfirmPassPF = new JPasswordField(30);
	private final JFrame frame=new JFrame("Make an account");
	
	public void NewAccountView(){
		NameTF.setText(null);
		UserTF.setText(null);
		PassPF.setText(null);
		ConfirmPassPF.setText(null);
		
		JPanel panel = new JPanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(992,448);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		panel.setLayout(new GridLayout(10,1,5,10));
		
		JLabel enterName = new JLabel("          Enter your name");
		JLabel enterUser = new JLabel("			Enter your desired username");
		JLabel enterPass = new JLabel("			Enter your desired Password");
		JLabel enterConfirmPass = new JLabel("			Confirm your desired Password");
		
		JButton makeUser = new JButton("Click here to create your account");
		
		makeUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				String Name = NameTF.getText();
				String User = UserTF.getText();
				String Pass = PassPF.getText();
				String confirmPass = ConfirmPassPF.getText();
				
				try {
					if(UsernameAndPasswordValid.valid(User, Pass) & Pass.equals(confirmPass)){
						try {
							CSVwriter writer = new CSVwriter();
							writer.CSVwriter(Name, User, Pass);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Entered user is "+User+" and pass is "+Pass);
						frame.dispose();
						PlayGame playGame = new PlayGame();
						playGame.playMenu();
					} else {
						System.out.println("Password and confirm password does not match.");
					}
				} catch (HeadlessException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//end if
				
			}
			
		});	
		
		JButton goBack = new JButton("Go back to login menu");

		goBack.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				LoginMenu loginMenu = new LoginMenu(); 
				loginMenu.loginMenu();
			}
			
		});
		
		
		panel.add(enterName);
		panel.add(NameTF);
		panel.add(enterUser);
		panel.add(UserTF);
		panel.add(enterPass);
		panel.add(PassPF);
		panel.add(enterConfirmPass);
		panel.add(ConfirmPassPF);
		panel.add(makeUser);
		panel.add(goBack);
		frame.add(panel);
		
	}

}
