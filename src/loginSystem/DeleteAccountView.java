package loginSystem;

import java.awt.GridLayout;
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
/**
 * @author      Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version     1.5                 (current version number of program)
 * @since       2014-11-27          (the version of the package this class was first added to)
 */
public class DeleteAccountView {

	private JTextField UserTF= new JTextField(30);
	private JPasswordField PassPF = new JPasswordField(30);
	private JFrame controllingFrame;


	
	/**
	 * This creates the DeleteAccount Frame and panel                     (1)
	 * <p>
	 * It has a textfield to enter the username, a passwordfield to enter the password, and 
	 * two buttons: one to delete the account and one to go back to the MoginMenuViewer.
	 * <p>
	 * 
	 * <p>
	 * The purpose of this method is for the user to be able to delete an account. It takes the username and password and 
	 * sends them to the accountManager to be delted.
	 * <p>
	 */
	public void DeleteAccountView(){
		final JFrame frame = new JFrame();
		UserTF.setText(null);
		PassPF.setText(null);
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(7,1,5,10));
		
		JLabel loginInfo = new JLabel("Enter the login account you want to delete");
		JLabel enterUser = new JLabel("Username");
		JLabel enterPass = new JLabel("Password");
		JButton deleteUser = new JButton("Click here to delete your account");
		
		deleteUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				String User=UserTF.getText();
				String Pass=PassPF.getText();
				if(User.equals(null)||Pass.equals(null)){
					JOptionPane.showMessageDialog(controllingFrame,
			                "Username or Password is empty");
				}
				AccountManager accountManager = new AccountManager();
				CSVreader reader = new CSVreader();
				CSVwriter writer = new CSVwriter();
				
				try {
					accountManager.setAccounts(reader.CSVreaderAccounts());
					System.out.println("AM in try:" + accountManager.numberOfAccounts() + "," + accountManager.getAccounts());
					accountManager.deleteAccount(User);
					System.out.println("AM:" + accountManager.numberOfAccounts() + "," + accountManager.getAccounts());	
					writer.CSVwriterAccountsList(accountManager.getAccounts());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();
				//LoginMenuView loginMenu = new LoginMenuView();
				//loginMenu.loginMenu();	
				LoginMenuView.main(null);
			}
			
		});	
		

		JButton goBack = new JButton("Go back to login menu");

		goBack.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				//LoginMenuView loginMenu = new LoginMenuView(); 
				//loginMenu.loginMenu();
				LoginMenuView.main(null);
			}
			
		});
		
		
		panel.add(loginInfo);
		panel.add(enterUser);
		panel.add(UserTF);
		panel.add(enterPass);
		panel.add(PassPF);
		panel.add(deleteUser);
		panel.add(goBack);
		frame.add(panel);
		//Note: it is important that these operations always be at the bottem, to ensure that the frame display properly.
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 440);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

	}
	/**
	 * This is the main method for the DeleteAccountView                   (1)
	 * <p>
	 *It uses SwingUtilites to opend the DeleteAccount method. This ensures that the Frame and Panel will load properly
	 *This also goes from static to non static, allowing non static varibles to be used in other classes.
	 * <p>
	 */
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				DeleteAccountView LMV = new DeleteAccountView();
				
				LMV.DeleteAccountView();
			}
		});
	}
	
}
