package savingSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SavedGameSerialization {
	
	public void serializeSaveGameName(List<SavedGame> savedGames, String fileName) {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName, true))) {
			out.writeObject(savedGames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem during serialization");
		}
	}
	
	public List<SavedGame> deserializeSaveGameName(String fileName) {
		List<SavedGame> savedGames = null;
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
			savedGames = (List<SavedGame>) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Problem when deserializing :" + fileName);
		}	
		return savedGames;
	}
}
