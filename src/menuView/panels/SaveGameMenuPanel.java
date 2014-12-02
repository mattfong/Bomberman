package menuView.panels;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import menuView.PanelTransitionManager;
import savingSystem.SaveLoadController;
import savingSystem.SavedGame;
import userProfile.UserProfile;

/**
 * This class displays the save menu panel, where the user can enter the saved game name.
 * @author Kirththiga Murugupillai
 *
 */
public class SaveGameMenuPanel extends JPanel{
	
	private PanelTransitionManager manager = PanelTransitionManager.getInstance();
	private final JTextField saveGameNameField;
	private SaveLoadController saveLoadController = new SaveLoadController();
	private UserProfile user = UserProfile.getInstance();
	/**
	 * This makes a text field and calls the initUI
	 */
	public SaveGameMenuPanel() {
		saveGameNameField= new JTextField(30);
		initUI();
	}
	/**
	 * This method makes the panel
	 */
	private void initUI() {
		setLayout(new GridLayout(5,1,5,10));
		JLabel saveMenuLabel = new JLabel("Save Game Menu");
		saveMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		
		saveGameNameField.setText(null);
		
		JLabel saveGameNameLabel = new JLabel("Enter a name to save your game");
		JButton saveGameButton = new JButton("Save Game");
		JButton goBackButton = new JButton("goBack");
		
		
		saveGameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// The saveLoadController contains the logic for saving the game.
				saveLoadController.saveGame(saveGameNameField.getText());
			}
		});	
		
		goBackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				manager.displaySaveLoad();
			}
		});	
		
		add(saveGameNameLabel);
		add(saveGameNameField);
		add(saveGameButton);
		add(goBackButton);
	}
}
