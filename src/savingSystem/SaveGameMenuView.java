package savingSystem;

import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveGameMenuView {
	private JTextField jt= new JTextField(30);
	private String savedGameName = "";
	private List<SavedGame> savedGames = new ArrayList<SavedGame>();
	private SavedGameManager saveManager = new SavedGameManager();
	private final JFrame frame = new JFrame("Save Game Menu");

	public void SaveGameMenuView(){
		JPanel panel = new JPanel();
		frame.setVisible(true);
	    frame.setSize(992,448);
	    frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JLabel gameName = new JLabel("Enter a name to save your game");
	    JButton saveGame = new JButton("Save Game");
	    JButton playNewGame = new JButton("Play new game");
	    JButton closeMenu = new JButton("Close Menu");
		
	    saveGame.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				savedGameName = jt.getText();
				
				String fileName = "SaveGameName.ser";

				saveManager.addSavedGame(getSavedGameName());
				SavedGameSerialization serializeGame = new SavedGameSerialization();
				System.out.println(getSavedGameName());
				
				serializeGame.serializeSaveGameName(saveManager.addSavedGame(getSavedGameName()), fileName);
				System.out.println("Serialization Done");
				
				List<SavedGame> newSavedGames = serializeGame.deserializeSaveGameName(fileName);
				System.out.println("SaveName: " + newSavedGames.get(0).getGameState() + "," +
						newSavedGames.get(0).getUserName() + "," + newSavedGames.get(0).getSavedGameName() );
			}
			
		});
	    
	    playNewGame.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				saveManager.newOperation();	
			}
			
		});	

	    closeMenu.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	
			}
			
		});	

	    panel.setLayout(new GridLayout(5,1,5,10));
	    panel.add(gameName);
	    panel.add(jt);
	    panel.add(saveGame);
	    panel.add(playNewGame);
	    panel.add(closeMenu);
	    frame.add(panel);
	
	}
	
	public String getSavedGameName() {
		return savedGameName;
	}

	public void setSavedGameName(String savedGameName) {
		this.savedGameName = savedGameName;
	}
	
}