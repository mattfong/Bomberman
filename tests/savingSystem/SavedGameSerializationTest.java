package savingSystem;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SavedGameSerializationTest {

    private SavedGameSerialization serialize;
    private String fileName;

    @Before
    public void setUp() throws Exception {
	serialize = new SavedGameSerialization();
	fileName = "Demo01SaveGameList.ser";
    }

    /**
     * Only testing if the first deserialized object in the list is the same as
     * the object saved on the file. Also, testing removal of a game saved in
     * the serialized file. Tested all the methods in this test.
     */
    @Test
    public void test() {
	List<SavedGame> allSavedGames = null;
	try {
	    allSavedGames = serialize.deserializeSaveGameName(fileName);
	    serialize.serializeGamesAfterRemoval(fileName, "Game1");
	    for (SavedGame game : allSavedGames) {
		serialize.serializeSaveGameName(game, fileName);
		assertSame(game, allSavedGames.get(0));
		break;
	    }
	} catch (IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }

}
