package Controller.Menus;

import Model.Card.Card;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Player.Profile;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShopMenu extends Menu implements Initializable {

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
    public Label buyLabel;
    public Label playerCoins;
    public Button help;
    public Button back;


    public ShopMenu() {
        this.orders = new String[]{"Show shop", "Show collection", "Buy", "Money", "Help", "Exit"};
    }

    public void showShop(Profile profile) {
        ArrayList<Plant> plants = Card.getPlants();
        System.out.println("Plants");
        System.out.println("----------------------");
        for (Plant x : plants)
            if (!profile.getPurchasedPlants().contains(x))
                System.out.println(x.getName() + "\t" + x.getPrice());
        System.out.println("----------------------");
        System.out.println("Zombies");
        System.out.println("----------------------");
        for (Zombie x : Card.getZombies())
            if (!profile.getPurchasedZombies().contains(x))
                System.out.println(x.getName() + "\t" + x.getPrice());
        System.out.println("----------------------");
    }

    public void getCards(Profile profile) {
        for (String x : profile.getPurchasedPlants())
            System.out.println(x);
        for (String x : profile.getPurchasedZombies())
            System.out.println(x);
    }

    public boolean buy(String name, Profile profile, Pane root) throws IOException {
        System.out.println(Menu.profile.getExternalCoins());
        System.out.println("buy");
        Zombie z = Zombie.findZombie(name);
        Plant p = Plant.findPlant(name);
        if (z != null && !profile.getPurchasedZombies().contains(z.getName()) && z.getPrice() <= profile.getExternalCoins()) {
            System.out.println("kharid");
            buyLabel.setText("Kharid :)");
            profile.addZombie(z);
            profile.setExternalCoins(-z.getPrice());
            playerCoins.setText(Integer.toString(profile.getExternalCoins()));
            return true;
        } else if (p != null && !profile.getPurchasedPlants().contains(p.getName()) && p.getPrice() <= profile.getExternalCoins()) {
            System.out.println("kharid");
            buyLabel.setText("Kharid :)");
            profile.setExternalCoins(-p.getPrice());
            profile.addPlant(p);
            System.out.println(Menu.profile.getExternalCoins());
            playerCoins.setText(Integer.toString(profile.getExternalCoins()));
            return true;
        } else {
            System.out.println("nakharid");
            buyLabel.setText("Nakharid :(");
            playerCoins.setText(Integer.toString(profile.getExternalCoins()));
            return false;
        }

    }

    public void Exit() {
        Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
        Parent root = null;
        try {
            root = (FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Menu.primaryStage.setScene(new Scene(root));
        Menu.primaryStage.show();
        Menu.primaryStage.setTitle("PvZ");
    }

    public void showMoney(Profile profile) {
        System.out.println(profile.getExternalCoins());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        back.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Exit();

            }
        });

        help.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Parent root = (FXMLLoader.load(getClass().getResource("HelpMenu.fxml")));
                    Menu.help();
                    Menu.primaryStage.setScene(new Scene(root));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            SunFlower.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("SunFlower")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(SunFlower, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("SunFlower" + Plant.findPlant("sunflower").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(SunFlower, tooltip);
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        SunFlower.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("sunflower", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });

        try {
            PeaShooter.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("PeaShooter")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(PeaShooter, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("PeaShooter" + Plant.findPlant("PeaShooter").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(PeaShooter, tooltip);
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        PeaShooter.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("PeaShooter", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });

        try {
            Cattail.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("Cattail")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(Cattail, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("Cattail" + Plant.findPlant("Cattail").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(Cattail, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cattail.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("Cattail", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            Jalapeno.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("Jalapeno")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(Jalapeno, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("Jalapeno" + Plant.findPlant("Jalapeno").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(Jalapeno, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Jalapeno.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("Jalapeno", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            SnowPea.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("SnowPea")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(SnowPea, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("SnowPea" + Plant.findPlant("SnowPea").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(SnowPea, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        SnowPea.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("SnowPea", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {

            CherryBomb.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("CherryBomb")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(CherryBomb, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("CherryBomb" + Plant.findPlant("CherryBomb").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(CherryBomb, tooltip);
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        CherryBomb.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("CherryBomb", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            ExplodeONut.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("ExplodeONut")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(ExplodeONut, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("ExplodeONut" + Plant.findPlant("ExplodeONut").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(ExplodeONut, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExplodeONut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("ExplodeONut", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            PotatoMine.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("PotatoMine")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(PotatoMine, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("PotatoMine" + Plant.findPlant("PotatoMine").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(PotatoMine, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        PotatoMine.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("PotatoMine", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            CabbagePult.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("CabbagePult")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(CabbagePult, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("CabbagePult" + Plant.findPlant("CabbagePult").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(CabbagePult, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        CabbagePult.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("CabbagePult", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            TangleKelp.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("TangleKelp")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(TangleKelp, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("TangleKelp" + Plant.findPlant("TangleKelp").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(TangleKelp, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        TangleKelp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("TangleKelp", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            WinterMelon.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("WinterMelon")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(WinterMelon, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("WinterMelon" + Plant.findPlant("WinterMelon").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(WinterMelon, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        WinterMelon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("WinterMelon", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            Kernelpult.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("Kernelpult")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(Kernelpult, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("Kernelpult" + Plant.findPlant("Kernelpult").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(Kernelpult, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Kernelpult.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("Kernelpult", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            ThreePeater.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("ThreePeater")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(ThreePeater, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("ThreePeater" + Plant.findPlant("ThreePeater").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(ThreePeater, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        ThreePeater.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("ThreePeater", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });

        try {
            SplitPea.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("SplitPea")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(SplitPea, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("SplitPea" + Plant.findPlant("SplitPea").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(SplitPea, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        SplitPea.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("SplitPea", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            TwinSunFlower.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (Menu.profile.getPurchasedPlants().contains("TwinSunFlower")) {
                        Tooltip tooltip = new Tooltip("kharidish qablan:)");
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(TwinSunFlower, tooltip);
                    } else {
                        Tooltip tooltip = new Tooltip("TwinSunFlower" + Plant.findPlant("TwinSunFlower").getPrice());
                        tooltip.setX(mouseEvent.getX());
                        tooltip.setY(mouseEvent.getY());
                        Tooltip.install(TwinSunFlower, tooltip);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        TwinSunFlower.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("TwinSunFlower", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        WallNut.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (Menu.profile.getPurchasedPlants().contains("WallNut")) {
                    Tooltip tooltip = new Tooltip("kharidish qablan:)");
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(WallNut, tooltip);
                } else {
                    Tooltip tooltip = new Tooltip("WallNut" + Plant.findPlant("WallNut").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(WallNut, tooltip);
                }
            }
        });

        WallNut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("WallNut", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            Cactus.setOnMouseEntered(mouseEvent -> {
                if (Menu.profile.getPurchasedPlants().contains("Cactus")) {
                    Tooltip tooltip = new Tooltip("kharidish qablan:)");
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(Cactus, tooltip);
                } else {
                    Tooltip tooltip = new Tooltip("Cactus" + Plant.findPlant("Cactus").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(Cactus, tooltip);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cactus.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("Cactus", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            GatlingPea.setOnMouseEntered(mouseEvent -> {
                if (Menu.profile.getPurchasedPlants().contains("GatlingPea")) {
                    Tooltip tooltip = new Tooltip("kharidish qablan:)");
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(GatlingPea, tooltip);
                } else {
                    Tooltip tooltip = new Tooltip("GatlingPea" + Plant.findPlant("GatlingPea").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(GatlingPea, tooltip);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        GatlingPea.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("GatlingPea", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            MelonPult.setOnMouseEntered(mouseEvent -> {
                if (Menu.profile.getPurchasedPlants().contains("MelonPult")) {
                    Tooltip tooltip = new Tooltip("kharidish qablan:)");
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(MelonPult, tooltip);
                } else {
                    Tooltip tooltip = new Tooltip("MelonPult" + Plant.findPlant("MelonPult").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(MelonPult, tooltip);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        MelonPult.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("MelonPult", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });
        try {
            Repeater.setOnMouseEntered(mouseEvent -> {
                if (Menu.profile.getPurchasedPlants().contains("Reapeter")) {
                    Tooltip tooltip = new Tooltip("kharidish qablan:)");
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(Repeater, tooltip);
                } else {
                    Tooltip tooltip = new Tooltip("Repeater" + Plant.findPlant("Repeater").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(Repeater, tooltip);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Repeater.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("Repeater", profile, DayModeMenu.root);
                } catch (Exception e) {
                }
            }
        });

        try {
            MagnetShroom.setOnMouseEntered(mouseEvent -> {
                if (Menu.profile.getPurchasedPlants().contains("MagnetShroom")) {
                    Tooltip tooltip = new Tooltip("kharidish qablan:)");
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(MagnetShroom, tooltip);
                } else {
                    Tooltip tooltip = new Tooltip("MagnetShroom" + Plant.findPlant("MagnetShroom").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(MagnetShroom, tooltip);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        MagnetShroom.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("MagnetShroom", Menu.profile, DayModeMenu.root);
                    Menu.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../Model/Shop/ShopMenu.fxml"))));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (Exception e) {
                }
            }
        });
        try {
            LilyPad.setOnMouseEntered(mouseEvent -> {
                if (Menu.profile.getPurchasedPlants().contains("LilyPad")) {
                    Tooltip tooltip = new Tooltip("kharidish qablan:)");
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(LilyPad, tooltip);
                } else {
                    Tooltip tooltip = new Tooltip("LilyPad" + Plant.findPlant("LilyPad").getPrice());
                    tooltip.setX(mouseEvent.getX());
                    tooltip.setY(mouseEvent.getY());
                    Tooltip.install(LilyPad, tooltip);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        LilyPad.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    buy("LilyPad", profile, DayModeMenu.root);
                    Menu.primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../Model/Shop/ShopMenu.fxml"))));
                    Menu.primaryStage.show();
                    Menu.primaryStage.setTitle("PvZ");
                } catch (Exception e) {
                }
            }
        });
    }
}
