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

/**
 * This class serializes and deserializes all the objects that are needed to be
 * saved.
 * 
 * @author Kirththiga Murugupillai
 *
 */
public class SavedGameSerialization {

    private SavedGameManager manager = new SavedGameManager();

    /**
     * Serializes the game that the user wants to save, and appends the
     * information in the save game file of the user.
     * 
     * @param games
     * @param fileName
     * @throws IOException
     */
    public void serializeSaveGameName(SavedGame games, String fileName) throws IOException {

	List<SavedGame> allSavedGames = this.deserializeSaveGameName(fileName);
	allSavedGames.add(games);

	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
	    for (SavedGame game : allSavedGames)
		out.writeObject(game);
	} catch (IOException e) {
	    e.printStackTrace();
	    System.out.println("Problem during serialization");
	}
    }

    /**
     * Removes the serialized game from the save game file. Serializes the
     * remaining saved games, and overwrites the user's save game file.
     * 
     * @param fileName
     * @param deleteGame
     * @throws IOException
     */
    public void serializeGamesAfterRemoval(String fileName, String deleteGame) throws IOException {

	List<SavedGame> allSavedGames = this.deserializeSaveGameName(fileName);
	manager.setSavedGamesList(allSavedGames);
	manager.removeSavedGame(deleteGame);

	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
	    for (SavedGame game : manager.getSavedGamesList())
		out.writeObject(game);
	} catch (IOException e) {
	    e.printStackTrace();
	    System.out.println("Problem during serialization");
	}
    }

    /**
     * Deserializes the user's save game filename.
     * 
     * @param fileName
     * @return
     * @throws IOException
     */
    public List<SavedGame> deserializeSaveGameName(String fileName) throws IOException {

	List<SavedGame> allSavedGames = new ArrayList<SavedGame>();
	SavedGame game = null;
	boolean done = false;

	try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
	    while (!done) {
		try {
		    game = (SavedGame) in.readObject();
		    allSavedGames.add(game);
		} catch (EOFException e) {
		    done = true;
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		    System.out.println("Problem when deserializing :" + fileName);
		}
	    }
	} catch (EOFException e) {

	}

	return allSavedGames;
    }

}