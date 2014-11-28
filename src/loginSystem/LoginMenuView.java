package loginSystem;
import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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

public class LoginMenuView {
	/**
	 * This is a text field so that usernames can be entered.
	 */
	JTextField jt= new JTextField(30);
	
	/**
	 * This is a password field that passwords are entered into. 
	 * It is similar to the text feild, only the text is hidden by dots.
	 */
	JPasswordField pf = new JPasswordField(30);
	/**
	 * This is the controlling frame that pops up to display an error when logining in.
	 */
	private JFrame controllingFrame;
	/**
	 * This is a copy of the account manager. 
	 * It is used to verify the account detailes
	 */
	private final AccountManager accountManager = new AccountManager();
	/**
	 * This makes a copy of the username.
	 * It done so that the playMenuView knows who is logged in.
	 */
	public static String justUsername=null;
	
	/**
	 * This creates the LoginMenu Frame and panel                     (1)
	 * <p>
	 * It will display the loginMenu Frame and panel. It has a text field, password field, and four buttons.
	 * From here a user can login, create an account, delete an account, or see our built in suprise function 
	 * <p>


	 */
	public void loginMenu(){
		/**
		 * This clears anything in the textfield, to stop the wrong information being entered.
		 */
		jt.setText(null);
		/**
		 * This clears anything in the password feild, to stop the wrong information being entered.
		 */
		pf.setText(null);
		/**
		 * This creates a JFrame for the Login menu.
		 */
		final JFrame f = new JFrame("Login menu");
		/**
		 * This creates a JPanel for the Login menu.
		 */
		JPanel panel = new JPanel();
		/**
		 * This Sets.
		 */
		panel.setLayout(new GridLayout(8,1,5,10));
		
		
		CSVreader reader = new CSVreader();
		try {
			accountManager.setAccounts(reader.CSVreaderAccounts());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel enterUser = new JLabel("If you have an account enter your username enter it here");
		JLabel enterPass = new JLabel("If you have an account enter your Password here");
		
		JButton login = new JButton("To Login click here");

		JButton newUser = new JButton("IF you do not have an account click here to create one");
		JButton deleteUser = new JButton("To delete your Account click here");
		JButton suprise=new JButton("Click here for a suprise");
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {				
				try {
					if(accountManager.isUser(jt.getText(), pf.getText())==true){
						justUsername=jt.getText();
						f.dispose();
						Account acc = accountManager.getOneAccount(justUsername); 
						
						GameStateManager manager = GameStateManager.getInstance();
						
						GameState gameState = new GameState(acc.getUserName(), acc.getName());
						manager.setCurrentGameState(gameState);
						PlayGameView.main(null);
						System.out.println("Username entered correctly");
						
					}
					else{
						 JOptionPane.showMessageDialog(controllingFrame,
					                "Wrong username or password");
						 jt.setText(null);
						 pf.setText(null);
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				
			}
		});	
		newUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
			f.dispose();
			NewAccountView.main(null);
			}
			
		});	
		
		deleteUser.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				DeleteAccountView.main(null);	
			}
			
		});	
		
		suprise.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				String url="https://www.youtube.com/watch?v=dQw4w9WgXcQ";
		    	Desktop d=Desktop.getDesktop();
		    	try {
					d.browse(new URI(url));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
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
		panel.add(suprise);
		f.add(panel);
		//Note: it is important that these operations always be at the bottem, to ensure that the frame display properly.
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(480, 440);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
	
	/**
	 * This is the main method for the LoginMenuView                   (1)
	 * <p>
	 *It uses SwingUtilites to opend the loginMenu method. This ensures that the Frame and Panel will load properly
	 *This also goes from static to non static, allowing non static varibles to be used in other classes.
	 * <p>
	 */
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				LoginMenuView LMV = new LoginMenuView();
				
				
				LMV.loginMenu();
			}
		});
	}
	
}
