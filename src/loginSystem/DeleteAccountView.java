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

import userProfile.DeleteAccountViewLogic;

/**
 * @author Philip Hoddinott <philip.hoddinott@mail.mcgill.ca>
 * @version 1.5 (current version number of program)
 * @since 2014-11-27 (the version of the package this class was first added to)
 */
public class DeleteAccountView {

    /*
     * This is a text field so that names can be entered.
     */
    private JTextField UserTF = new JTextField(30);
    /*
     * This is a password field that passwords are entered into. It is similar
     * to the text feild, only the text is hidden by dots.
     */
    private JPasswordField PassPF = new JPasswordField(30);
    /*
     * This is the controlling frame that pops up to display an error when
     * logining in.
     */
    private JFrame controllingFrame;

    private final String csvAccountsFile = "UserPass.csv";

    /**
     * This creates the DeleteAccount Frame and panel (1)
     * <p>
     * It has a textfield to enter the username, a passwordfield to enter the
     * password, and two buttons: one to delete the account and one to go back
     * to the MoginMenuViewer.
     * <p>
     * 
     * <p>
     * The purpose of this method is for the user to be able to delete an
     * account. It takes the username and password and sends them to the
     * accountManager to be delted.
     * <p>
     */
    public void DeleteAccountView() {

	/*
	 * This clears anything in the textfield and password field, to stop the
	 * wrong information being entered.
	 */
	UserTF.setText(null);
	PassPF.setText(null);
	/*
	 * This creates a JFrame and JPanel for the Login menu. It sets the
	 * panel to be a grid layout of 8 spots
	 */
	final JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(7, 1, 5, 10));

	/*
	 * These labels are to tell the user what to put in the input fields.
	 */
	JLabel loginInfo = new JLabel("Enter the login account you want to delete");
	JLabel enterUser = new JLabel("Username");
	JLabel enterPass = new JLabel("Password");
	/*
	 * This button takes the entered cridentials and the correspodning
	 * account.
	 */
	JButton deleteUser = new JButton("Click here to delete your account");
	deleteUser.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		/*
		 * These get the entered username and password
		 */
		String User = UserTF.getText();
		String Pass = PassPF.getText();

		if (User.equals(null) || Pass.equals(null)) {

		    // If there is nothing entered the an error message will pop
		    // up for the user

		    JOptionPane.showMessageDialog(controllingFrame, "Username or Password is empty");
		} else {
		    frame.dispose();

		    DeleteAccountViewLogic.deleteAccountViewLogic(User, Pass);
		    /*
		     * // this sets up a CSV reader and write to read and write
		     * to the CSV files
		     * 
		     * AccountManager accountManager = new AccountManager();
		     * CSVreader reader = new CSVreader(); CSVwriter writer =
		     * new CSVwriter();
		     * 
		     * try { // The account messanger trys to find an account
		     * matching the entered detailes
		     * 
		     * accountManager.setAccounts(reader.CSVreaderAccounts());
		     * System.out.println("AM in try:" +
		     * accountManager.numberOfAccounts() + "," +
		     * accountManager.getAccounts());
		     * 
		     * accountManager.deleteAccount(User); // and if one is
		     * found it deltes it
		     * 
		     * System.out.println("AM:" +
		     * accountManager.numberOfAccounts() + "," +
		     * accountManager.getAccounts());
		     * writer.CSVwriterAccountsList(csvAccountsFile,
		     * accountManager.getAccounts()); } catch (IOException e) {
		     * // TODO Auto-generated catch block e.printStackTrace(); }
		     * 
		     * //After that is done the frame disposes and the loginMenu
		     * //is brought up again
		     * 
		     * //LoginMenuView.main(null);
		     */
		}
	    }

	});

	/*
	 * This button wil take the user back to the login menu
	 */
	JButton goBack = new JButton("Go back to login menu");
	goBack.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		/*
		 * The frame disposes and the loginMenu opens
		 */
		frame.dispose();
		LoginMenuView.main(null);
	    }

	});

	/*
	 * These add the input fields, the labels and the buttons to the panel.
	 * Their order deterimines the order that the objects display on the
	 * panel.
	 */
	panel.add(loginInfo);
	panel.add(enterUser);
	panel.add(UserTF);
	panel.add(enterPass);
	panel.add(PassPF);
	panel.add(deleteUser);
	panel.add(goBack);
	frame.add(panel); /* Finally the panel is added to the frame */
	// Note: it is important that these operations always be at the bottem,
	// to ensure that the frame display properly.
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(480, 440);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);

    }

    /**
     * This is the main method for the DeleteAccountView (1)
     * <p>
     * It uses SwingUtilites to opend the DeleteAccount method. This ensures
     * that the Frame and Panel will load properly This also goes from static to
     * non static, allowing non static varibles to be used in other classes.
     * <p>
     */
    public static void main(String[] args) {
	/*
	 * This is very important. It ensure that the frame and panel will
	 * display properly and avoid the "grey screen" glitch we have
	 * experienced. It makes sure that the frame and panel always load
	 * properly.
	 */
	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		/*
		 * This allows a non static method to be called from a static
		 * method
		 */
		DeleteAccountView LMV = new DeleteAccountView();
		LMV.DeleteAccountView();
	    }
	});
    }

}
