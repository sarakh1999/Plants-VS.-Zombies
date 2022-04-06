package Controller.GameMode;

import Model.Card.Card;
import Model.Card.Zombies.Zombie;
import Model.Player.Profile;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class ZombieGameMode extends GameMode {

    private String mapType;
    private Profile profile;

    public ZombieGameMode(){}

    public ZombieGameMode(Profile profile, Battle battle) throws IOException {
        for (int i=0;i<landMower.length;i++){
            landMower[i]=false;
        }
        this.mapType = "day";
        this.profile = profile;
        int size = 0;
//        ArrayList<Plant> randomPlants = new ArrayList<>();
//        randomPlants.add(Plant.findPlant("ExplodeONut"));
//        randomPlants.add(Plant.findPlant("ExplodeONut"));
//        randomPlants.add(Plant.findPlant("ExplodeONut"));
//        randomPlants.add(Plant.findPlant("ScaredyShroom"));
//        randomPlants.add(Plant.findPlant("ScaredyShroom"));
//        randomPlants.add(Plant.findPlant("ScaredyShroom"));
//        randomPlants.add(Plant.findPlant("ScaredyShroom"));
//        randomPlants.add(Plant.findPlant("ScaredyShroom"));
//        randomPlants.add(Plant.findPlant("ScaredyShroom"));
//        randomPlants.add(Plant.findPlant("SnowPea"));
//        randomPlants.add(Plant.findPlant("SnowPea"));
//        randomPlants.add(Plant.findPlant("CabbagePult"));
//        randomPlants.add(Plant.findPlant("CabbagePult"));
//        randomPlants.add(Plant.findPlant("GatlingPea"));
//
//        if (!getBattle().getMap().getCell(0, 2).isWater()) {
//            randomPlants.add(Plant.findPlant("PotatoMine"));
//            randomPlants.add(Plant.findPlant("PotatoMine"));
//            size = randomPlants.size();
//        }
//
//        if (getBattle().getMap().getCell(0, 2).isWater()) {
//            randomPlants.add(Plant.findPlant("TangleKelp"));
//            randomPlants.add(Plant.findPlant("TangleKelp"));
//            randomPlants.add(Plant.findPlant("Cattail"));
//            randomPlants.add(Plant.findPlant("LilyPad"));
//            randomPlants.add(Plant.findPlant("LilyPad"));
//            randomPlants.add(Plant.findPlant("LilyPad"));
//            size = randomPlants.size();
//        }
//        int randomNumberOfPlants = (int) (Math.random() * ((size) + 1)) + size;
//        for (int i = 0; i < randomNumberOfPlants; i++) {
//            int randomPlant = (int) (Math.random() * ((randomPlants.size() - 4) + 1)) + 4;
//            int randomPlace = (int) (Math.random() * (Map.getHEIGHT()) + 1);
//            Plant plant = new Plant(randomPlants.get(randomPlant).getName());
//            plant.setCell(generateMap().getCell(randomPlace, Map.getWIDTH() - 1));
//            generateMap().getCell(randomPlace, 0).setPlant(plant);
//        }


    }


    @Override
    public void wave(Battle battle, Pane root) {
//        for (int i = 0; i < getBattle().getMap().getCells().length; i++) {
//            ArrayList<Zombie> zombiesInRow = new ArrayList<>();
//            for (int j = 0; j < getBattle().getMap().getCells()[i].length; j++) {
//                zombiesInRow.addAll(getBattle().getMap().getCells()[i][j].getZombies());
//            }
//            if (zombiesInRow.size() <= 2) {
//                if (mapType.equals("Water")) {
//                    Random random = new Random();
//                    int randomPlace = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
//                    //if in landCell
//                    if (randomPlace != 4 && randomPlace != 5) {
//                        //zombies number 0 to 12 can be in landCell
//                        int zombieNumber = (int) (Math.random() * (12 + 1));
//                        Zombie zombie = new Zombie(Card.getZombies().get(zombieNumber).getName());
//                        if (profile.getExternalCoins() >= zombie.getPrice() * 10) {
//                            profile.setExternalCoins(-zombie.getPrice() * 10);
//                            zombie.setCell(GameMode.generateMap(this).getCell(randomPlace, 0));
//                            GameMode.generateMap(this).getCell(randomPlace, 0).getZombies().add(zombie);
//                            getWaveZombies().add(zombie);
//                        }
//                    }
//                    //if in water cell
//                    if (randomPlace == 4 || randomPlace == 5) {
//                        int zombieNumber = (int) (Math.random() * ((14 - 13) + 1)) + 13;
//                        Zombie zombie = new Zombie(Card.getZombies().get(zombieNumber).getName());
//                        if (profile.getExternalCoins() >= zombie.getPrice() * 10) {
//                            profile.setExternalCoins(-zombie.getPrice() * 10);
//                            zombie.setCell(GameMode.generateMap(this).getCell(randomPlace, 0));
//                            GameMode.generateMap(this).getCell(randomPlace, 0).getZombies().add(zombie);
//                            getWaveZombies().add(zombie);
//                        }
//                    }
//                }
//                if (mapType.equals("Land")) {
//                    int zombieNumber = (int) (Math.random() * (12 + 1));
//                    int randomPlace = (int) (Math.random() * ((Map.getHEIGHT()) + 1));
//                    Zombie zombie = new Zombie(Card.getZombies().get(zombieNumber).getName());
//                    if (profile.getExternalCoins() >= zombie.getPrice() * 10) {
//                        profile.setExternalCoins(-zombie.getPrice() * 10);
//                        zombie.setCell(GameMode.generateMap(this).getCell(randomPlace, 0));
//                        GameMode.generateMap(this).getCell(randomPlace, 0).getZombies().add(zombie);
//                        getWaveZombies().add(zombie);
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < getBattle().getMap().getCells().length; i++) {
//            for (int j = 0; j < getBattle().getMap().getCells()[i].length; i++) {
//                if (getBattle().getMap().getCells()[i][j].getPlant().getHP() == 0) {
//                    Plant p = new Plant(getBattle().getMap().getCells()[i][j].getPlant().getName());
//                    profile.setExternalCoins(10 * p.getHP());
//                }
//            }
//        }
    }

    @Override
    public boolean canWave(Battle battle) {
        return false;
    }

    @Override
    public boolean handleWin(Profile profile, Battle battle) {
        boolean allPlantsAreDead=true;
        for (int i = 0; i < getBattle().getMap().getCells().length; i++) {
            for (int j = 0; j < getBattle().getMap().getCells()[i].length; j++) {
                if(getBattle().getMap().getCells()[i][j].getPlant()!=null){
                    allPlantsAreDead=false;
                    break;
                }
            }
        }
        if(allPlantsAreDead){
            return false;
        }
        boolean canNotBuyAnyZombie=true;
        for(int i=0;i< Zombie.getZombies().size();i++){
            if(Zombie.getZombies().get(i).getPrice()<=profile.getExternalCoins()){
                canNotBuyAnyZombie=false;
                break;
            }
        }
        if(canNotBuyAnyZombie){
            return false;
        }
        return true;
    }

    @Override
    public void updateCollection(Battle battle) {

    }

    @Override
    public ArrayList<Card> getAvailableCards() {
        return null;
    }

    @Override
    public void generateSun(Battle battle) {

    }


}
