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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NewAccountView {
    private JTextField NameTF = new JTextField(30);
    private JTextField UserTF = new JTextField(30);
    private JPasswordField PassPF = new JPasswordField(30);
    private JPasswordField ConfirmPassPF = new JPasswordField(30);
    // private final JFrame frame=new JFrame("Make an account");
    private AccountManager accountManager = new AccountManager();

    public void NewAccountView() {
	final JFrame frame = new JFrame("Make an account");
	NameTF.setText(null);
	UserTF.setText(null);
	PassPF.setText(null);
	ConfirmPassPF.setText(null);

	JPanel panel = new JPanel();
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(480, 440);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);

	panel.setLayout(new GridLayout(10, 1, 5, 10));

	CSVreader reader = new CSVreader();
	try {
	    accountManager.setAccounts(reader.CSVreaderAccounts());
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
				writer.CSVwriterAccounts(Name, User, Pass);
			    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
			    System.out.println("Entered user is " + User + " and pass is " + Pass);
			    frame.dispose();
			    // PlayGameView playGame = new PlayGameView();
			    // playGame.playMenu();

			    GameState gameState = new GameState(User, Name);

			    GameStateManager manager = GameStateManager.getInstance();
			    manager.setCurrentGameState(gameState);
			    PlayGameView.main(null);
			} else {
			    System.out.println("Password and confirm password does not match.");
			}
		    } else {
			System.out.println("Username " + User + " is taken!");
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
		// LoginMenuView loginMenu = new LoginMenuView();
		// loginMenu.loginMenu();
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

    }

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
