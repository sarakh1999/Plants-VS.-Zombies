package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class TurnToNormalZombie extends Action {

    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) throws IOException {
        if(!zombie.getName().equals("Zombie"))
        {
            Cell cell= zombie.getCell();
            if(zombie.getHP()==0) {
                //Zombie.getZombies().remove(zombie);
                //todo
                //this new ZombieGameMode should be added to player hand
                Zombie zombie1 = Zombie.makeZombie("Zombie");
                //cell.getZombies().add(zombie1);
                zombie.getCell().addZombie(zombie1);
                zombie1.setCell(zombie.getCell());
            }
        }
    }
}
