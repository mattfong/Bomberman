package loginSystem;

import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

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
import javax.swing.SwingUtilities;

import junk.UsernameAndPasswordValid;
import userProfile.NewAccountViewLogic;
/**
 * @author      Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version     1.5                 (current version number of program)
 * @since       2014-11-27          (the version of the package this class was first added to)
 */
public class NewAccountView {
//	private final String csvAccountsFile = "UserPass.csv";
//	/*
//	 * This is a text field so that names can be entered.
//	 */
//	private JTextField NameTF = new JTextField(30);
//	/*
//	 * This is a text field so that usernames can be entered.
//	 */
//	private JTextField UserTF = new JTextField(30);
//	/*
//	 * This is a password field that passwords are entered into. 
//	 * It is similar to the text feild, only the text is hidden by dots. 
//	 * There are two, so that the password can be confirmed
//	 */
//	private JPasswordField PassPF = new JPasswordField(30);
//    private JPasswordField ConfirmPassPF = new JPasswordField(30);
//    /*
//	 * This is a copy of the account manager. 
//	 * It is used to verify the account detailes
//	 */
//    private AccountManager accountManager = new AccountManager();
//    /*
//	 * This is the controlling frame that pops up to display an error when logining in.
//	 */
//    private static JFrame controllingFrame;
//    
//    /**
//	 * This creates the NewAccount Frame and panel                     (1)
//	 * <p>
//	 * It will display the newAccount Frame and panel. It has a text field for the name, a text field for the username, 
//	 * a password field, and a second password field to cofnirm the user's passsord. 
//	 * It also has a label over every text or password field, a button to make an account, and a button to go back to the loginMenu 
//	 * <p>
//	 * 
//	 * <p>
//	 * The purpose of this method is for the user to be able to make an account. It will use the UsernameAndPasswordVaild, to determine 
//	 * if the entered details match username and password requeirments, the Account, Account manager, CSV writer, and CSV reader to save
//	 * the account information. 
//	 */
//    public void NewAccountView() {
//    	
//    	
//    	
//    	/*
//		 * This clears anything in the textfield and password field, to stop the wrong information being entered.
//		 */
//    	NameTF.setText(null);
//    	UserTF.setText(null);
//    	PassPF.setText(null);
//    	ConfirmPassPF.setText(null);
//    	
//    	/*
//		 * This creates a JFrame and JPanel for the Login menu. It sets the panel to be a grid layout of 8 spots
//		 */
//    	final JFrame frame = new JFrame("Make an account");
//    	JPanel panel = new JPanel();
//	   	panel.setLayout(new GridLayout(10, 1, 5, 10));
//	   	/*
//		 * This makes a reader so that the entered usernamne and password can be check against the account database.
//		 */
//    	CSVreader reader = new CSVreader();
//    	try {
//    		accountManager.setAccounts(reader.CSVreaderAccounts(csvAccountsFile));
//    	} catch (IOException e1) {
//    		// TODO Auto-generated catch block
//    		e1.printStackTrace();
//    	}
//    	
//    	/*
//		 * These labels are to tell the user what to put in the input fields.
//		 */
//    	JLabel enterName = new JLabel("          Enter your name");
//    	JLabel enterUser = new JLabel("			Enter your desired username");
//    	JLabel enterPass = new JLabel("			Enter your desired Password");
//    	JLabel enterConfirmPass = new JLabel("			Confirm your desired Password");
//
//    	/*
//		 * This button takes the entered cridentials and tries to make an account for the user.
//		 */
//    	JButton makeUser = new JButton("Click here to create your account");
//    	makeUser.addActionListener(new ActionListener() {
//    		public void actionPerformed(ActionEvent arg0) {
//    			/*
//    			 * Get inputed values
//    			 */
//    			String Name = NameTF.getText();
//    			String User = UserTF.getText();
//    			String Pass = PassPF.getText();
//    			String confirmPass = ConfirmPassPF.getText();
//    			System.out.println("List of accounts: " + accountManager.getAccounts());
//    			
//    			try {
//    				if (accountManager.isUsername(User) == false) { /* This checks for other accounts     */
//    					if (UsernameAndPasswordValid.valid(User, Pass) & Pass.equals(confirmPass)) { 
//    						
//    						frame.dispose();
//    						NewAccountViewLogic.newAccountLogic(Name, User, Pass, 0);
//    						/*
//    						// This checks that all paramiters have been met 
//    						try {
//    							
//    							// These write to the Database, making a new account for the user
//    						
//    							CSVwriter writer = new CSVwriter();
//    							writer.CSVwriterAccounts(csvAccountsFile, Name, User, Pass, 0);
//    						} catch (IOException e) {
//    							// TODO Auto-generated catch block
//    							e.printStackTrace();
//    						}
//
//    						System.out.println("Entered user is " + User + " and pass is " + Pass);
//    						
//    						 //This makes a new gamestate for the new account
//    						 // It then disposes the frame and goes to the playgameMenu
//    						 
//    						
//    						GameState gameState = new GameState(User, Name);
//    						GameStateManager manager = GameStateManager.getInstance();
//    						manager.setCurrentGameState(gameState);
//    						PlayGameView.main(null);
//    						*/
//    						
//    					} else {
//    						/*
//    						 * If the password and the check password do not match then the user is shown an error message.
//    						 */
//    						System.out.println("Password and confirm password does not match.");
//    						JOptionPane.showMessageDialog(controllingFrame,
//    				                "Password and confirm password does not match.");
//    					}
//    					
//    				} else {
//    					/*
//    					 * If the username is already taken this will dispaly a error message for the user
//    					 */
//    					System.out.println("Username " + User + " is taken!");
//    					JOptionPane.showMessageDialog(controllingFrame,
//    			                "Username " + User + " is already taken!");
//    					NameTF.setText(null);
//    					UserTF.setText(null);
//    					PassPF.setText(null);
//    					ConfirmPassPF.setText(null);
//    				}
//    			} catch (HeadlessException | IOException e) {
//    				// TODO Auto-generated catch block
//    				e.printStackTrace();
//    			}// end if
//    		}
//    	});
//    	/*
//    	 * This button allows the user to go back to go to the loginMenu
//    	 */
//    	JButton goBack = new JButton("Go back to login menu");
//    	goBack.addActionListener(new ActionListener() {
//    		public void actionPerformed(ActionEvent arg0) {
//    			frame.dispose();
//    			LoginMenuView.main(null);
//    		}
//
//    	});
//    	/*
//		 * These add the input fields, the labels and the buttons to the panel. 
//		 * Their order deterimines the order that the objects display on the panel.
//		 */
//    	panel.add(enterName);
//    	panel.add(NameTF);
//    	panel.add(enterUser);
//    	panel.add(UserTF);
//    	panel.add(enterPass);
//    	panel.add(PassPF);
//    	panel.add(enterConfirmPass);
//    	panel.add(ConfirmPassPF);
//    	panel.add(makeUser);
//    	panel.add(goBack);
//    	frame.add(panel);
//    	//Note: it is important that these operations always be at the bottem, to ensure that the frame display properly.
//    	/*
//		 * The next part is the frame conditions. They set the frame visable, to a certin size, etc.
//		 */
//    	frame.setVisible(true);
//    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	frame.setSize(480, 440);
//    	frame.setLocationRelativeTo(null);
//    	frame.setResizable(false);
//    }
//	
//	/**
//	 * This is the main method for the NewAccountView                   (1)
//	 * <p>
//	 *It uses SwingUtilites to open the NewAccount method. This ensures that the Frame and Panel will load properly
//	 *This also goes from static to non static, allowing non static variables to be used in other classes.
//	 * <p>
//	 */
//    public static void main(String[] args) {
//		/*
//		 * This is very important. It ensure that the frame and panel will display properly and avoid 
//		 * the "grey screen" glitch we have experienced. It makes sure that the frame and panel always load properly. 
//		 */
//    	SwingUtilities.invokeLater(new Runnable() {
//    		@Override
//    		public void run() {
//    			/*
//				 * This allows a non static method to be called from a static method
//				 */
//    			NewAccountView NAV = new NewAccountView();
//    			NAV.NewAccountView();
//    		}
//    	});
//    }

}
