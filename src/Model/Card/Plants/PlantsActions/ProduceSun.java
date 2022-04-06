package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class ProduceSun extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {
        if (battle.getCurrentTurn() % plant.getTurn() == 0) {
            battle.getPlayer(1).setSun(battle.getPlayer(1).getSun() + plant.getProducedSun());
            System.out.println("suns" + battle.getPlayer(1).getSun());
        }
    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) {

    }
}
