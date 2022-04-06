package Model.Card;

import Controller.GameMode.Battle;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Action {

    //PlantsActions
    public void doAction(Plant plant, Battle battle, int d, Pane root){}
    public  void doAction(Zombie zombie, Battle battle, int d, Pane root) throws IOException{}
}
