package Controller.GameMode;

import Model.Card.Plants.PeaOrProjectile;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.util.ArrayList;


public class Battle {

    GameMode gameMode;
    private int currentTurn = 0;
    private int previousTurn;
    private Player player1;
    private Player player2;
    private Map map;
    private ArrayList<Zombie> zombies;
    private Map newMap;
    private ArrayList<PeaOrProjectile> peas = new ArrayList<>();
    public Map getNewMap() {
        return newMap;
    }

    public void setNewMap(Map newMap) {
        this.newMap = newMap;
    }

    public Battle(){}

    public Battle(Player player1, Player player2, GameMode gameMode) {
        this.player2 = player2;
        this.player1 = player1;
        this.gameMode = gameMode;
        this.map = GameMode.generateMap(gameMode);
    }

    public void actAllMembers(Pane root) {
        for (int i = 0; i < Map.getHEIGHT() + 4; i++) {
            for (int j = 0; j < Map.getWIDTH() + 4; j++) {
                if (map.getCell(i, j).getPlant() != null) {
                    System.out.println(map.getCell(i, j).getPlant().getName() + "///////////////");
                    map.getCell(i, j).getPlant().act(this,root );
                }
                //todo
                try {
                    for (Zombie z : map.getCell(i, j).getZombies()) {
                        System.out.println(z.getName() + "/////////////////");
                        z.act(this,root);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                map.getCell(i, j).setZombies(new ArrayList<Zombie>());
//                System.out.println( "size" + map.getCell(i, j).getZombies().size());
//                //todo
            }
        }
        for (Plant p : this.player1.getPlants()) {
            if (p.getLoading() != 0) {
                p.setLoading(p.getLoading() - 1);
            }
        }

//        for (int i = 0; i < Map.getHEIGHT() + 4; i++) {
//            for (int j = 0; j < Map.getWIDTH() + 4; j++) {
//                map.setCell(i, j, newMap.getCell(i, j));
//            }
//        }
//        newMap = gameMode.generateMap();
    }

    public void peaMove() {
        for (PeaOrProjectile pea : this.peas) {
            pea.peaMove(this);
        }
    }

    public Player getPlayer(int i) {
        if (i == 1)
            return player1;
        if (i == 2)
            return player2;
        return null;
    }

    public void setPlayer(Player player, int i) {
        if (i == 1)
            player1 = player;
        if (i == 2)
            player2 = player;
    }

    public Battle(Player player1, Player player2, Day day) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameMode = day;
        this.map = GameMode.generateMap(day);
        this.newMap = GameMode.generateMap(day);
    }

    public Battle(Player player1, Player player2, Rail rail) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameMode = rail;
        this.map = GameMode.generateMap(rail);
        this.newMap = GameMode.generateMap(rail);
    }
    public Battle(Player player1, Player player2, Water water) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameMode = water;
        this.map = GameMode.generateMap(water);
        this.newMap = GameMode.generateMap(water);
    }

    public Battle(Player player1, Player player2, String zom) {
        this.player1 = player1;
        this.player2 = player2;
        if (zom.equalsIgnoreCase("zombie"))
            gameMode = new ZombieGameMode();
        map = GameMode.generateMap(gameMode);
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn += currentTurn;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void init() {
        this.map = GameMode.generateMap(gameMode);
    }

    public void PlayTurn() {
        gameMode.checkState();
    }

    public void plant(Plant plant, Cell cell) {
        cell.setPlant(plant);
    }

    //bilche
    public void dig(Cell cell) {
        //if player 1 is gardener
        if (player1.getPlants() != null) {
            cell.setPlant(null);
        }
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public int getPreviousTurn() {
        return previousTurn;
    }

    public void setPreviousTurn(int previousTurn) {
        this.previousTurn = previousTurn;
    }


    public ArrayList<PeaOrProjectile> getPeas() {
        return peas;
    }
}
