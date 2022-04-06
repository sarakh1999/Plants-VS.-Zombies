package Model.Shop;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;

import java.util.ArrayList;

public class Collection {
    //it is the hand
    private ArrayList<Plant> plants = new ArrayList<>();
    private ArrayList<Zombie> zombies = new ArrayList<>();

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void addZombie(Zombie zombie) {
        this.zombies.add(zombie);
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    public void removeZombie(String name) {
        Zombie z = Zombie.findZombie(name);
        if (z!=null)
            this.zombies.remove(z);
    }

    public void removePlant(String name) {
        Plant p = Plant.findPlant(name);
        if (p!=null)
            this.plants.remove(p);
    }

}


