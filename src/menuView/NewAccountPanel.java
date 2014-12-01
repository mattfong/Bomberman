package menuView;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewAccountPanel extends JPanel{

	private PanelTransitionManager manager = PanelTransitionManager.getInstance();
	
	public NewAccountPanel() {
		initUI();
	}

	private void initUI() {
		setLayout(new GridLayout(7,1,5,10));
		JTextField UserTF = new JTextField(30);
		JPasswordField PassPF = new JPasswordField(30);
		JPasswordField ConfirmPassPF = new JPasswordField(30);
		UserTF.setText(null);
		PassPF.setText(null);
		ConfirmPassPF = new JPasswordField(30);
		
		JLabel loginInfo = new JLabel(
				"Enter the login account you want to delete");
		JLabel enterUser = new JLabel("Username");
		JLabel enterPass = new JLabel("Password");
		
	}
}
