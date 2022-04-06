package Controller.Menus;

import Controller.GameMode.*;
import Model.Card.Plants.Plant;
import Model.Player.Player;
import Model.Player.Profile;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuHandler {
    private Menu currentMenu;

    public Day dayMode = null;
    public Rail railMode = new Rail();
    public Water waterMode = null;
    public ZombieGameMode zombieMode = null;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public void run(Pane root) throws IOException {


        Player bot = new Player();
        Profile profile = null;
        Scanner scanner = new Scanner(System.in);
        Player player = null;
        Player player2 = null;
        Pattern selectCard = Pattern.compile("select \\w*");
        Pattern removeCard = Pattern.compile("remove \\w*");
        Pattern buyCard = Pattern.compile("buy \\w*");
        Pattern plantPlant = Pattern.compile("plant \\d* \\d*");
        Pattern removePlant = Pattern.compile("remove \\d* \\d*");
        Pattern select = Pattern.compile("select \\w*");
        Pattern zombie = Pattern.compile("put \\w* \\d*");
        Pattern zombiegm = Pattern.compile("zombie \\w*");
        String name = null;
        Menu.init();
        while (true) {
            String input = scanner.nextLine();
            String[] splitInput = input.split(" ");

            //loginMenu//
            //leaderboard // //

//            if (Menu.menuHandler.getCurrentMenu() == Menu.loginMenu) {
//                if (input.equalsIgnoreCase("create account")) {
//                    String username = scanner.nextLine();
//                    String password = scanner.nextLine();
//                    Menu.loginMenu.createAccount(username, password);
//                } else if (input.equalsIgnoreCase("login")) {
//                    String username = scanner.nextLine();
//                    String password = scanner.nextLine();
//                    profile = Menu.loginMenu.Login(username, password);
//                } else if (input.equalsIgnoreCase("Leaderboard")) {
//                    Menu.leaderBoard.showPlayers();
//                } else if (input.equalsIgnoreCase("help")) {
//                    Menu.help();
//                } else if (input.equalsIgnoreCase("Exit")) {
//                    Menu.loginMenu.Exit();
//                } else {
//                    System.out.println("invalid command");
//                }
//            }

            //mainMenu//

//            else if (Menu.menuHandler.getCurrentMenu() == Menu.mainMenu) {
//                if (input.equalsIgnoreCase("play"))
//                    Menu.menuHandler.setCurrentMenu(Menu.playMenu);
//                else if (input.equalsIgnoreCase("Profiles"))
//                    Menu.menuHandler.setCurrentMenu(Menu.profileMenu);
//                else if (input.equalsIgnoreCase("Shop"))
//                    Menu.menuHandler.setCurrentMenu(Menu.shopMenu);
//                else if (input.equalsIgnoreCase("Exit"))
//                    Menu.mainMenu.Exit();
//                else if (input.equalsIgnoreCase("help"))
//                    Menu.help();
//                else
//                    System.out.println("invalid command");
//            }

            //profileMenu//

//            else if (Menu.menuHandler.getCurrentMenu() == Menu.profileMenu) {
//                if (input.equalsIgnoreCase("help"))
//                    Menu.help();
//                else if (input.equalsIgnoreCase("Change")) {
//                    String username = scanner.nextLine();
//                    String password = scanner.nextLine();
//                    Profile p = Profile.login(username, password);
//                    if (p == null)
//                        System.out.println("invalid account");
//                    else {
//                        profile = p;
//                    }
//                } else if (input.equalsIgnoreCase("rename")) {
//                    String username = scanner.nextLine();
//                    profile.changeUsername(username);
//                } else if (input.equalsIgnoreCase("create")) {
//                    String username = scanner.nextLine();
//                    String password = scanner.nextLine();
//                    Profile.addAccount(new Profile(username, password));
//                } else if (input.equalsIgnoreCase("delete")) {
//                    String username = scanner.nextLine();
//                    String password = scanner.nextLine();
//                    profile.delete_account(username, password);
//                    profile = null;
//                    Menu.menuHandler.setCurrentMenu(Menu.loginMenu);
//                } else if (input.equalsIgnoreCase("jhajCJUK")) {
//                    Menu.profileMenu.exit();
//                } else if (input.equalsIgnoreCase("show")) {
//                    System.out.println(profile.getUsername());
//                } else
//                    System.out.println("invalid command");
//            }

            //playMenu//

            //todo
            //else if bood
            if (Menu.menuHandler.getCurrentMenu() == Menu.playMenu) {
                if (input.equalsIgnoreCase("help"))
                    Menu.help();

                else if (input.equalsIgnoreCase("day")) {

                    Menu.playMenu.startDayGame(new Player(), new Player());
                    Menu.dayModeMenu.battle.setMap(GameMode.generateMap(new Day()));
                    Menu.collectionMenu.zombieMode = false;
                    Menu.collectionMenu.water = false;
                } else if (input.equalsIgnoreCase("water")) {
                    player = new Player();
                    waterMode = new Water();
                    Menu.dayModeMenu.battle.setMap(GameMode.generateMap(waterMode));
                    Menu.collectionMenu.zombieMode = false;
                    Menu.collectionMenu.water = true;
                    Menu.playMenu.startWaterGame(player, bot);
                } else if (input.equalsIgnoreCase("rail")) {
                    player = new Player();
                    railMode = new Rail();
                    Menu.playMenu.startRailGame(player, bot);
                    Menu.collectionMenu.zombieMode = false;
                    Menu.menuHandler.setCurrentMenu(Menu.railMenu);
                } else if (input.equalsIgnoreCase("Zombie")) {
                    player = new Player();
                    Menu.playMenu.startZombieGame(player, bot);
                    Battle battle = new Battle();
                    zombieMode = new ZombieGameMode(profile,battle);
                    Menu.collectionMenu.zombieMode = true;
                    Menu.menuHandler.setCurrentMenu(Menu.collectionMenu);
                } else if (input.equalsIgnoreCase("pvp")) {
                    player = new Player();
                    player2 = new Player();
                    Menu.playMenu.startDayGame(player, player2);
                    dayMode = new Day();
                    Menu.collectionMenu.pvp = true;
                    Menu.collectionMenu.water=false;
                } else if (input.equalsIgnoreCase("jhajCJUK")) {
                    Menu.playMenu.jhajCJUK();
                } else
                    System.out.println("invalid command");
            }

            //collectionMenu//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.collectionMenu) {
                if (input.equalsIgnoreCase("Show hand")) {
//                    Menu.collectionMenu.showHand();
                } else if (input.equalsIgnoreCase("Show collection")) {
//                    Menu.collectionMenu.showCollection(profile);
                } else if (selectCard.matcher(input).matches()) {
                    Menu.collectionMenu.selectCollection(splitInput[1], profile);
                } else if (input.equalsIgnoreCase("Play")) {
                    Menu.collectionMenu.play(player, bot);
                } else if (input.equalsIgnoreCase("help")) {
                    Menu.help();
                } else if (input.equalsIgnoreCase("Exit")) {
                    Menu.collectionMenu.exit();
                } else if (removeCard.matcher(input).matches()) {
                    Menu.collectionMenu.removeCard(splitInput[1]);
                } else
                    System.out.println("invalid command");
            }

            //shopMenu//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.shopMenu) {
                if (input.equalsIgnoreCase("show shop")) {
                    Menu.shopMenu.showShop(profile);
                } else if (input.equalsIgnoreCase("show collection")) {
                    Menu.shopMenu.getCards(profile);
                } else if (input.equalsIgnoreCase("Money")) {
                    Menu.shopMenu.showMoney(profile);
                } else if (input.equalsIgnoreCase("Help")) {
                    Menu.help();
                } else if (input.equalsIgnoreCase("Exit")) {
                    Menu.shopMenu.Exit();
                } else if (buyCard.matcher(input).matches()) {
                    Menu.shopMenu.buy(splitInput[1], profile,root);
                } else
                    System.out.println("invalid command");
            }

            //dayModeMenu//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.dayModeMenu) {
                if (input.equalsIgnoreCase("show hand")) {
                    Menu.dayModeMenu.showHandOk();
                } else if (select.matcher(input).matches()) {
                    name = splitInput[1];
                } else if (plantPlant.matcher(input).matches()) {
                    int x = Integer.parseInt(splitInput[1]);
                    int y = Integer.parseInt(splitInput[2]);
                    if (name != null) {
                        Menu.dayModeMenu.plant(name, x, y);
                    } else {
                        System.out.println("select a plant first:|");
                    }
                    name = null;
                } else if (removePlant.matcher(input).matches()) {
                    int x = Integer.parseInt(splitInput[1]);
                    int y = Integer.parseInt(splitInput[2]);
                    Menu.dayModeMenu.remove(x, y);
                } else if (input.equalsIgnoreCase("End Turn")) {
                    Menu.dayModeMenu.endTurn(profile,root );
                } else if (input.equalsIgnoreCase("show lawn")) {
                    Menu.dayModeMenu.showLawn();
                } else
                    System.out.println("invalid command");
            }

            //railMenu//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.railMenu) {
                if (input.equalsIgnoreCase("List")) {
                    for (Plant plant : Menu.railMenu.rail.showList()) {
                        System.out.println(plant.getName());
                    }
                } else if (select.matcher(input).matches()) {
                    name = splitInput[1];
                } else if (plantPlant.matcher(input).matches()) {
                    int x = Integer.parseInt(splitInput[1]);
                    int y = Integer.parseInt(splitInput[2]);
                    if (name != null) {
                        Menu.railMenu.plant(name, x, y, railMode);
                    } else if (!(x == 0 || x == 2 || x == 4)) {
                        System.out.println("you can only plant in first three column:|");
                    } else {
                        System.out.println("select a plant first:|");
                    }
                    name = null;
                } else if (removePlant.matcher(input).matches()) {
                    int x = Integer.parseInt(splitInput[1]);
                    int y = Integer.parseInt(splitInput[2]);
                    Menu.railMenu.remove(x, y);
                } else if (input.equalsIgnoreCase("End Turn")) {
                    Menu.railMenu.endTurn(profile, Menu.railMenu.getBattle(), root );
                } else if (input.equalsIgnoreCase("show lawn")) {
                    Menu.railMenu.showLawn();
                } else if (input.equalsIgnoreCase("record"))
                    Menu.railMenu.record();
                else
                    System.out.println("invalid command");
            }

            //Water//

            else if (Menu.menuHandler.getCurrentMenu() == Menu.waterModeMenu) {
                if (input.equalsIgnoreCase("show hand")) {
                    Menu.waterModeMenu.showHand();
                } else if (select.matcher(input).matches()) {
                    name = splitInput[1];
                } else if (plantPlant.matcher(input).matches()) {
                    int x = Integer.parseInt(splitInput[1]);
                    int y = Integer.parseInt(splitInput[2]);
                    if (name != null) {
                        Menu.waterModeMenu.plant(name, x, y);
                    } else {
                        System.out.println("select a plant first:|");
                    }
                    name = null;
                } else if (removePlant.matcher(input).matches()) {
                    int x = Integer.parseInt(splitInput[1]);
                    int y = Integer.parseInt(splitInput[2]);
                    Menu.waterModeMenu.remove(x, y);
                } else if (input.equalsIgnoreCase("End Turn")) {
                    Menu.waterModeMenu.endTurn(profile,root );
                } else if (input.equalsIgnoreCase("show lawn")) {
                    Menu.waterModeMenu.showLawn();
                } else
                    System.out.println("invalid command");
            }

            /////ZombieMode/////
            else if (Menu.menuHandler.getCurrentMenu() == Menu.zombieMenu) {
                if (input.equalsIgnoreCase("show hand")) {
                    Menu.zombieMenu.showHand();
                } else if (zombie.matcher(input).matches()) {
                    String n = splitInput[1];
                    int x = Integer.parseInt(splitInput[2]);
                    Menu.zombieMenu.putZombie(n, x);
                } else if (input.equalsIgnoreCase("start")) {
                    Menu.zombieMenu.start(root);
                } else if (input.equalsIgnoreCase("show lanes")) {
                    Menu.zombieMenu.showLanes();
                } else if (input.equalsIgnoreCase("show lawn")) {
                    Menu.zombieMenu.showLawn();
                } else
                    System.out.println("invalid command");
            }

            ////// PvP Mode /////

            else if (Menu.menuHandler.getCurrentMenu() == null)
                break;


        }
    }
}