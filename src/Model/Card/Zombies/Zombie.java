package Model.Card.Zombies;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.ActionsOfAnEvent;
import Model.Card.Card;
import Model.Card.Event.*;
import Model.Card.Zombies.ZombiesActions.*;
import com.gilecode.yagson.YaGson;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Zombie extends Card {

    private int armour;//if nothing...it is 0
    private int health;
    private int speed;
    private boolean pea;
    private int freezeTurns =0;
    private boolean IronHat;
    private ArrayList<ActionsOfAnEvent> actionsOfAnEvent = new ArrayList<>();
    private ArrayList<Action> actionsOfAnEvent1 = new ArrayList<>();
    public Zombie() {
        if(this.getName().equals("BucketheadZombie")){
            this.IronHat=true;
        }
    }

    public static Zombie makeZombie(String name) throws IOException {
        YaGson yaGson = new YaGson();
        Zombie zombie = new Zombie(name);
        File file = new File("Zombies\\" + zombie.getName());
        String string = Card.makeString(file);
        Zombie zombie1 = yaGson.fromJson(string, Zombie.class);
        String d = yaGson.toJson(zombie1);
        boolean q = false;
        for (Zombie z: zombies)
            if (z.getName().equalsIgnoreCase(zombie1.getName()))
                q = true;
        if (!q)
            zombies.add(zombie1);
        zombie1.setPrice();

        zombie1.actionsOfAnEvent1 = new ArrayList<>();
        zombie1.actionsOfAnEvent = new ArrayList<>();

        Event OnSpawn = new OnSpawn();
        Event nearestCell = new NearestCell();
        Event proximityInRadiousDistanceOne = new ProximityInRadiusDistance();
        Event nearRows = new NearRows();
        Event valid = new Valid();

        Action appearInCell = new AppearInCell();
        Action jump = new Jump();
        Action turnToNormalZombie = new TurnToNormalZombie();
        Action walk = new Walk();
        Action stealPlant = new StealPlant();
        Action attack = new Attack();

        if (zombie1.getName().equalsIgnoreCase("zombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(attack);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("FootballZombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(attack);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("BucketheadZombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("ConeheadZombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(attack);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("Zomboni")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(turnToNormalZombie);
            zombie1.actionsOfAnEvent1.add(stealPlant);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(valid, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("CatapultZomboni")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(stealPlant);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(valid, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("BungeeZombie")) {
            zombie1.actionsOfAnEvent1.add(appearInCell);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(valid, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("BalloonZombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(attack);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("NewspaperZombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
            //todo
            //zombie1.actionsOfAnEvent1.add(attack);
            zombie1.actionsOfAnEvent1.add(stealPlant);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("TargetZombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(attack);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("ScreenDoorZombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(attack);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("GigaGargantuar")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(attack);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("PogoZombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(jump);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("SnorkelZombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
            zombie1.actionsOfAnEvent1.add(attack);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }
        if (zombie1.getName().equalsIgnoreCase("DolphinRiderZombie")) {
            zombie1.actionsOfAnEvent1.add(walk);
           // zombie1.actionsOfAnEvent1.add(attack);
            zombie1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, zombie1.actionsOfAnEvent1) {
            });
        }

        return zombie1;

//        System.out.println(d);
//        System.out.println(zombie1.getSpeed());
    }

    public static Zombie findZombie(String name) {
        for (Zombie x : zombies)
            if (x.name.equalsIgnoreCase(name))
                return x;
        return null;
    }

    public Zombie(String name) {
        this.name = name;
        this.id = uniqueId;
        uniqueId++;
    }

    public ArrayList<ActionsOfAnEvent> getActionsOfAnEvent() {
        return actionsOfAnEvent;
    }

    public void setActionsOfAnEvent(ActionsOfAnEvent actionsOfAnEvent) {
        this.actionsOfAnEvent.add(actionsOfAnEvent);
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed += speed;
    }

    public int getArmour() {
        return armour;
    }

    public boolean isPea() {
        return pea;
    }

    public int getFreezeTurns() {
        return freezeTurns;
    }

    public void setFreezeTurns(int freezeTurns) {
        this.freezeTurns += freezeTurns;
    }

    public void setArmour(int armour) {
        this.armour += armour;
    }

    public boolean showIronHat() {
        return IronHat;
    }

    public void setIronHat(boolean ironHat) {
        IronHat = ironHat;
    }

    public void act(Battle battle, Pane root) {
        for (ActionsOfAnEvent e : this.actionsOfAnEvent){
            int d = 0;//bayad taeen she be ezaye har plant vali
            if (e.getEvent().check(this, battle, d)) {//age shart barqarar bood
                for (Action action : e.getActions()) {
                    try {
                        action.doAction(this, battle, d, root );//action o anjam bede
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void setPrice(){
        this.price=(1+this.getSpeed())*this.getHP()*10;
    }
}
