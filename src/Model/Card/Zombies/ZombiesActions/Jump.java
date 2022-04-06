package Model.Card.Zombies.ZombiesActions;
import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class Jump extends Action {

    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) {
        int x = zombie.getCell().x();
        int y = zombie.getCell().y();
        if (y>0 && battle.getMap().getCell(x , y-1).getPlant() != null) {
            if (zombie.getHP() > 0) {
                battle.getMap().getCell(zombie.getCell().x(), zombie.getCell().y() ).getZombies().remove(zombie);
                zombie.setCell(battle.getMap().getCell(x , y -2));
                battle.getMap().getCell(zombie.getCell().x(), zombie.getCell().y()).getZombies().add(zombie);
            }
        }
    }
}
