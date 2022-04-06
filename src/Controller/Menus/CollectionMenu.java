package Controller.Menus;

import Controller.GameMode.Day;
import Controller.GameMode.GameMode;
import javafx.scene.Scene;
import Model.Card.Plants.Plant;
import Model.Player.Player;
import Model.Player.Profile;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Model.Shop.Collection;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CollectionMenu extends Menu implements Initializable {
    public boolean zombieMode;
    public boolean pvp = false;
    public boolean water;
    public static ArrayList<ImageView> imageViews = new ArrayList<>();

    public Button back;
    public Button play;
    public ImageView SunFlower;
    public ImageView PeaShooter;
    public ImageView Cattail;
    public ImageView Jalapeno;
    public ImageView SnowPea;
    public ImageView CherryBomb;
    public ImageView ExplodeONut;
    public ImageView PotatoMine;
    public ImageView CabbagePult;
    public ImageView TangleKelp;
    public ImageView WinterMelon;
    public ImageView Kernelpult;
    public ImageView ThreePeater;
    public ImageView SplitPea;
    public ImageView TwinSunFlower;
    public ImageView WallNut;
    public ImageView Cactus;
    public ImageView GatlingPea;
    public ImageView MelonPult;
    public ImageView Repeater;
    public ImageView MagnetShroom;
    public ImageView LilyPad;

    public CollectionMenu() {
        this.orders = new String[]{"Show hand", "Show collection", "Select", "Remove", "Play", "Help", "Exit"};
        this.pvp = false;
    }

    private Collection collection = new Collection();

//    public void showHand() {
//        // in bayad bar asas gamemode chap kone
//
//        ArrayList<Plant> p = this.collection.getPlants();
//        if (!zombieMode) {
//            for (Plant x : p) {
//                System.out.println(x.getName());
//
//            }
//        }
//    }

//    public void showCollection(Profile profile) {
//        if (!zombieMode) {
//            for (String p : profile.getPurchasedPlants()) {
//                if (!collection.getPlants().contains(p))
//                    System.out.println(p);
//            }
//        }
//    }


    public void selectCollection(String name, Profile profile) {
        Plant p = Plant.findPlant(name);
        if (collection.getPlants().size() == 7)
            System.out.println("your collection is full");
        else if (p != null) {
//                System.out.println(name);
            if (profile.havePlant(name)) {
//                    System.out.println("2");
                if (!collection.getPlants().contains(p)) {
                    collection.addPlant(p);
//                        System.out.println("3d");
                }
            }
        }
    }

    public void removeCard(String name) {
        collection.removeZombie(name);
        collection.removePlant(name);
    }

    public void play(Player player1, Player player2) throws IOException {
        if (!pvp) {
            player1.setCollection(collection);
            if (!zombieMode) {
                if (water) {
                    Menu.menuHandler.setCurrentMenu(Menu.waterModeMenu);
                    waterModeMenu.player1 = player1;
                    waterModeMenu.player2 = player2;
                    waterModeMenu.battle.setPlayer(player1, 1);
                    waterModeMenu.battle.setPlayer(player2, 2);
                    waterModeMenu.battle.setMap(GameMode.generateMap(waterModeMenu.waterMode));
                    waterModeMenu.player1.setSun(2);
                } else {
                    Menu.menuHandler.setCurrentMenu(Menu.dayModeMenu);
                    dayModeMenu.player1 = player1;
                    dayModeMenu.player2 = player2;
                    dayModeMenu.battle.setPlayer(player1, 1);
                    dayModeMenu.battle.setPlayer(player2, 2);
                    dayModeMenu.battle.setMap(GameMode.generateMap(dayModeMenu.day));
                    dayModeMenu.player1.setSun(2);
                }
            } else {
                Menu.menuHandler.setCurrentMenu(Menu.zombieMenu);
                zombieMenu.player2 = player2;
                zombieMenu.player1 = player1;
                zombieMenu.secondStart();
                zombieMenu.battle.setMap(GameMode.generateMap(zombieMenu.zombieGameMode));
            }
        } else {
            if (player1.getPlants().size() == 0)
                player1.setCollection(collection);
            else {
                player2.setCollection(collection);
                Menu.menuHandler.setCurrentMenu(Menu.pvPMenu);
            }
        }
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.playMenu);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SunFlower.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    selectCollection("sunflower", Menu.profile);
                } catch (Exception e) {
                }
            }
        });
        SunFlower.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("Sunflower" );
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(SunFlower, tooltip);
            }
        });
        PeaShooter.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("peashooter"));
                } catch (Exception e) {
                }
            }
        });
        PeaShooter.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("PeaShooter");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(PeaShooter, tooltip);
            }
        });
        Cattail.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("Cattail"));
                } catch (Exception e) {
                }
            }
        });
        Cattail.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("Cattail");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(Cattail, tooltip);
            }
        });
        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
            Image image;

            @Override
            public void handle(MouseEvent event) {
                try {
                    for (int i = 0; i < collection.getPlants().size(); i++) {
                        String name = collection.getPlants().get(i).getName();
                        String path = "src/CardImages/" + name + ".png";
                        image = new Image(new FileInputStream(path));
                        ImageView imageView = new ImageView(image);
                        //todo
                        //todo
                        imageViews.add(imageView);
                        imageViews.get(i).setX(96 + (i + 1) * 78);
                        imageViews.get(i).setY(9.5);
                        imageViews.get(i).setFitWidth(50);
                        imageViews.get(i).setFitHeight(60);
                        player1.setCollection(collection);
                        Menu.menuHandler.setCurrentMenu(Menu.dayModeMenu);
                        dayModeMenu.battle.setPlayer(player1, 1);
                        dayModeMenu.battle.setPlayer(player2, 2);
                        dayModeMenu.battle.setMap(GameMode.generateMap(dayModeMenu.day));
                        Menu.player1.setSun(2);
                        Menu.dayModeMenu.battle.setMap(GameMode.generateMap(new Day()));
                        System.out.println(imageViews.size());
                    }
                    Pane root = FXMLLoader.load(getClass().getResource("../GameMode/DayModeGround.fxml"));
//                    DayModeMenu.root = new Pane();
                    DayModeMenu.root = root;
                    for (int i = 0; i < imageViews.size(); i++) {
                        root.getChildren().add(imageViews.get(i));
                    }
                    Menu.primaryStage.setScene(new Scene(DayModeMenu.root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (Plant p : collection.getPlants()) {
                    System.out.println(p.getName());
                }
            }
        });
        Jalapeno.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("Jalapeno"));
                } catch (Exception e) {
                }
            }
        });
        Jalapeno.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Tooltip tooltip = new Tooltip("Jalapeno");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(Jalapeno, tooltip);
            }
        });
        SnowPea.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("SnowPea"));
                } catch (Exception e) {
                }
            }
        });
        SnowPea.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("SnowPea");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(SnowPea, tooltip);
            }
        });
        CherryBomb.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("CherryBomb"));
                } catch (Exception e) {
                }
            }
        });
        CherryBomb.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("CherryBomb");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(CherryBomb, tooltip);
            }
        });
        ExplodeONut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("ExplodeONut"));
                } catch (Exception e) {
                }
            }
        });
        ExplodeONut.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("ExplodeONut");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(ExplodeONut, tooltip);
            }
        });
        PotatoMine.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("PotatoMine"));
                } catch (Exception e) {
                }
            }
        });
        PotatoMine.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("PotatoMine");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(PotatoMine, tooltip);
            }
        });
        CabbagePult.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("CabbagePult"));
                } catch (Exception e) {
                }
            }
        });
        CabbagePult.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("CabbagePult");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(CabbagePult, tooltip);
            }
        });
        TangleKelp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("TangleKelp"));
                } catch (Exception e) {
                }
            }
        });
        TangleKelp.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("TangleKelp");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(TangleKelp, tooltip);
            }
        });
        WinterMelon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("WinterMelon"));
                } catch (Exception e) {
                }
            }
        });
        WinterMelon.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("WinterMelon");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(WinterMelon, tooltip);
            }
        });
        Kernelpult.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("Kernelpult"));
                } catch (Exception e) {
                }
            }
        });
        Kernelpult.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("Kernelpult");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(Kernelpult, tooltip);
            }
        });
        ThreePeater.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("ThreePeater"));
                } catch (Exception e) {
                }
            }
        });
        ThreePeater.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("ThreePeater");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(ThreePeater, tooltip);
            }
        });
        SplitPea.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("SplitPea"));
                } catch (Exception e) {
                }
            }
        });
        SplitPea.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("SplitPea");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(SplitPea, tooltip);
            }
        });
        TwinSunFlower.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("TwinSunFlower"));
                } catch (Exception e) {
                }
            }
        });
        TwinSunFlower.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("TwinSunFlower");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(TwinSunFlower, tooltip);
            }
        });
        WallNut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("WallNut"));
                } catch (Exception e) {
                }
            }
        });
        WallNut.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("WallNut");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(WallNut, tooltip);
            }
        });
        Cactus.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("Cactus"));
                } catch (Exception e) {
                }
            }
        });
        Cactus.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("Cactus");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(Cactus, tooltip);
            }
        });
        GatlingPea.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("GatlingPea"));
                } catch (Exception e) {
                }
            }
        });
        GatlingPea.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("GatlingPea");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(GatlingPea, tooltip);
            }
        });
        MelonPult.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("MelonPult"));
                } catch (Exception e) {
                }
            }
        });
        MelonPult.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("MelonPult");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(MelonPult, tooltip);
            }
        });
        Repeater.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("Repeater"));
                } catch (Exception e) {
                }
            }
        });
        Repeater.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("Repeater");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(Repeater, tooltip);
            }
        });
        MagnetShroom.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("MagnetShroom"));
                } catch (Exception e) {
                }
            }
        });
        MagnetShroom.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("MagnetShroom");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(MagnetShroom, tooltip);
            }
        });
        LilyPad.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    collection.addPlant(Plant.makePlant("LilyPad"));
                } catch (Exception e) {
                }
            }
        });
        LilyPad.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Tooltip tooltip = new Tooltip("LilyPad");
                tooltip.setX(mouseEvent.getX());
                tooltip.setY(mouseEvent.getY());
                Tooltip.install(LilyPad, tooltip);
            }
        });
        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("PlayMenu.fxml")));
                    Menu.primaryStage.setScene(new Scene(root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}