package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.util.Random;

public class AppearInCell extends Action {

    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) {
        Random random = new Random();
        int x = (int) (Math.random() * (7) )+2;
        int y = (int) (Math.random() * (20)) +2;
        battle.getMap().getCell(x,y).setPlant(null);
        zombie.setHealthPoint(0);
    }
}