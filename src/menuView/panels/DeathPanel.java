package menuView.panels;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EtchedBorder;

import menuView.PanelTransitionManager;

/**
 * This class displays the panel after the user has lost all their lives
 * when playing the game.
 * @author Kirththiga Murugupillai
 *
 */
public class DeathPanel extends JPanel{
	
	private PanelTransitionManager manager = PanelTransitionManager.getInstance();
	
	public DeathPanel() {
		initUI();
	}
	
	private void initUI() {
		setLayout(new GridLayout(4, 1, 5, 10));
		JLabel diedLabel = new JLabel("You died!!!");
		JLabel gameOverLabel = new JLabel("Game over!");
		diedLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		gameOverLabel.setFont(new Font("Miriam", Font.BOLD, 28));

		JButton gameOverButton = new JButton("Game Over Go Back to Login Menu");
		gameOverButton.setBackground(java.awt.Color.RED);
		JButton closeMenuButton = new JButton("Close Menu");
		
		gameOverButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.displayLoginMenu();
			}
		});
		
		closeMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.closeMenu();
			}
		});
		
		
		add(diedLabel);
		add(gameOverLabel);
		add(gameOverButton);
		add(closeMenuButton);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	}
}
