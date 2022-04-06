package Controller.Menus;

import Model.Player.Profile;
import com.gilecode.yagson.YaGson;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginMenu extends Menu implements Initializable {


    public Text errorL;
    public TextField usernameField;
    public TextField passwordField;
    public Button CreateAccountButton;
    public Button LoginButton;
    public Label err;


    public LoginMenu() {
        this.orders = new String[]{"Create account", "Login", "Leaderboard", "Help", "Exit"};
    }

    public Profile createAccount(String username, String password) throws IOException {
        if (Profile.validUsername(username)) {
            Profile profile = new Profile(username, password);
            Profile.addAccount(profile);
            Menu.saveAccount();
//            menuHandler.setCurrentMenu(loginMenu);
            return profile;
        } else {
//            System.out.println("invalid username");
            return null;
        }
    }

    public Profile Login(String username, String password) {
        Profile p = Profile.login(username, password);
        if (p != null) {
            System.out.println("logged in");
//            menuHandler.setCurrentMenu(mainMenu);
        } else
            System.out.println("wrong username or password");
        return p;
    }

    public void Exit() {
        menuHandler.setCurrentMenu(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //quitButton.setOnAction(ActionsOfAnEvent -> exit());

        //System.out.println(user.length());
        CreateAccountButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String user = usernameField.getText();
                String pass = passwordField.getText();
                if (Profile.validUsername(user)) {
                    try {
                        Menu.profile = createAccount(user, pass);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Parent root = (FXMLLoader.load(getClass().getResource("MainMenu.fxml")));
                        Menu.primaryStage.setScene(new Scene(root));
                        Menu.primaryStage.show();
                        Menu.profile = new Profile(user, pass);
                        Menu.primaryStage.setTitle("PvZ");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    err.setText("This username is invalid");
                    usernameField.clear();
                    passwordField.clear();
                }
            }
        });
        LoginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String user = usernameField.getText();
                String pass = passwordField.getText();
//                System.out.println("rt");
                Menu.profile = Login(user, pass);
//                System.out.println(user);
                if (Menu.profile != null) {
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                        Menu.primaryStage.setScene(new Scene(root));
                        Menu.primaryStage.show();
                        Menu.primaryStage.setTitle("PvZ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    err.setText("Username or Password is incorrect");
                    usernameField.clear();
                    passwordField.clear();
                }
            }
        });
    }
}