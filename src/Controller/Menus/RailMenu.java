package Controller.Menus;

import Controller.GameMode.Battle;
import Controller.GameMode.Rail;
import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;
import Model.Player.Profile;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class RailMenu extends Menu {
    public Rail rail = new Rail();
    public Player player1;
    public Player player2;

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public Battle battle = new Battle(player1, player2,rail);


    public void plant(String name, int x, int y, Rail rail) throws IOException {
        for (Card card : rail.getAvailableCards())
            if (card.getName().equalsIgnoreCase(name)) {
                battle.getMap().getCell(x, y).setPlant(Plant.makePlant(name));
                rail.getAvailableCards().remove(card);
                System.out.println("planted");
                return;
            }
        System.out.println("plant not found");
    }

    public void record() {
        System.out.println("killed zombies: " + rail.getRecord());
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

    public void remove(int x, int y) {
        Map map = battle.getMap();
        Cell cell = map.getCell(x, y);
        cell.removePlant();
    }

    public void endTurn(Profile profile, Battle battle, Pane root) throws IOException {
        rail.wave(battle, Menu.root);
        rail.setLastTurnUpdatingRailCollection(1);
        battle.actAllMembers(root);
        rail.generateSun(battle);
        rail.handleWin(profile,battle );
        rail.setLastTurnWaved(1);
        rail.addPlant(battle);
        rail.updateCollection(battle);
        battle.setCurrentTurn(1);
        System.out.println(battle.getCurrentTurn());
//        for (Plant p:player1.getPlants()) {
//            if (p.getLoading()!=0) {
//                p.setLoading(p.getLoading()-1);
//            }
//        }
//        System.out.println(player1.getSun());
    }

}
