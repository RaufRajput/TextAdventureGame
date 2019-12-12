package se.iths.teamsmurf;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
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
    @FXML
    ProgressBar healthBar;
    @FXML
    ProgressBar newHealthbar;
    @FXML
    Text monsterText;
    @FXML
    private ImageView sword;
    @FXML
    private ImageView armor;
    @FXML
    private ImageView boots;
    @FXML
    private ImageView shield;
    @FXML
    ImageView playerAvatar;

    private static Game instance = null;
    private Model model;
    private Stage stage;
    private Monster currentMonster;
    private Player player;
    private Image bildF;
    private Image bildM;

    private int notTwice2 = 0;
    private int notTwice3 = 0;
    private int notTwice4 = 0;


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
        bildF = new Image(String.valueOf(getClass().getResource("/IMG_8225.jpg")));
        bildM = new Image(String.valueOf(getClass().getResource("/Arsto.jpg")));


        textArea.setText("Click start to play Monster Punch!!!!!!!!!");
        player = new Player(100);
        model.setPlayerHealth(player.getHealth());
        firstButton.setText("start");
        secondButton.setVisible(false);
        thirdButton.setVisible(false);
        fourthButton.setVisible(false);
        newHealthbar.progressProperty().bind(model.monsterHealthProperty().multiply(0.01));
        healthBar.progressProperty().bind(model.playerHealthProperty().multiply(0.01));
        model.setMonsterHealth(0);
        newHealthbar.visibleProperty().bind(model.monsterHealthProperty().greaterThan(1));
        monsterText.visibleProperty().bind(model.monsterHealthProperty().greaterThan(1));
        SetLowOpacityOnAllItems();
    }

    private void SetLowOpacityOnAllItems() {
        sword.setOpacity(0.3);
        armor.setOpacity(0.3);
        boots.setOpacity(0.3);
        shield.setOpacity(0.3);
    }

    public void init(Scene scene) {
    }


    @Override
    public void attack() {
        // Be able to run away when your hp is low during a fight
        beAbleToRunLowHp();
        // Get random player damage from 0 - 8
        int playerDamage = getPlayerDamage();
        // Set monster damage to 0
        int monsterDamage = getMonsterDamage();
        // Get monster damage based on the current monsters race
        monsterDamage = getMonsterDamage(monsterDamage);
        // Add +5 damage when excaliber is active
        playerDamage = getPlayerDamageWhenExcaliberIsActive(playerDamage);
        // pick attacking frase for player based on your random damage
        String playerAttackFrase = getString(playerDamage);
        // Pick attacking frase for monsters based on their damage
        String MonsterAttackFrase = getMonsterString(monsterDamage);

        // set all buttons so only punch is showing   /////  NEEDS ABIT REWORK  ////// conflit with  " beAbleToRunLowHp(); "
        ChangeVisibilityForPunchOnly();

        // Decrease player health based on monster damage
        DecreasePlayerHealth(monsterDamage);
        // Decrease monster health based on player damage
        DecreaseMonsterHealth(playerDamage);
        // Combat text
        AttackStageTexts(playerDamage, monsterDamage, playerAttackFrase, MonsterAttackFrase);
    }

    private int getMonsterDamage() {
        // random damage generator for monster
        return 0;
    }

    private void AttackStageTexts(int playerDamage, int monsterDamage, String playerAttackFrase, String monsterAttackFrase) {
        // changing text on text window
        textArea.setText(
                // player attack
                playerAttackFrase + playerDamage +
                        " damage!!!! " + "\n The " + currentMonster.getMonsterName() + " health is " + (currentMonster.getMonsterHealth()) +
                        "\n\n" +
                        // monster attack
                        "The " + currentMonster.getMonsterName() +
                        monsterAttackFrase + monsterDamage + " in damage. " + "\n Your current health is " + (player.getHealth()));
    }

    private int getPlayerDamageWhenExcaliberIsActive(int playerDamage) {
        // item calc
        if (player.Excaliber) {
            playerDamage = playerDamage + model.getItemList().get(0).getDamage();
            sword.setOpacity(1.0);
        }
        return playerDamage;
    }

    private void ChangeVisibilityForPunchOnly() {
        // setting buttons visibility to true or false
        firstButton.setVisible(false);
        thirdButton.setVisible(false);
        secondButton.setVisible(true);
        secondButton.setText("Punch");
    }

    private void DecreaseMonsterHealth(int playerDamage) {
        //  Decrease Hp monster
        currentMonster.Health(currentMonster.getMonsterHealth() - playerDamage);
        model.setMonsterHealth(currentMonster.getMonsterHealth());
    }

    private void DecreasePlayerHealth(int monsterDamage) {
        //  Decrease Hp player
        player.setHealth(player.getHealth() - monsterDamage);
        model.setPlayerHealth(player.getHealth());
    }

    private String getMonsterString(int monsterDamage) {
        // Monster attack frases
        String MonsterAttackFrase;
        if (monsterDamage == 0) {
            MonsterAttackFrase = " tried to punch you back and missed, you received ";
        } else if (monsterDamage < 6 && monsterDamage > 0) {
            MonsterAttackFrase = " punched you in your stomach, you received ";
        } else {
            MonsterAttackFrase = " punched you in the HEAD, you received ";
        }
        return MonsterAttackFrase;
    }

    private String getString(int playerDamage) {

        // Player attack frases
        String playerAttackFrase;

        if (playerDamage == 0) {
            playerAttackFrase = "You MISSED and punched a tree for ";
        } else if (playerDamage < 4 && playerDamage > 0) {
            playerAttackFrase = "You spanked the monster and did ";
        } else if (playerDamage >= 4 && playerDamage < 10) {
            playerAttackFrase = "You punched him REALY hard for ";
        } else {
            playerAttackFrase = "You gave dat MODAFOKA a nice uppercut! ";
        }
        return playerAttackFrase;
    }

    private int getMonsterDamage(int monsterDamage) {
        switch (currentMonster.getRace()) {
            case TROLL:
                monsterDamage = getRandomNumberInRange(0, 7);
                break;
            case ELF:
                monsterDamage = getRandomNumberInRange(0, 6);
                break;
            case NinjaTurtle:
                monsterDamage = getRandomNumberInRange(0, 5);
                break;
            case OGRE:
                monsterDamage = getRandomNumberInRange(0, 8);
                break;
        }
        return monsterDamage;
    }

    private int getPlayerDamage() {
        // random damage generator for player
        return getRandomNumberInRange(0, 8);
    }

    private void beAbleToRunLowHp() {
        int random50 = getRandomNumberInRange(0, 10);

        if (player.getHealth() <= 25) {
            fourthButton.setVisible(true);
            fourthButton.setText("Try to run away!");
            if (random50 <= 2) {
                fourthButton.setVisible(false);
                textArea.setText("You failed to run away");
            } else {
                textArea.setText("You successfully runned away from the monster");

            }
        }
    }

    @Override
    public void defense(int a) {

    }

    public void runAndHide() {
        textArea.setText("You choose to run and hide!");
        thirdButton.setVisible(false);
        secondButton.setVisible(false);
        firstButton.setText("Next");

    }

    public void runAndHide2() {
        if (randomDouble() >= 0.8) {
            textArea.setText("You failed to hide");
            endTextMethodAfterRun();
        } else {
            textArea.setText("You managed to hide!");
            firstButton.setText("Enter Smurfville");
        }
    }

    private double randomDouble() {
        Random rd = new Random();
        return rd.nextDouble();
    }

    public void firstButtonAction(ActionEvent actionEvent) {
        switch (firstButton.getText()) {
            case "start":
                thirdButton.setVisible(true);
                createNewPlayer();
                break;
            case "Lady Smurf":
                player.setGender(Gender.FEMALE);
                playerAvatar.setImage(bildF);
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
                if (model.getMonsterListsize() == 0) {
                    currentMonster = model.getMonster(0);
                } else {
                    currentMonster = model.getMonster(getRandomNumberInRange(0, model.getMonsterListsize()));
                }
                textArea.setText(currentMonster.getMonsterName() + model.getMonsterAppearance(getRandomNumberInRange(0, 3)));
                firstButton.setText("ATTACK!");
                thirdButton.setVisible(true);
                thirdButton.setText("Run and hide!");
                break;
            case "ATTACK!":
                attack();
                break;
            case "Good Bye":
                if (firstButton.getText().equals("Good Bye")) {
                    stage.close();
                }
                break;
            case "Next":
                runAndHide2();
                break;
        }

    }

    public void secondButtonAction(ActionEvent actionEvent) {

        if (player.getHealth() <= 0) {
            secondButton.setVisible(false);
            fourthButton.setVisible(false);
            endTextPlayerDeadMethod();

        } else if (currentMonster.getMonsterHealth() <= 0) {

            switch (currentMonster.getRace()) {
                case NinjaTurtle:
                    player.Excaliber = true;
                    break;
                case TROLL:
                    player.GoldenShield = true;
                    break;
                case OGRE:
                    player.HolyKnightArmor = true;
                    break;
                case ELF:
                    player.HolyKnightBoots = true;
                    break;
            }
            item_calc();
            model.removeMonsterfromlist(currentMonster);
            if (model.getMonsterListsize() == -1) {
                endTextWinnerMethod();
            } else {
                textArea.setText("Congratulations! You have slain the " + currentMonster.getMonsterName());
                firstButton.setText("Enter Smurfville");
                firstButton.setVisible(true);
                secondButton.setVisible(false);
                thirdButton.setVisible(false);
                fourthButton.setVisible(false);
            }
        } else {
            attack();
        }
    }

    private void item_calc() {
        // item calc
        if (player.Excaliber) {
            sword.setOpacity(1.0);
        }
        if (player.GoldenShield) {
            if (notTwice2 < 1) {
                player.setHealth(player.getHealth() + model.getItemList().get(1).getHealth());
                notTwice2++;
            }
            shield.setOpacity(1.0);
        }
        if (player.HolyKnightArmor) {
            if (notTwice3 < 1) {
                player.setHealth(player.getHealth() + model.getItemList().get(2).getHealth());
                notTwice3++;
            }
            armor.setOpacity(1.0);
        }
        if (player.HolyKnightBoots) {
            if (notTwice4 < 1) {
                player.setHealth(player.getHealth() + model.getItemList().get(3).getHealth());
                notTwice4++;
            }
            boots.setOpacity(1.0);
        }
    }

    public void thirdButtonAction(ActionEvent actionEvent) {
        switch (thirdButton.getText()) {
            case "Boy Smurf":
                player.setGender(Gender.MALE);
                playerAvatar.setImage(bildM);
                textArea.setText("You have chosen Boy Smurf");
                thirdButton.setVisible(false);
                firstButton.setText("Continue");
                break;
            case "Run and hide!":
                runAndHide();
                break;
            case "Try Again":
                model.generateMonsters();
                thirdButton.setVisible(false);
                firstButton.setText("start");
                textArea.setText("Click start to play Monster Punch!!!!!!!!!");
                player.setHealth(100);
                model.setPlayerHealth(100);
                currentMonster = null;
                SetLowOpacityOnAllItems();
                SetAllItemsToFalse();
                break;
        }
    }

    private void SetAllItemsToFalse() {
        player.HolyKnightBoots = false;
        player.HolyKnightArmor = false;
        player.GoldenShield = false;
        player.Excaliber = false;
    }

    public void fourthButtonAction(ActionEvent actionEvent) {
        switch (fourthButton.getText()) {
            case "Try to run away!":
                textArea.setText("You successfully runned away!");
                firstButton.setVisible(true);
                secondButton.setVisible(false);
                fourthButton.setVisible(false);
                firstButton.setText("Enter Smurfville");
                break;
        }
    }

    public void createNewPlayer() {
        textArea.setText("Welcome to your Monster punch Adventure." + "\nSelect desired gender with the buttons below.");
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

    public void endTextPlayerDeadMethod() {
        firstButton.setVisible(true);
        thirdButton.setVisible(true);
        textArea.setText("The honor is yours!" + "\nYou fought and fell with a dignity. R.I.P.");
        firstButton.setText("Good Bye");
        thirdButton.setText("Try Again");
    }

    public void endTextMethodAfterRun() {
        model.setPlayerHealth(0);
        textArea.setText("You have betrayed your fellows." + "\nThe monster is still alive.");
        thirdButton.setVisible(true);
        firstButton.setText("Good Bye");
        thirdButton.setText("Try Again");
    }

    public void endTextWinnerMethod() {
        textArea.setText("Congratulations! You are the hero!");
        firstButton.setVisible(true);
        thirdButton.setVisible(true);
        secondButton.setVisible(false);
        fourthButton.setVisible(false);
        firstButton.setText("Good Bye");
        thirdButton.setText("Try Again");
    }
}