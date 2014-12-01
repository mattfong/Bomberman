package savingSystem;

import gameplay.statemanagers.GameState;
import gameplay.statemanagers.GameStateManager;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class LoadGameMenuView {

	private List<SavedGame> savedGames = new ArrayList<SavedGame>();
	private final JFrame frame = new JFrame("Load Game Menu");
	private JPanel panel = new JPanel();
	private final JTextField deleteGame = new JTextField(30);
	private SaveLoadController controller = new SaveLoadController();
	private SavedGameSerialization serializeGame = new SavedGameSerialization();
	private SavedGameManager saveManager = new SavedGameManager();
	private GameState currentGame = GameStateManager.getInstance().getCurrentGameState();
	private SavedGame game = null;
	private String saveGameName = "";
	
	public void LoadGameMenuView(){
		frame.setVisible(true);
	    frame.setSize(480, 440);
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    panel.setLayout(new GridLayout(8,1,5,10));
	    
	    JLabel loadGameLabel = new JLabel("Load Game");
	    JLabel deleteGameLabel = new JLabel("Delete saved game");
	    
	    JButton loadGameButton = new JButton("Load Game");
	    JButton deleteSavedGameButton = new JButton("Delete Saved Game");
	    JButton goBackButton = new JButton("Go Back");
	    JButton closeMenuButton = new JButton("Close Menu");
	    
	    try {
	    String fileName = saveManager.getSaveGameFile(currentGame.getUserName());
			savedGames = serializeGame.deserializeSaveGameName(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveManager.setSavedGamesList(savedGames);
		String[] nameList = new String[saveManager.numberOfSavedGames()];
		for(int i=0; i<saveManager.numberOfSavedGames(); i++) {
			nameList[i] = savedGames.get(i).getSavedGameName();
		}
	
	    final JList list = new JList(nameList);
	    list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		
	    loadGameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Load Game")){
					int index = list.getSelectedIndex();
					System.out.println("Index: " + index);
					controller.loadGame(index);
					frame.dispose();
				}
			}
		});

	    deleteSavedGameButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteGame(deleteGame.getText());
				System.out.println("Deleted Saved Game: " + deleteGame.getText());
		//		frame.dispose();	
			}
		});

	    goBackButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				SaveLoadView saveLoadView = new SaveLoadView();
				saveLoadView.SaveLoadView();
				frame.dispose();	
			}
		});

	    closeMenuButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	
			}
		});

	    panel.add(loadGameLabel);
	    panel.add(new JScrollPane(list));
	    panel.add(deleteGameLabel);
	    panel.add(deleteGame);
	    panel.add(loadGameButton);
	    panel.add(deleteSavedGameButton);
	    panel.add(goBackButton);
	    panel.add(closeMenuButton);
	    frame.add(panel);
	    
	}
	
}
