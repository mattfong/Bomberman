package savingSystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SaveLoadController {
	
	public void displaySaveGameMenu(){
		SaveGameMenuController saveController = new SaveGameMenuController();
		saveController.displaySavedGameMenu();
	}
	
	public void displayLoadGameMenu(){
		LoadGameMenuController loadController = new LoadGameMenuController();
		loadController.displayLoadGameMenu();
	}
	
}
