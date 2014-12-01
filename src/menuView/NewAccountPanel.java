package menuView;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import userProfile.NewAccountPanelLogic;
/**
 * @author Philip Hoddinott, inital upload by [kirth was this you?] <philip.hoddinott@mail.mcgill.ca>
 * @version 1.7 (current version number of program)
 * @since 2014-12-1 (the version of the package this class was first added to)
 */
public class NewAccountPanel extends JPanel {

	private PanelTransitionManager manager = PanelTransitionManager
			.getInstance();

	public NewAccountPanel() {
		initUI();
	}
	

	private void initUI() {
		setLayout(new GridLayout(10, 1, 5, 10));

		final JTextField NameTF = new JTextField(30);
		final JTextField UserTF = new JTextField(30);
		final JPasswordField PassPF = new JPasswordField(30);
		JPasswordField ConfirmPassPF = new JPasswordField(30);
		NameTF.setText(null);
		PassPF.setText(null);
		ConfirmPassPF = new JPasswordField(30);

		JLabel loginInfo = new JLabel(
				"Enter the Account details for the account that you want to make");
		JLabel enterName = new JLabel("          Enter your name");
		JLabel enterUser = new JLabel("			Enter your desired username");
		JLabel enterPass = new JLabel("			Enter your desired Password");
		JLabel enterConfirmPass = new JLabel("			Confirm your desired Password");

		JButton makeUser = new JButton("Click here to create your account");
		makeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * String Name = NameTF.getText(); String User =
				 * UserTF.getText(); String Pass = PassPF.getText(); String
				 * confirmPass = ConfirmPassPF.getText();
				 */
				NewAccountPanelLogic.NewAccountLogic(NameTF.getText(), UserTF.getText(), PassPF.getText());
				
			}
		});

		JButton goBack = new JButton("Go back to login menu");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.displayLoginMenu();
			}
		});

		add(enterName);
		add(NameTF);
		add(enterUser);
		add(UserTF);
		add(enterPass);
		add(PassPF);
		add(enterConfirmPass);
		add(ConfirmPassPF);
		add(makeUser);
		add(goBack);

	}

}
