package gameplay.enums;

import java.util.ArrayList;
import java.util.List;

public enum Level {
    LEVEL1("Balloon", "Balloon", "Balloon", "BombPassPowerup");

    private List<String> monsterList;
    private String powerup;

    Level(String... strg) {
	monsterList = new ArrayList<String>();

	for (String s : strg) {
	    monsterList.add(s);
	}
	// powerup is stored at the end of the list
	powerup = monsterList.get(monsterList.size() - 1);
	monsterList.remove(monsterList.size() - 1);

    }

    public List<String> getMonsterList() {
	return monsterList;
    }

    public String getPowerup() {
	return powerup;
    }

}
