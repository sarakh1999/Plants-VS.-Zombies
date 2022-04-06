package Model.Card.Plants.PlantsActions;

import Model.Card.Action;
import Model.Card.ActionsOfAnEvent;
import Model.Card.Event.*;
import Model.Card.Plants.Plant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class PlantsAction {

    private static ArrayList<PlantsAction> plantsActions = new ArrayList<>();

//    public static void setPlantsActions() throws IOException {
//
//        Event inTheSameRow = new NearRows();
//        Event OnSpawn = new OnSpawn();
//        Event nearest = new NearestCell();
//        Event proximityInRadiausDistance = new ProximityInRadiousDistance();
//        Event nearRows = new NearRows();
//        Event valid=new Valid();
//
//        Action burst = new Burst();
//        Action produceSun = new ProduceSun();
//        Action shoot = new Shoot();
//        Action magnet = new Magnet();
//
//        ArrayList<Action> actions = new ArrayList<>();
//
//        Plant peaShooter = Plant.makePlant("PeaShooter");
//        actions.add(shoot);
//        peaShooter.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        Plant snowPea = Plant.makePlant("SnowPea");
//        actions.clear();
//        actions.add(shoot);
//        snowPea.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        Plant cabbagePult = Plant.makePlant("CabbagePult");
//        actions.clear();
//        actions.add(shoot);
//        cabbagePult.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        Plant repeater = Plant.makePlant("Repeater");
//        actions.clear();
//        actions.add(shoot);
//        repeater.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        Plant threepeater = Plant.makePlant("Threepeater");
//        actions.clear();
//        actions.add(shoot);
//        threepeater.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        Plant cactus = Plant.makePlant("Cactus");
//        actions.clear();
//        actions.add(shoot);
//        cactus.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant gatlingPea = Plant.makePlant("GatlingPea");
//        actions.clear();
//        actions.add(shoot);
//        gatlingPea.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant scaredyShroom = Plant.makePlant("ScaredyShroom");
//        actions.clear();
//        actions.add(shoot);
//        scaredyShroom.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant kernelPult = Plant.makePlant("KernelPult");
//        actions.clear();
//        actions.add(shoot);
//        kernelPult.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant explodeONut = Plant.makePlant("ExplodeONut");
//        actions.clear();
//        actions.add(shoot);
//        explodeONut.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        Plant melonPult = Plant.makePlant("MelonPult");
//        actions.clear();
//        actions.add(shoot);
//        melonPult.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant lilyPad = Plant.makePlant("LilyPad");
//        actions.clear();
//        lilyPad.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        Plant winterMelon = Plant.makePlant("WinterMelon");
//        actions.clear();
//        actions.add(shoot);
//        winterMelon.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        //todo
//        //do jahate mokhtalef shelliko chert mige
//        Plant splitPea = Plant.makePlant("SplitPea");
//        actions.clear();
//        actions.add(shoot);
//        splitPea.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//
//        //todo
//        //what does wallNut do
//        Plant wallNut = Plant.makePlant("WallNut");
//        actions.clear();
//        //wallNut.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        //});
//
//        Plant tangleKelp = Plant.makePlant("TangleKelp");
//        actions.clear();
//        actions.add(shoot);
//        tangleKelp.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//        //todo
//        //what does wallNut do
//        Plant tallNut = Plant.makePlant("TallNut");
//        actions.clear();
////        tallNut.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
////        });
//
//        //todo
//        //qaction is killNearest
//        Plant cattail = Plant.makePlant("Cattail");
//        actions.clear();
//        actions.add(shoot);
//        cattail.setActionsOfAnEvent(new ActionsOfAnEvent(nearest, actions) {
//        });
//
//        //todo
//        //check the event of avvalin zombie ee ke behesh mirese
//        Plant potatoMine = Plant.makePlant("PotatoMine");
//        actions.clear();
//        actions.add(burst);
//        potatoMine.setActionsOfAnEvent(new ActionsOfAnEvent(OnSpawn, actions) {
//        });
//
//
//        Plant cherryBomb = Plant.makePlant("CherryBomb");
//        actions.clear();
//        actions.add(burst);
//        cherryBomb.setActionsOfAnEvent(new ActionsOfAnEvent(valid, actions) {
//        });
//
//        Plant magnetShroom = Plant.makePlant("magnet-shroom");
//        actions.clear();
//        actions.add(magnet);
//        magnetShroom.setActionsOfAnEvent(new ActionsOfAnEvent(proximityInRadiausDistance, actions) {
//        });
//
//        Plant sunFlower = Plant.makePlant("SunFlower");
//        actions.clear();
//        actions.add(produceSun);
//        sunFlower.setActionsOfAnEvent(new ActionsOfAnEvent(valid, actions) {
//        });
//
//        Plant twinSunFlower = Plant.makePlant("TwinSunFlower");
//        actions.clear();
//        actions.add(produceSun);
//        twinSunFlower.setActionsOfAnEvent(new ActionsOfAnEvent(valid, actions) {
//        });
//
//        Plant jalapeno = Plant.makePlant("Jalapeno");
//        actions.clear();
//        actions.add(burst);
//        jalapeno.setActionsOfAnEvent(new ActionsOfAnEvent(valid, actions) {
//        });
//
//    }

    public static ArrayList<PlantsAction> getPlantsActions() {
        return plantsActions;
    }
}
