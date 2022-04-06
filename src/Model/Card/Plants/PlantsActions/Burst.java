package Model.Card.Plants.PlantsActions;

import Controller.GameMode.Battle;
import Controller.Menus.Menu;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Burst extends Action implements Initializable {
    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {

        Cell cell = plant.getCell();
        int x = cell.x();
        int y = cell.y();

        if (plant.getName().equalsIgnoreCase("Jalapeno")) {
            for (int i = 0; i < Map.getWIDTH() + 4; i++) {
                for (Zombie z : battle.getMap().getCell(x, i).getZombies()) {
                    z.setHealthPoint(0);
                }
            }
            plant.setHealthPoint(0);
        }

        if (plant.getName().equalsIgnoreCase("CherryBomb")) {
            for (Zombie z : battle.getMap().getCell(x - 1, y).getZombies()) {
                z.setHealthPoint(0);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Image image = null;
                        try {
                            image = new Image(new FileInputStream("C:\\Users\\asus\\IdeaProjects\\AP-07\\AP-07-1\\src\\CollectionGifsAndImages\\Cherryexplosion.png"));
                        } catch (Exception e) {
                        }
                        ImageView imageView = new ImageView(image);
                        System.err.println(root.toString());
                        root.getChildren().add(imageView);
                        Path path = new Path(new MoveTo(z.getCell().y() * 50, 100), new LineTo((z.getCell().y() + 1) * 50, 100));
                        path.setVisible(false);
                        PathTransition pathTransition = new PathTransition(Duration.millis(1000), path, imageView);
                        root.getChildren().add(path);
                        pathTransition.setAutoReverse(false);
                        pathTransition.play();
                        Menu.primaryStage.show();
                    }
                });
            }
            for (Zombie z : battle.getMap().getCell(x + 1, y).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x - 1, y + 1).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x, y + 1).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x + 1, y + 1).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x - 1, y - 1).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x, y - 1).getZombies()) {
                z.setHealthPoint(0);
            }
            for (Zombie z : battle.getMap().getCell(x + 1, y - 1).getZombies()) {
                z.setHealthPoint(0);
            }
            plant.setHealthPoint(0);

        }
    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) throws IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
