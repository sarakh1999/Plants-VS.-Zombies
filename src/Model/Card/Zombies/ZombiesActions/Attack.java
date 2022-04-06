package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

//hamleye addi
public class Attack extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) {
        for (int i = 0; i < Map.getHEIGHT(); i++) {
            for (int j = 0; j < Map.getWIDTH(); j++) {
                if (battle.getMap().cells[i][j].getPlant() != null) {
                    if (i == zombie.getCell().x() && j == zombie.getCell().y() -1) {
                        if (!zombie.getName().equals("GigaGargantuar")) {
                            if (battle.getMap().cells[i][j].getPlant() .getHP() > 0) {
                                if (zombie.getHP() > 0) {
                                    battle.getMap().cells[i][j].getPlant().setHP(-zombie.getAP());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
