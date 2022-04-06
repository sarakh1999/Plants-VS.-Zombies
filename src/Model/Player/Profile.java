package Model.Player;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import com.gilecode.yagson.YaGson;

import java.util.ArrayList;

public class Profile {
    private ArrayList<String> purchasedZombies;
    private ArrayList<String> purchasedPlants;
    private static ArrayList<Profile> profiles = new ArrayList<Profile>();
    private String username;
    private String password;
    private int score;
    private int externalCoins;

    public Profile(String username, String password) {
        this.password = password;
        this.username = username;
        purchasedZombies = new ArrayList<String>();
        purchasedPlants = new ArrayList<String>();

        purchasedPlants.add("PeaShooter");
        purchasedPlants.add("SnowPea");
        purchasedPlants.add("ExplodeONut");
        purchasedPlants.add("ScaredyShroom");
        purchasedPlants.add("KernelPult");
        purchasedPlants.add("SunFlower");
        purchasedPlants.add("CherryBomb");
        purchasedPlants.add("Jalapeno");
        //purchasedPlants.add("MagnetShroom");
        purchasedPlants.add("Cattail");

        purchasedZombies.add("Zombie");
        purchasedZombies.add("Zomboni");
        purchasedZombies.add("ScreenDoorZombie");
        purchasedZombies.add("FootballZombie");
        purchasedZombies.add("ConeheadZombie");
        purchasedZombies.add("BalloonZombie");
        purchasedZombies.add("BungeeZombie");

    }

    public static Profile makeProfile(Profile profile) {
        YaGson yaGson = new YaGson();
        String s = profile.toString();
        Profile profile1 = yaGson.fromJson(s, Profile.class);
        profiles.add(profile1);
        return profile1;
    }

    public boolean havePlant(String name) {
        for (String p : purchasedPlants) {
            if (name.equalsIgnoreCase(p))
                return true;
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

    public void changeUsername(String username) {
        this.username = username;
    }

    public void change_Password(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void delete_account(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password))
            profiles.remove(this);
    }

    public static Profile login(String username, String password) {
        for (Profile p : profiles) {
            if (p.password.equals(password) && p.username.equals(username)) {
                return p;
            }
        }
        return null;
    }

    public static ArrayList<Profile> getAccounts() {
        return profiles;
    }

    public static void addAccount(Profile profile) {
        profiles.add(profile);
    }

    public ArrayList<String> getPurchasedZombies() {
        return purchasedZombies;
    }

    public ArrayList<String> getPurchasedPlants() {
        return purchasedPlants;
    }

    public void addZombie(Zombie zombie) {
        this.purchasedZombies.add(zombie.getName());
    }

    public static void setProfiles(ArrayList<Profile> profiles) {
        Profile.profiles = profiles;
    }

    public int getExternalCoins() {
        return externalCoins;
    }

    public void addPlant(Plant plant) {
        this.purchasedPlants.add(plant.getName());
    }

    public void setExternalCoins(int externalCoins) {
        this.externalCoins += externalCoins;
    }

    public static boolean validUsername(String username) {
        if (profiles.size() != 0) {
            for (Profile x : profiles)
                if (x.getUsername().equals(username)) {
                    System.out.println("eshkms");
                    return false;

                }
        }
        System.out.println("True e");
        return true;
    }

}