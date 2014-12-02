package menuView.panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import menuView.DeleteAccountPanelLogic;
import menuView.PanelTransitionManager;

/**
 * @author Philip Hoddinott, inital upload by [kirth was this you?]
 *         <philip.hoddinott@mail.mcgill.ca>
 * @version 1.7 (current version number of program)
 * @since 2014-12-1 (the version of the package this class was first added to)
 */
public class DeleteAccountPanel extends JPanel {

	private PanelTransitionManager manager = PanelTransitionManager
			.getInstance();

	/**
	 * This calls the initUI method
	 */
	public DeleteAccountPanel() {
		initUI();
	}

	/**
	 * This creates the panel for the DeleteAccountMenu
	 */
	private void initUI() {
		setLayout(new GridLayout(7, 1, 5, 10));
		final JTextField UserTF = new JTextField(30);
		final JPasswordField PassPF = new JPasswordField(30);
		UserTF.setText(null);
		PassPF.setText(null);

		JLabel loginInfo = new JLabel(
				"Enter the login account you want to delete");
		JLabel enterUser = new JLabel("Username");
		JLabel enterPass = new JLabel("Password");

		JButton deleteUser = new JButton("Click here to delete your account");
		deleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DeleteAccountPanelLogic.DeleteAccount(UserTF.getText(),
						PassPF.getText());
				/*
				 * String User = UserTF.getText(); String Pass =
				 * PassPF.getText();
				 * 
				 * if (User.equals(null) || Pass.equals(null)) {
				 * 
				 * // If there is nothing entered the an error message will pop
				 * // up for the user
				 * 
				 * JOptionPane.showMessageDialog(controllingFrame,
				 * "Username or Password is empty"); } else { //Deleteaccout
				 * panel logic }
				 */
			}
		});

		JButton goBack = new JButton("Go back to login menu");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.displayLoginMenu();
			}
		});

		add(loginInfo);
		add(enterUser);
		add(UserTF);
		add(enterPass);
		add(PassPF);
		add(deleteUser);
		add(goBack);

	}
}
