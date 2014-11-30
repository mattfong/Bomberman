package menuView;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
	public BackgroundPanel() {
		initUI();
	}

	private void initUI() {
		setLayout(new GridLayout(1, 2, 5, 10));
		JLabel loginMenuLabel = new JLabel("Login Menu");
		loginMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		add(loginMenuLabel);

	}
	
	public static void main(String[] args){
		JPanel panel = new BackgroundPanel();
		panel.setVisible(true);
	}
}


