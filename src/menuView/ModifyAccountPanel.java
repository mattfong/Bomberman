package menuView;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * This class displays the modify account panel, where the user can change 
 * his name and password. 
 * @author Kirththiga Murugupillai
 *
 */
public class ModifyAccountPanel extends JPanel{
	private PanelTransitionManager manager = PanelTransitionManager.getInstance();
	private final JTextField nameField = new JTextField(30);
	private final JTextField userNameField = new JTextField(30);
	private final JPasswordField passwordField = new JPasswordField(30);
	
	public ModifyAccountPanel() {
		initUI();
	}

	private void initUI() {
		setLayout(new GridLayout(5, 2, 5, 10));
		JLabel modifyMenuLabel = new JLabel("Modify Account");
		modifyMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		
		nameField.setText(null);
		userNameField.setText(null);
		passwordField.setText(null);
		
		JLabel empty = new JLabel("");
		JLabel enterName = new JLabel("Enter Name");
		JLabel enterUserName = new JLabel("Enter Username: ");
		JLabel enterPassword = new JLabel("Enter Password:");

		JButton modifyButton = new JButton("Modify");
		JButton closeButton = new JButton("Close Menu");

		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		add(modifyMenuLabel);
		add(empty);
		add(empty);
		add(enterName);
		add(nameField);
		add(enterUserName);
		add(userNameField);
		add(enterPassword);
		add(passwordField);
		add(modifyButton);
		add(closeButton);
		
	}

}
