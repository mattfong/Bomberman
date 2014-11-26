package gameplay;

import gameplay.gameobject.enemies.Balloon;
import gameplay.gameobject.enemies.Doll;
import gameplay.gameobject.enemies.Kondoria;
import gameplay.gameobject.enemies.Minvo;
import gameplay.gameobject.enemies.Oneal;
import gameplay.gameobject.enemies.Ovapi;
import gameplay.gameobject.enemies.Pass;

public enum Level {
    L1(Balloon.class,Balloon.class,Balloon.class,Balloon.class,Balloon.class,Balloon.class),
    L2(Balloon.class,Balloon.class,Balloon.class,Oneal.class,Oneal.class,Oneal.class),
    L3(Balloon.class,Balloon.class,Oneal.class,Oneal.class,Doll.class,Doll.class),
    L4(Balloon.class,Oneal.class,Doll.class,Doll.class,Minvo.class,Minvo.class),
    L5(Oneal.class,Oneal.class,Oneal.class,Oneal.class,Doll.class,Doll.class,Doll.class),
    L6(Oneal.class,Oneal.class,Doll.class,Doll.class,Doll.class,Minvo.class,Minvo.class),
    L7(Oneal.class,Oneal.class,Doll.class,Doll.class,Doll.class,Kondoria.class,Kondoria.class),
    L8(Oneal.class,Doll.class,Doll.class,Minvo.class,Minvo.class,Minvo.class,Minvo.class),
    L9(Oneal.class,Doll.class,Minvo.class,Minvo.class,Minvo.class,Minvo.class,Kondoria.class),
    L10(Oneal.class,Doll.class,Minvo.class,Kondoria.class,Kondoria.class,Kondoria.class,Ovapi.class),
    L11(Oneal.class,Doll.class,Doll.class,Minvo.class,Minvo.class,Minvo.class,Kondoria.class,Ovapi.class),
    L12(Doll.class,Doll.class,Doll.class,Minvo.class,Minvo.class,Minvo.class,Kondoria.class,Kondoria.class,Kondoria.class),
    L13(Ovapi.class,Ovapi.class,Ovapi.class,Ovapi.class,Ovapi.class,Ovapi.class,Ovapi.class,Pass.class),
    L14(Doll.class,Minvo.class,Minvo.class,Minvo.class,Kondoria.class,Kondoria.class,Kondoria.class,Pass.class),
    L15(Minvo.class,Minvo.class,Minvo.class,Kondoria.class,Kondoria.class,Kondoria.class,Kondoria.class,Pass.class),
    L16(Doll.class,Doll.class,Doll.class,Doll.class,Doll.class,Kondoria.class,Kondoria.class,Pass.class),
    L17(Balloon.class,Balloon.class,Balloon.class,Oneal.class,Oneal.class,Oneal.class,Pass.class,Pass.class),
    L18(Balloon.class,Oneal.class,Doll.class,Doll.class,Doll.class,Ovapi.class,Pass.class,Pass.class),
    L19(Oneal.class,Doll.class,Minvo.class,Kondoria.class,Kondoria.class,Ovapi.class,Pass.class,Pass.class),
    L20(Kondoria.class,Kondoria.class,Kondoria.class,Kondoria.class,Ovapi.class,Ovapi.class,Ovapi.class,Pass.class,Pass.class),
    L21(Doll.class,Doll.class,Doll.class,Doll.class,Minvo.class,Minvo.class,Minvo.class,Kondoria.class,Pass.class),
    L22(Doll.class,Doll.class,Minvo.class,Minvo.class,Kondoria.class,Kondoria.class,Ovapi.class,Ovapi.class,Pass.class),
    L23(Doll.class,Minvo.class,Kondoria.class,Kondoria.class,Kondoria.class,Kondoria.class,Ovapi.class,Ovapi.class,Pass.class),
    L24(Doll.class,Minvo.class,Kondoria.class,Kondoria.class,Kondoria.class,Kondoria.class,Ovapi.class,Ovapi.class,Pass.class),
    L25(Oneal.class,Oneal.class,Doll.class,Minvo.class,Kondoria.class,Kondoria.class,Ovapi.class,Ovapi.class,Pass.class);
    private Class[] classArray;

    Level(Class... clz) {
	classArray = clz;
    }

    public Class[] getClassList() {
	return classArray;
    }

}
