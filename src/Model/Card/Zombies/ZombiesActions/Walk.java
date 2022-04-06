package Model.Card.Zombies.ZombiesActions;

import Controller.GameMode.Battle;
import Controller.Menus.Menu;
import Model.Card.Action;
import Model.Card.Plants.Plant;
import Model.Card.Zombies.Zombie;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;

public class Walk extends Action {


    @Override
    public void doAction(Plant plant, Battle battle, int d, Pane root) {

    }

    @Override
    public void doAction(Zombie zombie, Battle battle, int d, Pane root) throws IOException {
        int i = 0;
        int x = zombie.getCell().x();
        int y = zombie.getCell().y();
        while (i < zombie.getSpeed()) {
            System.err.println("in while");
            if ((y > 0 && battle.getMap().getCell(x, y - 1).getPlant() == null)) {
                y--;
                zombie.getImageView().setX(y * 35 + 100);
                root.getChildren().add(zombie.getImageView());
                Menu.primaryStage.setScene(new Scene(root));
                Menu.primaryStage.show();
            }
            if (y > 0 && battle.getMap().getCell(x, y - 1).getPlant() != null && zombie.getActionsOfAnEvent().contains(new StealPlant())) {
                y--;
                zombie.getImageView().setX(y * 35 + 100);
                battle.getMap().getCell(x, y).getPlant().setHealthPoint(0);
            }
            i++;
        }
        zombie.setCell(battle.getMap().getCell(x, y));
        battle.getMap().getCell(x, y).getZombies().add(zombie);
        System.err.println("walk graphic");
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//
//                System.err.println(root.toString());
//                Path path = new Path(new MoveTo(zombie.getCell().y() * 50, 100), new LineTo((zombie.getCell().y() + 1) * 50, 100));
//                path.setVisible(false);
//                PathTransition pathTransition = new PathTransition(Duration.millis(2500), path, zombie.getImageView());
//                root.getChildren().add(path);
//                pathTransition.setAutoReverse(false);
//                pathTransition.play();
//                Menu.primaryStage.show();
//            }
//        });
        System.err.println("end while");
    }
}
