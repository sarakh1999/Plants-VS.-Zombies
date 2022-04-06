package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Zombies.Zombie;
import Model.Map.Map;
import Model.Player.Profile;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class Water extends GameMode {

    private int lastTurnGivingSuns = 0;
    private int lastTurnlastZombieKilled;
    int random = (int) (Math.random() * ((2 - 1) + 1)) + 1;

    public Water() {
        getBattle().getPlayer(1).setSun(2);
        for (int i = 0; i < landMower.length; i++) {
            landMower[i] = true;
        }
        GameMode.generateMap(this);
    }

    @Override
    public void wave(Battle battle, Pane root) throws IOException {
        if (canWave(battle)) {
            int numberOfZombiesInAWave = (int) (Math.random() * ((10 - 4) + 1)) + 4;
            for (int i = 0; i < numberOfZombiesInAWave; i++) {
                int randomPlace = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
                boolean zombieIsMade = false;
                Zombie zombie = null;
                while (!zombieIsMade) {
                    int zombieNumber = (int) (Math.random() * (12 + 1));
                    zombie = Zombie.makeZombie(Zombie.getZombies().get(zombieNumber).getName());
                    if (zombie.getName().equalsIgnoreCase("SnorkelZombie") ||
                            zombie.getName().equalsIgnoreCase("DolphinRiderZombie")) {
                        if (randomPlace == 4 || randomPlace == 5) {
                            zombieIsMade = true;
                            System.err.println(zombie.getName());
                        }
                    } else if (!zombie.getName().equalsIgnoreCase("SnorkelZombie") &&
                            !zombie.getName().equalsIgnoreCase("DolphinRiderZombie")) {
                        if (randomPlace != 4 && randomPlace != 5) {
                            zombieIsMade = true;
                            System.err.println(zombie.getName());
                        }
                    } else {
                        zombieIsMade = false;
                    }
                }
                zombie.setCell(battle.getMap().getCell(randomPlace, 21));
                battle.getMap().getCell(randomPlace, 21).addZombie(zombie);
            }
            setWaveCounter(1);
        }
    }

    //check the turn
    //todo
    //7 turn pas az marge last zombie true mishe
    @Override
    public boolean canWave(Battle battle) {
        if (battle.getCurrentTurn() >= 3 && this.getWaveCounter() <= 3) {
//            if (lastTurnlastZombieKilled == 7) {
            lastTurnlastZombieKilled = 0;
            return true;
//            }
        }

        return false;
    }

    @Override
    public boolean handleWin(Profile profile, Battle battle) {
        //if player lose
        if (zombieReachedToTheEnd(battle)) {
            return false;
        }
        //if player win
        if (allZombiesAreDead(profile, battle)) {
            return false;
        }
        //continue the game
        return true;
    }

    @Override
    public void updateCollection(Battle battle) {
        removeDeadZombies(battle);
        removeDeadPlants(battle);
    }

    @Override
    public ArrayList<Card> getAvailableCards() {
        return null;
    }


    @Override
    public void generateSun(Battle battle) {
        int numberOfSuns = (int) (Math.random() * ((5 - 2) + 1)) + 2;
        if (lastTurnGivingSuns == random) {
            random = (int) (Math.random() * ((2 - 1) + 1)) + 1;
            lastTurnGivingSuns = 0;
            battle.getPlayer(1).setSun(numberOfSuns + battle.getPlayer(1).getSun());
        }
    }


    public void setLastTurnGivingSuns(int lastTurnUpdatingDarSuns) {
        this.lastTurnGivingSuns += lastTurnUpdatingDarSuns;
    }
}

