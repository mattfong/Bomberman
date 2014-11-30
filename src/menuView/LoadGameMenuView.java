package menuView;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import userProfile.UserProfile;

public class LoadGameMenuView extends JPanel{
	
	private JList list;
	private UserProfile user = UserProfile.getInstance();
	
	public LoadGameMenuView() {
//		super("Bomberman");
		initUI();
	}
	
	private void initUI() {
		setLayout(new GridLayout(9,1,5,10));
		JLabel loadMenuLabel = new JLabel("Load Menu");
		loadMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		
		JLabel loadGameLabel = new JLabel("Load Game");
		user.getSaveManager().getSavedGamesList();
		String[] saveList = new String[user.getSaveManager().numberOfSavedGames()];
		list = new JList(saveList);
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		
		JLabel deleteGameLabel = new JLabel("Delete saved game");
		JTextField deleteGame = new JTextField(30);
		
		JButton deleteSavedGameButton = new JButton("Delete Saved Game");
	    JButton goBackButton = new JButton("Go Back");
	    JButton closeMenuButton = new JButton("Close Menu");
	    
		
		add(loadMenuLabel);
	    add(new JScrollPane(list));
	    add(deleteGameLabel);
	    add(deleteGame);
	    add(deleteSavedGameButton);
	    add(goBackButton);
	    add(closeMenuButton);
	}
	
}
