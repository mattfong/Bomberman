package menuView.panels;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import menuView.PanelTransitionManager;
import menuView.menuLogic.LoginMenuPanelLogic;
import savingSystem.SaveLoadController;
import userProfile.UserProfile;

/***
 * This is the load game panel, which displays the list of saved games. Also,
 * the user can delete one of the saved game.
 * 
 * @author Kirththiga
 *
 */
public class LoadGameMenuPanel extends JPanel {

    private PanelTransitionManager manager = PanelTransitionManager.getInstance();
    private JList list;
    private UserProfile user = UserProfile.getInstance();
    private SaveLoadController saveLoadController = new SaveLoadController();
    private final JTextField deleteGame = new JTextField(30);

    public LoadGameMenuPanel() {
	initUI();
    }

    private void initUI() {
	setLayout(new GridLayout(8, 1, 5, 10));

	JLabel loadGameLabel = new JLabel("Load Game");
	JLabel empty = new JLabel("");
	// Storing the list of saved games in an array in order to use JList for
	// display purposes.
	String[] saveList = new String[user.getSaveManager().numberOfSavedGames()];
	for (int i = 0; i < user.getSaveManager().numberOfSavedGames(); i++) {
	    saveList[i] = user.getSavedGames().get(i).getSavedGameName();
	}
	list = new JList(saveList);
	list.setVisibleRowCount(5);
	list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	list.setLayoutOrientation(JList.VERTICAL);

	JLabel deleteGameLabel = new JLabel("Delete saved game");
	deleteGame.setText(null);

	JButton loadGameButton = new JButton("Load Game");
	JButton deleteSavedGameButton = new JButton("Delete Saved Game");
	JButton goBackButton = new JButton("Go Back");
	JButton closeMenuButton = new JButton("Close Menu");

	loadGameButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		// Obtaining the index of the selected element on the list.
		if (e.getActionCommand().equals("Load Game")) {
		    int index = list.getSelectedIndex();
		    saveLoadController.loadGame(index);
		}
	    }
	});

	deleteSavedGameButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		/*
		 * The saveLoadController contains the logic for deleting the
		 * game from the serialized file.
		 */
		saveLoadController.deleteGame(deleteGame.getText());
	    }
	});

	goBackButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		manager.displaySaveLoad();
	    }
	});

	closeMenuButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		manager.displayPlayGameMenu();
	    }
	});

	add(loadGameLabel);
	add(new JScrollPane(list));
	add(loadGameButton);
	add(deleteGameLabel);
	add(deleteGame);
	add(deleteSavedGameButton);
	add(goBackButton);
	add(closeMenuButton);
    }

}
