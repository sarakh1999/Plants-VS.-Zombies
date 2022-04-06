package Model.Card.Plants;

import Controller.GameMode.Battle;
import Model.Card.Action;
import Model.Card.ActionsOfAnEvent;
import Model.Card.Card;
import Model.Card.Event.*;
import Model.Card.Plants.PlantsActions.*;
import com.gilecode.yagson.YaGson;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Plant extends Card {

    private int sun;
    private int cooldown;
    private int loading;
    private int ProducedSun;
    private int speedReduction;
    private int SpeedReduction;
    public boolean pea;
    private ArrayList<ActionsOfAnEvent> actionsOfAnEvent;
    private ArrayList<Action> actionsOfAnEvent1 = new ArrayList<>();
    //zombie ra chand turn negah dare
    private int freeze;
    private int Turn;
    private int finalTurn = 0;
    private int peaAmount;

    public void setActionsOfAnEvent(ActionsOfAnEvent actionsOfAnEvent) {
        this.actionsOfAnEvent.add(actionsOfAnEvent);
    }

    public static Plant makePlant(String name) throws IOException {
        YaGson yaGson = new YaGson();
        Plant plant = new Plant(name);
        File file = new File("Plants\\" + plant.getName());
        String string = Card.makeString(file);
        Plant plant1 = yaGson.fromJson(string, Plant.class);
        String d = yaGson.toJson(plant1);
        boolean q = false;
        for (Plant p : plants)
            if (p.getName().equalsIgnoreCase(plant1.getName()))
                q = true;
        if (!q)
            plants.add(plant1);
        plant1.setPrice();
        plant1.actionsOfAnEvent1 = new ArrayList<>();
        plant1.actionsOfAnEvent = new ArrayList<>();
        //plant1.setTurn(0);


        Event inTheSameRow = new NearRows();
        Event OnSpawn = new OnSpawn();
        Event nearest = new NearestCell();
        Event proximityInRadiausDistance = new ProximityInRadiusDistance();
        Event nearRows = new NearRows();
        Event valid = new Valid();

        Action burst = new Burst();
        Action killNearest = new KillNearest();
        Action produceSun = new ProduceSun();
        Action shoot = new Shoot();
        Action magnet = new Magnet();

        if (plant1.getName().equalsIgnoreCase("peashooter")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, plant1.actionsOfAnEvent1) {
            });
          //  plant1.setImageView("C:\\Users\\asus\\IdeaProjects\\AP-07\\AP-07-1\\src\\CollectionGifsAndImages\\PeaShooter.gif");
        }
        if (plant1.getName().equalsIgnoreCase("SnowPea")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, plant1.actionsOfAnEvent1) {
            });
          //  plant1.setImageView("C:\\Users\\asus\\IdeaProjects\\AP-07\\AP-07-1\\src\\CollectionGifsAndImages\\SnowPea.gif");
        }
        if (plant1.getName().equalsIgnoreCase("CabbagePult")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("Repeater")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("Threepeater")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("Cactus")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("GatlingPea")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("ScaredyShroom")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("KernelPult")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("ExplodeONut")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("MelonPult")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("LilyPad")) {
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("WinterMelon")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("SplitPea")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("WallNut")) {
            //plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(valid, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("TangleKelp")) {
            plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("TallNut")) {
            //plant1.actionsOfAnEvent1.add(shoot);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(valid, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("Cattail")) {
            plant1.actionsOfAnEvent1.add(killNearest);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(nearest, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("PotatoMine")) {
            plant1.actionsOfAnEvent1.add(burst);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("CherryBomb")) {
            plant1.actionsOfAnEvent1.add(burst);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(valid, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("magnetShroom")) {
            plant1.actionsOfAnEvent1.add(magnet);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(proximityInRadiausDistance, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("sunflower")) {
            plant1.actionsOfAnEvent1.add(produceSun);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(valid, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("TwinSunFlower")) {
            plant1.actionsOfAnEvent1.add(produceSun);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(valid, plant1.actionsOfAnEvent1) {
            });
        }
        if (plant1.getName().equalsIgnoreCase("Jalapeno")) {
            plant1.actionsOfAnEvent1.add(burst);
            plant1.setActionsOfAnEvent(new ActionsOfAnEvent(valid, plant1.actionsOfAnEvent1) {
            });
        }
        return plant1;
//        System.out.println(d);
//        System.out.println(plant1.getSun());
    }

    public static void makePlantsImages(String name){
        String path= "CollectionGifsAndImages" +"/"+"PeaShooter"+".gif";

    }


    public static Plant findPlant(String name) {
        for (Plant plant : plants) {
            if (plant.name.equalsIgnoreCase(name))
                return plant;
        }
        return null;
    }

    public Plant(String name) {
        super();
        this.name = name;
        this.id = uniqueId;
        uniqueId++;
        this.loading = 0;

    }

    public void act(Battle battle, Pane root) {
        this.actionsOfAnEvent.forEach(e -> {
            int d = 0;//bayad taeen she be ezaye har plant vali
            if (e.getEvent().check(this, battle, d)) {//age shart barqharar bood
                System.out.println("plant check");
                for (Action action : e.getActions()) {
                    action.doAction(this, battle, d, root );//action o anjam bede
                }
            }
        });
    }

    public int getSpeedReduction() {
        return speedReduction;
    }

    public void setSpeedReduction(int speedReduction) {
        this.speedReduction = speedReduction;
    }

    public int getProducedSun() {
        return ProducedSun;
    }

    public void setProducedSun(int producedSun) {
        ProducedSun = producedSun;
    }

    public ArrayList<ActionsOfAnEvent> getActionsOfAnEvent() {
        return actionsOfAnEvent;
    }

    private ArrayList<PlantsAction> plantsActions;

    public int getTurn() {
        return Turn;
    }

    public void setTurn(int turn) {
        this.Turn += turn;
    }

    public void addToPlantsActions(PlantsAction action) {
        plantsActions.add(action);
    }

    public ArrayList<PlantsAction> getPlantsActions() {
        return plantsActions;
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getFreeze() {
        return freeze;
    }


    public int getLoading() {
        return loading;
    }

    public void setLoading(int loading) {
        this.loading = loading;
    }

    @Override
    public void setPrice() {
        this.price = this.sun * this.cooldown * this.getHP() + 1;
    }

    public int getPeaAmount() {
        return this.peaAmount;
    }
}