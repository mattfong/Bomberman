package savingSystem;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class SavedGameSerialization {
	
	private SavedGameManager saveManager = new SavedGameManager();
	
	public void serializeSaveGameName(SavedGame games, String fileName) throws IOException {
		List<SavedGame> allSavedGames = this.deserializeSaveGameName(fileName);
		allSavedGames.add(games);
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
			for(SavedGame game: allSavedGames)
			out.writeObject(game);
			System.out.println("Step 3 In serialize:");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem during serialization");
		}
	}
	
	public List<SavedGame> deserializeSaveGameName(String fileName) throws IOException {
		
		List<SavedGame> allSavedGames = new ArrayList<SavedGame>();
		SavedGame game = null;
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			boolean done = false;
			while (!done){
				try {
					game = (SavedGame) in.readObject();
					allSavedGames.add(game);
				} catch (EOFException e) {
					// TODO Auto-generated catch block
					done = true;
					System.out.println("Deserialized Game List: " + allSavedGames);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("Problem when deserializing :" + fileName);
				}
			}
		} catch (EOFException e) {
			
		}
		
		return allSavedGames;
	}
	
}