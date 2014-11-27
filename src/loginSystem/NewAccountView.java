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
/**
 * @author      Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version     1.5                 (current version number of program)
 * @since       2014-11-27          (the version of the package this class was first added to)
 */
public class NewAccountView {
    private JTextField NameTF = new JTextField(30);
    private JTextField UserTF = new JTextField(30);
    private JPasswordField PassPF = new JPasswordField(30);
    private JPasswordField ConfirmPassPF = new JPasswordField(30);
    private AccountManager accountManager = new AccountManager();
    private static JFrame controllingFrame;
    
    /**
	 * This creates the NewAccount Frame and panel                     (1)
	 * <p>
	 * It will display the newAccount Frame and panel. It has a text field for the name, a text field for the username, 
	 * a password field, and a second password field to cofnirm the user's passsord. 
	 * It also has a label over every text or password field, a button to make an account, and a button to go back to the loginMenu 
	 * <p>
	 * 
	 * <p>
	 * The purpose of this method is for the user to be able to make an account. It will use the UsernameAndPasswordVaild, to determine 
	 * if the entered details match username and password requeirments, the Account, Account manager, CSV writer, and CSV reader to save
	 * the account information. 
	 */
    public void NewAccountView() {
    	final JFrame frame = new JFrame("Make an account");
    	NameTF.setText(null);
    	UserTF.setText(null);
    	PassPF.setText(null);
    	ConfirmPassPF.setText(null);

    	JPanel panel = new JPanel();
	

    	panel.setLayout(new GridLayout(10, 1, 5, 10));

    	CSVreader reader = new CSVreader();
    	try {
    		accountManager.setAccounts(reader.CSVreader());
    	} catch (IOException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    	}

    	JLabel enterName = new JLabel("          Enter your name");
    	JLabel enterUser = new JLabel("			Enter your desired username");
    	JLabel enterPass = new JLabel("			Enter your desired Password");
    	JLabel enterConfirmPass = new JLabel("			Confirm your desired Password");

    	JButton makeUser = new JButton("Click here to create your account");

    	makeUser.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			String Name = NameTF.getText();
    			String User = UserTF.getText();
    			String Pass = PassPF.getText();
    			String confirmPass = ConfirmPassPF.getText();
    			System.out.println("List of accounts: " + accountManager.getAccounts());
    			
    			try {
    				if (accountManager.isUsername(User) == false) {
    					if (UsernameAndPasswordValid.valid(User, Pass) & Pass.equals(confirmPass)) {
    						try {
    							CSVwriter writer = new CSVwriter();
    							writer.CSVwriter(Name, User, Pass);
    						} catch (IOException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    						
    						System.out.println("Entered user is " + User + " and pass is " + Pass);
    						frame.dispose();
    						GameState gameState = new GameState(User, Name);
    						GameStateManager manager = GameStateManager.getInstance();
    						manager.setCurrentGameState(gameState);
    						PlayGameView.main(null);
    					} else {
    						System.out.println("Password and confirm password does not match.");
    						JOptionPane.showMessageDialog(controllingFrame,
    				                "Password and confirm password does not match.");
    					}
    					
    				} else {
    					System.out.println("Username " + User + " is taken!");
    					JOptionPane.showMessageDialog(controllingFrame,
    			                "Username " + User + " is already taken!");
    					NameTF.setText(null);
    					UserTF.setText(null);
    					PassPF.setText(null);
    					ConfirmPassPF.setText(null);
    				}
    			} catch (HeadlessException | IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}// end if
    		}
    	});
    	
    	JButton goBack = new JButton("Go back to login menu");

    	goBack.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			frame.dispose();
    			LoginMenuView.main(null);
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
    	//Note: it is important that these operations always be at the bottem, to ensure that the frame display properly.
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(480, 440);
    	frame.setLocationRelativeTo(null);
    	frame.setResizable(false);
    }
	
	/**
	 * This is the main method for the NewAccountView                   (1)
	 * <p>
	 *It uses SwingUtilites to opend the NewAccount method. This ensures that the Frame and Panel will load properly
	 *This also goes from static to non static, allowing non static varibles to be used in other classes.
	 * <p>
	 */
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {
    			NewAccountView NAV = new NewAccountView();
    			NAV.NewAccountView();
    		}
    	});
    }

}
