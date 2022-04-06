package Model.Card.Event;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

import static java.lang.StrictMath.abs;

public class NearRows extends Event {
    @Override
    public boolean check(Plant plant, Battle battle, int d) {
        for (int i = 0; i < battle.getMap().getCells().length; i++) {
            for (int j = 0; j < battle.getMap().getCells()[i].length; i++) {
                if (battle.getMap().getCell(i, j).x() == plant.getCell().x()) {
                    if (abs(battle.getMap().getCell(i, j).y() - plant.getCell().y()) <= d) {
                        if (!battle.getMap().getCell(plant.getCell().x(), plant.getCell().y()).getZombies().isEmpty()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean check(Zombie zombie, Battle battle, int d) {
//        for (int i = 0; i < Map.getHEIGHT()+4; i++) {
//            for (int j = 0; j < Map.getWIDTH()+4; i++) {
//                if (i == zombie.getCell().x()) {
//                    if (abs(j - zombie.getCell().y()) <= d) {
//                        if (!battle.getMap().getCell(i,j).getZombies().isEmpty()) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
        return false;
    }
}

