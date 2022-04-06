package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class KillNearest extends Action {

    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {
        double MinRad = 100;
        Cell nearestCell = null;
        if (plant.getHP() > 0) {
            for (Cell[] i : battle.getMap().getCells()) {
                for (Cell cell : i) {
                    if (!cell.getZombies().isEmpty()) {
                        if (calculateDistance(plant.getCell(), cell) < MinRad) {
                            MinRad = calculateDistance(plant.getCell(), cell);
                            nearestCell=cell;
                        }
                    }
                }
            }
        }
        nearestCell.getZombies().get(0).setHealthPoint(0);
    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) throws IOException {

    }

    public double calculateDistance(Cell cell, Cell cell1) {
        return  Math.sqrt(((cell.y() - cell1.y()) * (cell.y() - cell1.y())) +
                ((cell.x() - cell1.x()) * (cell.x() - cell1.x())));
    }

}
