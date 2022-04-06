package Model.Card;


import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Shop.Shop;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Card {

    protected String name;
    protected int id;
    protected static int uniqueId = 0;
    protected int AP; //num of throwing pea or projectiles
    protected int HP;
    protected Cell cell;
    protected int coin;
    protected static ArrayList<Plant> plants = new ArrayList<>();
    protected static ArrayList<Zombie> zombies = new ArrayList<>();
    protected int price;
    protected ImageView imageView;

    public static String makeString(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string = new String();
        String s;
        while (true) {
            s = br.readLine();
            if (s != null)
                string += (s);
            else
                break;
        }
        return string;
    }

    public static void calculateDistance() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setUniqueId(int uniqueId) {
        Card.uniqueId = uniqueId;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }

    public void setHP(int HP) {
        this.HP += HP;
    }

    public void setHealthPoint(int healthPoint){
        this.HP=healthPoint;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public abstract void setPrice();

    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static int getUniqueId() {
        return uniqueId;
    }

    public int getAP() {
        return AP;
    }

    public int getHP() {
        return HP;
    }

    public Cell getCell() {
        return cell;
    }

    public int getCoin() {
        return coin;
    }

    public static ArrayList<Plant> getPlants() {
        return plants;
    }

    public static ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public static void addToPlants(Plant plant) {
        plants.add(plant);
    }

    public static void addToZombies(Zombie zombie) {
        zombies.add(zombie);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(Image image) {
        Card card= this;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ImageView imageView=new ImageView(image);
                card.imageView = imageView;
            }
        });
        this.imageView = new ImageView(image);
    }
}
