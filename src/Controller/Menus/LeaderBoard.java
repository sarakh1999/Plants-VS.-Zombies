package Controller.Menus;

import Model.Player.Profile;
import javafx.fxml.Initializable;

import javax.swing.text.TabableView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;

public class LeaderBoard extends Menu implements Initializable {
    public TabableView LeaderBoardTable;

    public void showPlayers() {
        ArrayList<Profile> pros = Profile.getAccounts();
        pros.sort(new Comparator<Profile>() {
            @Override
            public int compare(Profile o1, Profile o2) {
                if (o1.getScore() > o2.getScore())
                    return -1;
                else if (o1.getScore() < o2.getScore())
                    return 1;
                else
                    return o1.getUsername().compareToIgnoreCase(o2.getUsername());
            }
        });
//        for (Profile x : pros)
//            System.out.println(x.getUsername()+ "\t" +x.getScore());
//        menuHandler.setCurrentMenu(loginMenu);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showPlayers();
        for (int i = 0; i < 10; i++) {

        }
    }
}
