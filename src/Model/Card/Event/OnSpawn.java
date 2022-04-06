package Model.Card.Event;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;

//for checking that if the thing is in the map or not
public class OnSpawn extends Event {
    @Override
    public boolean check(Plant plant, Battle battle, int d) {
//        System.out.println("onSpawn");
//        for (int i = 0; i < battle.getMap().getCells().length; i++) {
//            for (int j = 0; j < battle.getMap().getCells()[i].length; j++) {
//                if (i == plant.getCell().x()) {
//                    if (j == plant.getCell().y()) {
//                        if (!battle.getMap().getCell(plant.getCell().x(), plant.getCell().y()).getZombies().isEmpty()) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
        return true;
    }

    @Override
    public boolean check(Zombie zombie, Battle battle, int d) {
        int x =zombie.getCell().x();
        int y=zombie.getCell().y();
        if (y >0 && battle.getMap().getCell(x,y-1).getPlant() == null) {
            return true;
        }
        return false;
    }
}
