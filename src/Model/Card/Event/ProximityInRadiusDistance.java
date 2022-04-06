package Model.Card.Event;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;

import static java.lang.Math.abs;

public class ProximityInRadiusDistance extends Event {
    @Override
    public boolean check(Plant plant, Battle battle, int d) {
            for (int i = 0; i < battle.getMap().getCells().length; i++) {
                for (int j = 0; j < battle.getMap().getCells()[i].length; j++) {
                    if (!battle.getMap().getCells()[i][j].getZombies().isEmpty()) {
                        if (abs(battle.getMap().getCells()[i][j].x() - plant.getCell().x()) <= 1) {
                            if (abs(battle.getMap().getCells()[i][j].y() - plant.getCell().y()) <= 1) {
                                return true;
                            }
                        }
                    }
                }
            }
        return false;
    }
}
