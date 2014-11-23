package savingSystem;

import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import loginSystem.Account;

public class SaveGameMenuView {
	private JTextField jt= new JTextField(30);
	private String savedGameName = "";
	private SavedGameManager saveManager = new SavedGameManager();
	private final JFrame frame = new JFrame("Save Game Menu");
	private String fileName = "";

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
				Account acc =new Account();
				try {
<<<<<<< HEAD
					fileName = saveManager.getSaveGameFile("Demo11");
					System.out.println("Step 1: " + fileName);
=======
					fileName = saveManager.getSaveGameFile(acc.getUserName());
>>>>>>> 8d27a82ac1847c88ad782a5e7a0edbfcd1ccb6ad
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				saveManager.addSavedGame(savedGameName);
				SavedGameSerialization serializeGame = new SavedGameSerialization();
				System.out.println("Step 2:" + savedGameName + ", username: " + acc.getUserName());
				
				serializeGame.serializeSaveGameName(saveManager.getSavedGamesList(), fileName);
				System.out.println("Step 4: Serialization Done");
				
				List<SavedGame> newSavedGames = serializeGame.deserializeSaveGameName(fileName);
				System.out.println("Step 5: New List: " + newSavedGames); 
//				saveManager.setSavedGamesList(newSavedGames);
/*				System.out.println("Size: " + saveManager.numberOfSavedGames() + ", " + newSavedGames.size());
				
				for(int i=0; i<saveManager.numberOfSavedGames(); i++) {
				System.out.println("SaveName: " + newSavedGames.get(i).getGameState() + "," +
						newSavedGames.get(i).getUserName() + "," + newSavedGames.get(i).getSavedGameName() );
				System.out.println("New List: " + newSavedGames);
				}*/
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
	
	public static void main(String[] args) {
		SaveGameMenuView s = new SaveGameMenuView();
		s.SaveGameMenuView();
	}
	
}