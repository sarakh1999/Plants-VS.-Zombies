package Model.Map;

import Model.Card.Plants.PeaOrProjectile;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public class Cell {
    private int x;
    private int y;
    //in each cell we have just 1 plant but not only 1 zombie
    private Plant plant = null;
    private ArrayList<Zombie> zombies;
    private ArrayList<PeaOrProjectile> peas = new ArrayList<>();
    private boolean water;
    private boolean LilyPad;

//     boolean canBePlanted(Plant plant);
//     boolean canBeZombied(Zombie zombie);
//     void removePlant();
//     public void plant(Plant plant);

    public Cell(int x, int y,boolean water) {
        this.x = x;
        this.y = y;
        this.zombies = new ArrayList<Zombie>();
    }

    public Cell() {
    }

    void removeDeadZombie(Zombie zombie, Map map) {
        ArrayList<Zombie> tempZombies = new ArrayList<>();
        Cell thisCell = map.getCell(this.x, this.y);
        for (Zombie i : thisCell.zombies) {
            if (i.getHealth() == 0) {
                tempZombies.add(i);
            }
        }
        for (Zombie i : tempZombies) {
            thisCell.zombies.remove(i);
        }
    }


    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
        System.out.println("planted");
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void setZombies(ArrayList<Zombie> zombies) {
        this.zombies = zombies;
    }
    public void addZombie(Zombie zombie){
        this.zombies.add(zombie);
    }

    public void removePlant() {
        plant = null;
    }

    public boolean canBePlanted() {
        if (this.water) {
            if (this.LilyPad || plant.getName().equalsIgnoreCase("lilypad") ||
                    plant.getName().equalsIgnoreCase("tanglekelp") ||
                    plant.getName().equalsIgnoreCase("cattail") ) {
                if (this.plant == null)
                    return true;
            }
            return false;
        } else {
            if (this.plant == null)
                return true;
            return false;
        }
    }

    public ArrayList<PeaOrProjectile> getPeas() {
        return peas;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public boolean isWater() {
        return water;
    }

    public boolean isLilyPad() {
        return LilyPad;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLilyPad() {
        this.LilyPad = true;
    }
}
