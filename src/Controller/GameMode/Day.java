package Controller.GameMode;

import Model.Card.Card;
import Model.Player.Profile;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class Day extends GameMode {

    private int lastTurnGivingSuns = 0;

    private int lastTurnlastZombieKilled;

    int random = (int) (Math.random() * ((2 - 1) + 1)) + 1;

    public Day() {
        //player is gardner
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
                generateZombies(battle,root );
            }
            setWaveCounter(1);
        }
    }

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
            System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOPS! YOU LOST");
            return false;
        }
        //if player win
        if (allZombiesAreDead(profile, battle)) {
            System.out.println("Player WOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOON");
            profile.setExternalCoins(10*getRecord());
            lastTurnlastZombieKilled = getBattle().getCurrentTurn();
            return false;
        }
        //continue the game
        System.out.println("Continue");
        return true;
    }

    //removing dead zombies and plants
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
            battle.getPlayer(1).setSun(numberOfSuns + battle.getPlayer(1).getSun());
            lastTurnGivingSuns = 0;
        }
    }

    public void setLastTurnGivingSuns(int lastTurnUpdatingDarSuns) {
        this.lastTurnGivingSuns += lastTurnUpdatingDarSuns;
    }

}