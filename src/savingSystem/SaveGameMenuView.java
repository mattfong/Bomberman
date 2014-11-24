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
	private SavedGame savedGame = new SavedGame(); 
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
	    JButton goBack = new JButton("Go Back");
	    JButton closeMenu = new JButton("Close Menu");
		
	    saveGame.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				savedGameName = jt.getText();
				Account acc =new Account();
				try {
					fileName = saveManager.getSaveGameFile("Demo22");
					System.out.println("Step 1: " + fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				savedGame = saveManager.addSavedGame(savedGameName);
				SavedGameSerialization serializeGame = new SavedGameSerialization();
				System.out.println("Step 2: Save Game Name: " + savedGameName + ", username: " + acc.getUserName());
				
				try {
					serializeGame.serializeSaveGameName(savedGame, fileName);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Step 4: Serialization Done");
				
				try {
					List<SavedGame> allSavedGames = serializeGame.deserializeSaveGameName(fileName);

					System.out.println("Step 5: Deserialized List: " + allSavedGames); 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});

	    goBack.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) {
				SaveLoadView saveLoadView = new SaveLoadView();
				saveLoadView.SaveLoadView();
				frame.dispose();	
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
	    panel.add(goBack);
	    panel.add(closeMenu);
	    frame.add(panel);
	
	}
	
	public static void main(String[] args) {
		SaveGameMenuView s = new SaveGameMenuView();
		s.SaveGameMenuView();
	}
	
}