package se.iths.teamsmurf;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.util.Random;

public class Game implements Fight {

    @FXML
    Button firstButton;
    @FXML
    Button secondButton;
    @FXML
    Button thirdButton;
    @FXML
    Button fourthButton;
    @FXML
    TextArea textArea;

    private static Game instance = null;
    private Model model;
    private Stage stage;
    private Monster currentMonster;
    private Player player;

    //<editor-fold desc="Singelton Constructor">
    private Game(Model model) {
        this.model = model;
    }

    public static Game getInstance(Model model) {
        // If there is no instance available, create new one (i.e. lazy initialization).
        if (instance == null) {
            instance = new Game(model);
        }
        return instance;
    }
    //</editor-fold>

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize() {

        textArea.setText("Click start to play Monster Punch!!!!!!!!!");
        player = new Player(100);
        firstButton.setText("start");
        secondButton.setVisible(false);
        thirdButton.setVisible(false);
        fourthButton.setVisible(false);
        //Next line replaces onAction="#button1Action" in fxml file
        // firstButton.addEventHandler(ActionEvent.ACTION,this::firstButtonAction);
        //Will run after all fields are set and view is ready
    }

    public void init(Scene scene) {

    }

    @Override
    public void fight(boolean isFighting) {
    }

    /*
        public void duel() {
            // random damage generator for player
            int playerDamage = getRandomNumberInRange(0, 7);

            // random damage generator for monster
            int monsterDamage = getRandomNumberInRange(0, 7);

            // setting buttons visibility to true or false
            firstButton.setVisible(false);
            thirdButton.setVisible(false);
            secondButton.setVisible(true);
            secondButton.setText("Punch");

            // changing text on text window
            textArea.setText(
                    // player attack
                    "You gave dat modfoka a nice uppercut " + playerDamage +
                    " in damage!!!!" + currentMonster.getMonsterHealth() +
                    " Remaining Health /n/n" +
                    // monster attack
                    "The " + currentMonster.getMonsterName() +
                    " hit you back!, you received " + monsterDamage + " in damage.");

            //  Decrease Hp player
            player.setHealth(player.getHealth() - monsterDamage);
            //  Decrease Hp monster
            currentMonster.Health(currentMonster.getMonsterHealth() - playerDamage);


            System.out.println(currentMonster.getMonsterHealth() + "monster hp");
            System.out.println(player.getHealth() + " your hp");

            // Checking if monster or player is dead and disabling all buttons
            if (player.getHealth() <= 0 && currentMonster.getMonsterHealth() <= 0) {
                firstButton.setVisible(false);
                secondButton.setVisible(false);
                thirdButton.setVisible(false);
                secondButton.setVisible(false);
                if (player.getHealth() <= 0){
                    textArea.setText("You died.. RIP");
                }else if (currentMonster.getMonsterHealth() <= 0){
                    textArea.setText("Victory, you defeated the beast!");
                }
            }
        }
    */
    @Override
    public void attack() {

        player.setHealth(20);

    // random damage generator for player
    int playerDamage = getRandomNumberInRange(0, 7);

    // random damage generator for monster
    int monsterDamage = getRandomNumberInRange(0, 7);

    // setting buttons visibility to true or false
        firstButton.setVisible(false);
        thirdButton.setVisible(false);
        secondButton.setVisible(true);
        secondButton.setText("Punch");

    // changing text on text window
        textArea.setText(
                // player attack
                "You gave dat modafoka a nice uppercut! " + playerDamage +
            " in damage!!!! " + "The monster Health is " + (currentMonster.getMonsterHealth() - playerDamage) +
            "\n\n" +
            // monster attack
            "The " + currentMonster.getMonsterName() +
            " hit you back!, you received "  + monsterDamage + " in damage.");

    //  Decrease Hp player
        player.setHealth(player.getHealth() - monsterDamage);

    //  Decrease Hp monster
        currentMonster.Health(currentMonster.getMonsterHealth() - playerDamage);


        System.out.println(currentMonster.getMonsterHealth() + "monster hp");
        System.out.println(player.getHealth() + " your hp");

    }

    @Override
    public void defense(int a) {

    }

    public void runAndHide() {
        textArea.setText("You choose to run and hide!");

    }

    public void firstButtonAction(ActionEvent actionEvent) {
        switch (firstButton.getText()) {
            case "start":
                thirdButton.setVisible(true);
                createNewPlayer();
                break;
            case "Lady Smurf":
                player.setGender(Gender.FEMALE);
                textArea.setText("You have chosen Lady Smurf");
                thirdButton.setVisible(false);
                firstButton.setText("Continue");
                break;
            case "Continue":
                textArea.setText("Welcome to Smurfville. " +
                        "\nThis is a peaceful village where you live with thousands of other smurfs. " +
                        "\nTime to time evil hungry monsters can come from the outside of the dark woods. " +
                        "\nYou are the chosen one to protect your village when that occurs.");
                firstButton.setText("Enter Smurfville");
                break;
            case "Enter Smurfville":
                textArea.setText(model.getScene(getRandomNumberInRange(0, 3)));
                firstButton.setText("Show More");
                break;
            case "Show More":
                currentMonster = model.getMonster(getRandomNumberInRange(0, 3));
                textArea.setText(currentMonster.getMonsterName() + model.getMonsterAppearance(getRandomNumberInRange(0, 3)));
                firstButton.setText("ATTACK!");
                thirdButton.setText("Run and hide!");
                break;
            case "ATTACK!":
                attack();
                break;
        }

    }

    public void secondButtonAction(ActionEvent actionEvent) {

        if (player.getHealth() <= 0){
            System.out.println("player dead");
            textArea.setText("You died.. RIP");
            firstButton.setVisible(false);
            secondButton.setVisible(false);
            thirdButton.setVisible(false);
            fourthButton.setVisible(false);
        }else if (currentMonster.getMonsterHealth() <= 0){
            System.out.println("monster is dead");
            textArea.setText("Congratulations!, you have slain the " + currentMonster.getMonsterName());
            firstButton.setVisible(true);
            firstButton.setText("Continue adventure");
            secondButton.setVisible(false);
            thirdButton.setVisible(false);
            fourthButton.setVisible(false);
        }else {
            attack();
        }
    }

    public void thirdButtonAction(ActionEvent actionEvent) {
        if (thirdButton.getText().equals("Boy Smurf")) {
            player.setGender(Gender.MALE);
            textArea.setText("You have chosen Boy Smurf");
            thirdButton.setVisible(false);
            firstButton.setText("Continue");
        } else if (thirdButton.getText().equals("Run and hide!")) {
            runAndHide();
        }

    }

    public void fourthButtonAction(ActionEvent actionEvent) {
    }

    public void createNewPlayer() {
        textArea.setText("Welcome to your Monster punch Adventure. Select desired gender with the buttons below.");
        firstButton.setText("Lady Smurf");
        thirdButton.setText("Boy Smurf");
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}