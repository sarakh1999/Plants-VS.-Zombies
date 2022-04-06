package Controller.Menus;

import Model.Card.ActionsOfAnEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;

public class HelpMenu extends Menu implements Initializable {
    public Button backButton;
    public MenuItem closeButton;
    public Label label1=new Label();
    public Label label2=new Label();
    public Label label3=new Label();
    public Label label4=new Label();
    public Label label5=new Label();
    public ArrayList<Label> labels=new ArrayList<>();
    {
        labels.add(label1);
        labels.add(label2);
        labels.add(label3);
        labels.add(label4);
        labels.add(label5);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                shopMenu.Exit();
            }
        });
        closeButton.setOnAction(ActionsOfAnEvent -> exit());
    }


}
