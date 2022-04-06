package Controller.Menus;

import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Player;
import Model.Player.Profile;
import com.gilecode.yagson.YaGson;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Menu {
    public static LoginMenu loginMenu = new LoginMenu();
    public static CollectionMenu collectionMenu = new CollectionMenu();
    public static PlayMenu playMenu;
    public static Stage primaryStage = new Stage();
    public static Profile profile;
    public static Player player1;
    public static Player player2;
    public static Pane root = new Pane();

    static {
        try {
            playMenu = new PlayMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LeaderBoard leaderBoard = new LeaderBoard();
    public static MainMenu mainMenu;

    static {
        try {
            mainMenu = new MainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ProfileMenu profileMenu = new ProfileMenu();
    public static ShopMenu shopMenu = new ShopMenu();
    public static MenuHandler menuHandler = new MenuHandler();
    public static DayModeMenu dayModeMenu = new DayModeMenu();
    public static RailMenu railMenu = new RailMenu();
    public static WaterModeMenu waterModeMenu = new WaterModeMenu();
    public static ZombieMenu zombieMenu = new ZombieMenu();
    public static PvPMenu pvPMenu = new PvPMenu();
    public static HelpMenu helpMenu = new HelpMenu();

    protected static void saveAccount() throws IOException {
        ArrayList<Profile> accounts = Profile.getAccounts();
        String json = new YaGson().toJson(accounts);
        FileWriter writer = new FileWriter("Accounts\\accounts");
        writer.write(json);
        writer.close();
    }

    public String[] getOrders() {
        return orders;
    }

    protected String[] orders;

    public static void help() throws IOException {
        int i=0;
        for (String x : menuHandler.getCurrentMenu().getOrders()) {
            if(i<helpMenu.labels.size() && !x.equalsIgnoreCase("help")) {
                helpMenu.labels.get(i).setText(x);
                i++;
            }
        }
        for(Label l:helpMenu.labels){
            System.out.println(l.getText());
        }
    }

    public static void init() throws IOException {
        menuHandler.setCurrentMenu(loginMenu);
        YaGson yaGson = new YaGson();
        File file = new File("Accounts//accounts");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string = new String();
        String s = new String();
        while (true) {
            s = br.readLine();
            if (s != null)
                string += (s);
            else
                break;
        }
        ArrayList<Profile> profiles = yaGson.fromJson(string, ArrayList.class);
        Profile.setProfiles(profiles);

        String[] plants = new String[]{"CabbagePult", "Cactus", "Cattail", "CherryBomb", "ExplodeONut", "GatlingPea", "KernelPult", "LilyPad", "Jalapeno", "MagnetShroom", "MelonPult", "PeaShooter", "PotatoMine", "Repeater", "ScaredyShroom", "SnowPea", "SplitPea", "SunFlower", "TallNut", "TangleKelp", "ThreePeater", "TwinSunFlower", "WallNut", "WinterMelon"};
        String[] zombies = new String[]{"BalloonZombie",
                "BucketheadZombie",
                "BungeeZombie",
                "CatapultZomboni",
                "ConeheadZombie",
                "DolphinRiderZombie",
                "FootballZombie",
                "GigaGargantuar",
                "NewspaperZombie", "PogoZombie", "ScreenDoorZombie", "SnorkelZombie", "TargetZombie", "Zombie", "Zomboni"};
        for (String x : plants) {
            Plant p = new Plant(x);
            p = Plant.makePlant(x);
        }
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
//        snowPea.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant cabbagePult = Plant.makePlant("CabbagePult");
//        actions.clear();
//        actions.add(shoot);
//        cabbagePult.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant repeater = Plant.makePlant("Repeater");
//        actions.clear();
//        actions.add(shoot);
//        repeater.setActionsOfAnEvent(new ActionsOfAnEvent(inTheSameRow, actions) {
//        });
//
//        Plant threepeater = Plant.makePlant("Threepeater");
//        actions.clear();
//        actions.add(shoot);
//        threepeater.setActionsOfAnEvent(new ActionsOfAnEvent(nearRows, actions) {
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
//        Plant kernelPult = Plant.makePlant("KernelPult)");
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

        for (String x : zombies)
            Zombie.makeZombie(x);
    }
}