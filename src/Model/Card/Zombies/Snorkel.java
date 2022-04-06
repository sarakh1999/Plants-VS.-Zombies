package Model.Card.Zombies;

import Model.Card.Card;
import com.gilecode.yagson.YaGson;

import java.io.File;
import java.io.IOException;

public class Snorkel extends Zombie {

    public Snorkel(String name) {
        super(name);
    }

    public static Snorkel makeSnorkelZombie(String name) throws IOException {
        YaGson yaGson = new YaGson();
        Snorkel snorkel = new Snorkel(name);
        File file = new File("Zombies\\" + snorkel.getName());
        String string = Card.makeString(file);
        Snorkel snorkel1 = yaGson.fromJson(string, Snorkel.class);
        String d = yaGson.toJson(snorkel);
        zombies.add(snorkel);
        return snorkel;
//        System.out.println(d);
//        System.out.println(zombie1.getSpeed());
    }
}
