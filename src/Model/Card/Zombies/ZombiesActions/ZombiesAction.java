package Model.Card.Zombies.ZombiesActions;

import Model.Card.Action;
import Model.Card.ActionsOfAnEvent;
import Model.Card.Event.*;
import Model.Card.Zombies.Snorkel;
import Model.Card.Zombies.Zombie;

import java.io.IOException;
import java.util.ArrayList;

public class ZombiesAction {
    private static ArrayList<ZombiesAction> zombiesActions = new ArrayList<>();

    public static ArrayList<ZombiesAction> getZombiesActions() {
        return zombiesActions;
    }

//    public static void setZombiesActions() throws IOException {
//        Event onSpawn = new OnSpawn();
//        Event nearestCell = new NearestCell();
//        Event proximityInRadiousDistanceOne = new ProximityInRadiousDistance();
//        Event nearRows = new NearRows();
//
//        Action appearInCell = new AppearInCell();
//        Action jump = new Jump();
//        Action shieldDefend = new ShieldDefend();
//        Action turnToNormalZombie = new TurnToNormalZombie();
//        Action walk = new Walk();
//        Action stealPlant = new StealPlant();
//        Action attack = new Attack();
//
//        ArrayList<Action> actions = new ArrayList<>();
//
//        Zombie zombie = Zombie.makeZombie("Zombie");
//        actions.add(walk);
//        actions.add(attack);
//        zombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        //todo
//        //sadame nadidan ro ham actione zombie begirim?
//        // fek konam too if haye plant bashe behtare
//        Zombie footballZombie = Zombie.makeZombie("FootballZombie");
//        actions.clear();
//        actions.add(walk);
//        actions.add(attack);
//        footballZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        //todo
//        //kolahash ra dar plantsaction asar bedim faqat
//        Zombie bucketheadZombie = Zombie.makeZombie("BucketheadZombie");
//        actions.clear();
//        actions.add(walk);
//        bucketheadZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        Zombie coneheadZombie = Zombie.makeZombie("ConeheadZombie");
//        actions.clear();
//        actions.add(walk);
//        actions.add(attack);
//        coneheadZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        Zombie zomboni = Zombie.makeZombie("Zomboni");
//        actions.clear();
//        actions.add(walk);
//        actions.add(turnToNormalZombie);
//        zomboni.setActionsOfAnEvent(new ActionsOfAnEvent(nearRows, actions) {
//        });
//
//        Zombie catapultZomboni = Zombie.makeZombie("CatapultZomboni");
//        actions.clear();
//        actions.add(walk);
//        catapultZomboni.setActionsOfAnEvent(new ActionsOfAnEvent(nearRows, actions) {
//        });
//
//        Zombie bungeeZombie = Zombie.makeZombie("BungeeZombie");
//        actions.clear();
//        actions.add(walk);
//        actions.add(appearInCell);
//        actions.add(stealPlant);
//        bungeeZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        //todo
//        //way of defend is?
//        Zombie balloonZombie = Zombie.makeZombie("BalloonZombie");
//        actions.clear();
//        actions.add(walk);
//        actions.add(attack);
//        balloonZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        Zombie newspaperZombie = Zombie.makeZombie("NewspaperZombie");
//        actions.clear();
//        actions.add(walk);
//        actions.add(attack);
//        newspaperZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        Zombie targetZombie = Zombie.makeZombie("TargetZombie");
//        actions.clear();
//        actions.add(walk);
//        actions.add(attack);
//        targetZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        Zombie screenDoorZombie = Zombie.makeZombie("ScreenDoorZombie");
//        actions.clear();
//        actions.add(walk);
//        actions.add(attack);
//        screenDoorZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        Zombie gigaGargantuar = Zombie.makeZombie("GigaGargantuar");
//        actions.clear();
//        actions.add(walk);
//        actions.add(attack);
//        gigaGargantuar.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        Zombie pogoZombie = Zombie.makeZombie("PogoZombie");
//        actions.clear();
//        actions.add(walk);
//        actions.add(jump);
//        pogoZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        Snorkel snorkelZombie = Snorkel.makeSnorkelZombie("SnorkelZombie");
//        actions.clear();
//        actions.add(walk);
//        actions.add(attack);
//        snorkelZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//        Snorkel dolphinRiderZombie = Snorkel.makeSnorkelZombie("DolphinRiderZombie");
//        actions.clear();
//        actions.add(walk);
//        actions.add(attack);
//        dolphinRiderZombie.setActionsOfAnEvent(new ActionsOfAnEvent(onSpawn, actions) {
//        });
//
//    }
}
