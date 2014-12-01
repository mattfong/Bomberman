package menuView;

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

import userProfile.UserProfile;

public class LoadGameMenuPanel extends JPanel{
	
	private PanelTransitionManager manager = PanelTransitionManager.getInstance();
	private JList list;
	private UserProfile user = UserProfile.getInstance();
	
	public LoadGameMenuPanel() {
		initUI();
		System.out.println("entered constructor");
	}
	
	private void initUI() {
		setLayout(new GridLayout(8,1,5,10));
		JLabel loadMenuLabel = new JLabel("Load Menu");
		loadMenuLabel.setFont(new Font("Miriam", Font.BOLD, 28));
		
		JLabel loadGameLabel = new JLabel("Load Game");
		
		String[] saveList = new String[user.getSaveManager().numberOfSavedGames()];
		for(int i=0; i<user.getSaveManager().numberOfSavedGames(); i++) {
			saveList[i] = user.getSavedGames().get(i).getSavedGameName();
		}
		list = new JList(saveList);
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		
		JLabel deleteGameLabel = new JLabel("Delete saved game");
		JTextField deleteGame = new JTextField(30);
		
		JButton deleteSavedGameButton = new JButton("Delete Saved Game");
	    JButton goBackButton = new JButton("Go Back");
	    JButton closeMenuButton = new JButton("Close Menu");
	    
		deleteSavedGameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

			}
		});	
		
		goBackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				manager.displaySaveLoad();
			}
		});	
		
		closeMenuButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

			}
		});	
		
		add(loadMenuLabel);
		add(loadGameLabel);
	    add(new JScrollPane(list));
	    add(deleteGameLabel);
	    add(deleteGame);
	    add(deleteSavedGameButton);
	    add(goBackButton);
	    add(closeMenuButton);
	}
	
}
