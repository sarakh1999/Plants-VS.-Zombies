package Controller.Menus;

import Controller.GameMode.Battle;
import Controller.GameMode.ZombieGameMode;
import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ZombieMenu extends Menu {

    public ZombieGameMode zombieGameMode = new ZombieGameMode();
    public Player player1;
    public Player player2;
    public Battle battle = new Battle(player1, player2, zombieGameMode);

    public void showHand() {
        for (Zombie z : player2.getZombies()) {
            System.out.println(z.getName() + "\t" + z.getHP());
        }
    }

    public void showLanes() {
        for (int i = 2; i < Map.getHEIGHT() + 2; i++) {
            String s = Integer.toString(i);
            for (Zombie z : battle.getMap().getCell(i, 21).getZombies())
                s = s + "\t" + z.getName();
            System.out.println(s);
            s = null;
        }
    }

    public void putZombie(String name, int x) throws IOException {
        for (Zombie z : player2.getZombies()) {
            if (z.getName().equalsIgnoreCase(name)) {
                battle.getMap().getCell(x, 21).addZombie(Zombie.makeZombie(name));
                break;
            }
        }
    }

    public void start(Pane root) {
        while (true) {////ta zamani ke round tamom she
            for (int i = 2; i < Map.getHEIGHT() + 2; i++)
                for (int j = 2; j < Map.getWIDTH() + 2; j++) {
                    if (battle.getMap().getCell(i, j).getPlant() != null)
                        battle.getMap().getCell(i, j).getPlant().act(battle, root );
                    if (battle.getMap().getCell(i, j).getZombies().size() != 0)
                        for (Zombie z : battle.getMap().getCell(i, j).getZombies())
                            z.act(battle,root);
                }
            for (Plant p : this.player1.getPlants()) {
                if (p.getLoading() != 0) {
                    p.setLoading(p.getLoading() - 1);
                }
            }
        }
    }

    public void secondStart() throws IOException {
        int num = (int) (Math.random() * 3) + 8;
        int used = 0;
        int plantNum;
        int x;
        int y;
        while (used < num) {
            plantNum = (int) (Math.random() * (Card.getPlants().size() + 1));
            x = (int) (Math.random() * (Map.getHEIGHT() + 1));
            y = (int) (Math.random() * (Map.getWIDTH() + 1));
            if (battle.getMap().getCell(x, y).getPlant() != null) {
                battle.getMap().getCell(x, y).setPlant(Plant.makePlant(Card.getPlants().get(plantNum).getName()));
                used++;
            }

        }
    }

    public void showLawn() {
        for (Cell[] cells : battle.getMap().getCells()) {
            for (Cell cell : cells) {
                if (cell.getZombies().size() != 0) {
                    for (Zombie z : cell.getZombies()) {
                        System.out.println(z.getName() + "\t" + cell.x() + "," + cell.y() + "\t" + z.getHP());
                    }
                }
                if (cell.getPlant() != null) {
                    Plant z = cell.getPlant();
                    System.out.println(z.getName() + "\t" + cell.x() + "," + cell.y() + "\t" + z.getHP());
                }
            }
        }
    }
}
