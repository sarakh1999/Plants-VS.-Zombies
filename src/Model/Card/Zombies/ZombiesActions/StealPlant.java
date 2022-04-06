package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class StealPlant extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) {
//        System.out.println("steal@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        int x = zombie.getCell().x();
//        int y = zombie.getCell().y();
//        Cell c = battle.getMap().getCell(x,y-1);
//        if (c.getPlant() != null) {
//            System.out.println("bbsjvvhsjhdslkvvvvsvdliehviakekafafljajfakwjfc");
//            if (zombie.getHP() > 0) {
//                battle.getMap().getCell(c.x(), c.y() - 1).getPlant().setHealthPoint(0);
//                c.getPlant().setHealthPoint(0);
//                System.out.println("Vayyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
//            }
//        }
    }
}
