package Model.Card.Event;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;

public class NearestCell extends Event {
    @Override
    public boolean check(Plant plant, Battle battle, int d) {
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell j : i) {
                if (!j.getZombies().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean check(Zombie zombie, Battle battle, int d) {
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell j : i) {
                if (j.getPlant() != null) {
                    return true;
                }
            }
        }

        return false;
    }
}
