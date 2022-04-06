package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.PeaOrProjectile;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class Shoot extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {
        PeaOrProjectile pea;
        if (plant.getHP() > 0) {

            if(plant.getName().equalsIgnoreCase("split pea")) {
                PeaOrProjectile pea1 = new PeaOrProjectile(plant);
                battle.getPeas().add(pea1);
                pea = new PeaOrProjectile(plant);
                plant.getCell().getPeas().add(pea1);
                plant.getCell().getPeas().add(pea);
                pea.setBackward(true);
                battle.getPeas().add(pea);
            }
            else {
                for (int i=0;i<plant.getPeaAmount();i++){
                    battle.getPeas().add(new PeaOrProjectile(plant));
                    plant.getCell().getPeas().add(new PeaOrProjectile(plant));
                    //todo
                }
            }
        }
    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) {
    }
}
