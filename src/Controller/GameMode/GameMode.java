package Controller.GameMode;

import Controller.Menus.Menu;
import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import Model.Player.Player;
import Model.Player.Profile;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public abstract class GameMode {
    //players that it is 0 (gardener) or 1 (zombie) are set in the menu

    private int waveCounter = 0;
    private boolean canWave = true;
    private ArrayList<Zombie> waveZombies = new ArrayList<>();
    protected boolean[] landMower = new boolean[Map.getHEIGHT() + 4];

    {
        for (int i = 0; i < 6; i++) {
            landMower[i] = false;
        }
    }

    public int lastTurnWaved = 0;
    public Player player1 = new Player();
    public Player player2 = new Player();
    private Battle battle = new Battle(player1, player2, this);
    private int record = 0;

    public abstract void wave(Battle battle, Pane root) throws IOException;

    public abstract boolean canWave(Battle battle);

    public abstract boolean handleWin(Profile profile, Battle battle);

    public abstract void updateCollection(Battle battle) throws IOException;

    public abstract void generateSun(Battle battle);

    public abstract ArrayList<Card> getAvailableCards();

    public static Map generateMap(GameMode gameMode) {
        if (gameMode instanceof Water)
            return generateWaterMap();
        else
            return generateLandMap();
    }

    public ArrayList<Zombie> getWaveZombies() {
        return waveZombies;
    }

    public int getWaveCounter() {
        return waveCounter;
    }

    public void setWaveCounter(int waveCounter) {
        this.waveCounter += waveCounter;
    }

    public boolean CanWave() {
        return canWave;
    }

    public boolean checkState() {
        return false;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        battle = battle;
    }

    //chamanzan
    public boolean landMower(int i) {
        System.err.println("in method");
        if (landMower[i]) {
            landMower[i] = false;
            System.err.println("landMower");
            for (int k = 0; k < Map.getWIDTH() + 4; k++) {
                System.err.println("ahmaq" + battle.getMap().getCell(i, k).getZombies().size());
                for (int a = 0; a < battle.getMap().getCell(i, k).getZombies().size(); a++) {
                    System.err.println("khodeti");
                    battle.getMap().getCell(i, k).getZombies().get(a).setHP(0);
                }

            }
            return true;
        }
        return false;
    }

    public boolean zombieReachedToTheEnd(Battle battle) {
        for (int i = 0; i < Map.getHEIGHT() + 4; i++) {
            if (!battle.getMap().getCell(i, 0).getZombies().isEmpty() || !battle.getMap().getCell(i, 1).getZombies().isEmpty()) {
                System.out.println("finish");
                Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
//                if (!landMower[i])
                return true;
//                if(landMower[i]){
//                    System.err.println("before method landMower");
//                    landMower(i);
//                }
            }
        }
        System.out.println("continue the game");
        return false;
    }

    public boolean allZombiesAreDead(Profile profile, Battle battle) {
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell j : i) {
                if (!j.getZombies().isEmpty()) {
                    System.out.println("all zombies Are NOT Dead     size     " + j.getZombies().size());
                    return false;
                }
            }
        }
        System.out.println("all zombies are dead");
        return true;
    }

    public static Map generateLandMap() {
        Map m = new Map();
        for (int i = 0; i < Map.getHEIGHT() + 4; i++) {
            for (int j = 0; j < Map.getWIDTH() + 4; j++) {
                m.setCell(i, j, new Cell(i, j, false));
            }
        }
        return m;
    }

    public static Map generateWaterMap() {
        Map m = new Map();
        for (int i = 4; i < 6; i++) {
            for (int j = 0; j < Map.getWIDTH() + 4; j++) {
                m.setCell(i, j, new Cell(i, j, true));
            }
        }
        for (int i = 6; i < 10; i++) {
            for (int j = 0; j < Map.getWIDTH() + 4; j++) {
                m.setCell(i, j, new Cell(i, j, false));
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < Map.getWIDTH() + 4; j++) {
                m.setCell(i, j, new Cell(i, j, false));
            }
        }
        return m;
    }


    public void generateZombies(Battle battle, Pane root) throws IOException {
        int randomPlace = (int) (Math.random() * 6) + 2;
        boolean zombieIsMade = false;
        Zombie zombie = null;
        while (!zombieIsMade) {
            int zombieNumber = (int) (Math.random() * (12 + 1));
            zombie = Zombie.makeZombie(Zombie.getZombies().get(zombieNumber).getName());
            if (zombie.getName().equalsIgnoreCase("SnorkelZombie") ||
                    zombie.getName().equalsIgnoreCase("DolphinRiderZombie")) {
                zombieIsMade = false;
            } else {
                zombieIsMade = true;
            }
        }
        zombie.setCell(battle.getMap().getCell(randomPlace, 21));
        Zombie finalZombie = zombie;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Image image = new Image("FootballZombie1.png");
                finalZombie.setImageView(image);
                finalZombie.getImageView().setX(650);
                finalZombie.getImageView().setY((randomPlace - 1) * 78);
                finalZombie.getImageView().setFitWidth(70);
                finalZombie.getImageView().setFitHeight(70);
                root.getChildren().add(finalZombie.getImageView());
            }
        });
        battle.getMap().getCell(randomPlace, 21).addZombie(zombie);
    }


    public void setLastTurnWaved(int lastTurnWaved) {
        this.lastTurnWaved += lastTurnWaved;
    }

    public int removeDeadZombies(Battle battle) {
        ArrayList<Zombie> zombiesToBeDeleted = new ArrayList<>();
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell j : i) {
                for (Zombie z : j.getZombies()) {
                    if (z.getHP() == 0) {
                        zombiesToBeDeleted.add(z);
                    }
                }
            }
        }

        for (int k = 0; k < zombiesToBeDeleted.size(); k++) {
            int x = zombiesToBeDeleted.get(k).getCell().x();
            int y = zombiesToBeDeleted.get(k).getCell().y();
            battle.getMap().getCell(x, y).getZombies().remove(zombiesToBeDeleted.get(k));
        }
        record += zombiesToBeDeleted.size();
        return zombiesToBeDeleted.size();
    }

    public int removeDeadPlants(Battle battle) {
        ArrayList<Plant> plantsToBeDeleted = new ArrayList<>();
        for (Cell[] i : battle.getMap().getCells()) {
            for (Cell j : i) {
                if (j.getPlant() != null && j.getPlant().getHP() == 0) {
                    plantsToBeDeleted.add(j.getPlant());
                }
            }
        }
        for (int k = 0; k < plantsToBeDeleted.size(); k++) {
            int x = plantsToBeDeleted.get(k).getCell().x();
            int y = plantsToBeDeleted.get(k).getCell().y();
            battle.getMap().getCell(x, y).setPlant(null);
            System.out.println("size    " + battle.getMap().getCell(x, y).getZombies().size());
        }
        return plantsToBeDeleted.size();
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int i) {
        record += i;
    }

}


