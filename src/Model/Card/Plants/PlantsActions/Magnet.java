package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Magnet extends Action {
    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {
        ArrayList<Zombie> zombies = new ArrayList<>();
        for(Cell[] i : battle.getMap().getCells())
        {
            for(Cell j : i)
            {
//                if(abs(j.x() - plant.getCell().x())<=1 && abs(j.y() - plant.getCell().y())<=1)
//                {
                    zombies.addAll(j.getZombies());
                //}
            }
        }
        for(int i=0;i<zombies.size();i++){
            if(zombies.get(i).showIronHat()){
                zombies.get(i).setIronHat(false);
            }
        }
        plant.setTurn(3);
    }


    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) throws IOException {

    }
}
