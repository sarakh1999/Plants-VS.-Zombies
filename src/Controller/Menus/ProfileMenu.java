package Controller.Menus;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Model.Player.Profile.login;

public class ProfileMenu extends Menu implements Initializable {

    public Button backButton;
    public Button ChangeButton;
    public Button DeleteButton;
    public Button RenameButton;
    public Button CreateButton;
    public Button ShowButton;
    public Label label;
    public PasswordField passwordField;
    public TextField textField;
    public Button done;

    public ProfileMenu() {
        this.orders = new String[]{"Change", "Delete", "Rename", "Create", "Help", "Exit"};
    }

    public void exit() {
        Menu.menuHandler.setCurrentMenu(Menu.mainMenu);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuHandler.setCurrentMenu(mainMenu);
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
        });

        RenameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                label.setVisible(true);
                label.setText("Enter UserName & Password");
                textField.setVisible(true);
                done.setVisible(true);
                done.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        String username = textField.getText();
                        System.out.println(username);
                        profile.changeUsername(username);
                        textField.setVisible(false);
                        passwordField.setVisible(false);
                        label.setVisible(false);
                        done.setVisible(false);
                        try {
                            Menu.saveAccount();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Menu.profile.getUsername());
                    }
                });
            }
        });


    }
}