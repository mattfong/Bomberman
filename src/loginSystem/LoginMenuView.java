package loginSystem;
import gameplay.Level;
import gameplay.World;
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
	/*
	 * This is a text field so that usernames can be entered.
	 */
	JTextField jt= new JTextField(30);
	
	/*
	 * This is a password field that passwords are entered into. 
	 * It is similar to the text feild, only the text is hidden by dots.
	 */
	JPasswordField pf = new JPasswordField(30);
	/*
	 * This is the controlling frame that pops up to display an error when logining in.
	 */
	private JFrame controllingFrame;
	/*
	 * This is a copy of the account manager. 
	 * It is used to verify the account detailes
	 */
	private final AccountManager accountManager = new AccountManager();
	/*
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
		/*
		 * This clears anything in the textfield and password field, to stop the wrong information being entered.
		 */
		jt.setText(null);
		pf.setText(null);
		/*
		 * This creates a JFrame and JPanel for the Login menu. It sets the panel to be a grid layout of 8 spots
		 */
		final JFrame f = new JFrame("Login menu");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(8,1,5,10));
		
		/*
		 * This makes a reader so that the entered usernamne and password can be check against the account database.
		 */
		CSVreader reader = new CSVreader();
		try {
			accountManager.setAccounts(reader.CSVreaderAccounts());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 * These labels are to tell the user what to put in the input fields.
		 */
		JLabel enterUser = new JLabel("If you have an account enter your username enter it here");
		JLabel enterPass = new JLabel("If you have an account enter your Password here");
		
		/*
		 * This button takes the entered cridentials and tries to log the user in.
		 */
		JButton login = new JButton("To Login click here");
		
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {				
				try {
					if(accountManager.isUser(jt.getText(), pf.getText())){
						/*
						 * If the username/password are correct sevral things happen.
						 */
						justUsername=jt.getText(); /*The username is stored so to generate their game state with */
						
						
						
						Account acc = accountManager.getAccount(justUsername); 
						GameStateManager manager = GameStateManager.getInstance();
						
						GameState gameState = new GameState(acc.getUserName(), acc.getName());
						gameState.setWorld(new World(31, 13,Level.L1));
						manager.setCurrentGameState(gameState); /*Matt I don't actuly know what this does*/
						
						f.dispose();						
						PlayGameView.main(null); /*The frame disposes and the PlayGameView class is opened*/	
										
						System.out.println("Username entered correctly");
					}
					else{
						/*
						 * If the wrong username/password was entered the input feilds will be cleared and a message will be displayed
						 * to the user informing them of their error 
						 */
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
		
		/*
		 * This button allows the user to make a new account
		 */	
		JButton newUser = new JButton("IF you do not have an account click here to create one");
		newUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				NewAccountView.main(null); /*The frame is disposed and NewAccountView class opens */
			}		
		});	
		
		/*
		 * This button allows the user to delete their account
		 */
		JButton deleteUser = new JButton("To delete your Account click here");
		deleteUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				f.dispose();
				DeleteAccountView.main(null);	/*The frame is disposed and DeleteAccountView class opens */
			}
		});	
		/*
		 * This button is our unique biult in feature. It rick rolls the user. 
		 */
		JButton suprise=new JButton("Click here for a suprise");
		suprise.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String url="https://www.youtube.com/watch?v=dQw4w9WgXcQ";
		    	Desktop d=Desktop.getDesktop();
		    	/*
		    	 * When pressed it opens the URL for the youtube video in the default browser. 
		    	 * Due to a possibility of failure with browsers it is surrounded with try caches
		    	 */
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
		
		
		/*
		 * These add the input fields, the labels and the buttons to the panel. 
		 * Their order deterimines the order that the objects display on the panel.
		 */
		panel.add(enterUser);
		panel.add(jt);
		panel.add(enterPass);
		panel.add(pf);
		panel.add(login);
		panel.add(newUser);
		panel.add(deleteUser);
		panel.add(suprise);
		f.add(panel); /* finally the frame adds the panel */
		//Note: it is important that these operations always be at the bottem, to ensure that the frame display properly.
		/*
		 * The next part is the frame conditions. They set the frame vizable, to a certin size, etc.
		 */
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