package se.iths.teamsmurf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

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
    private Game(Model model){
        this.model=model;
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
        player = new Player(100,Gender.MALE);
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

    @Override
    public void attack(int a) {

    }

    @Override
    public void defense(int a) {

    }

    public void firstButtonAction(ActionEvent actionEvent) {
            if(firstButton.getText().equals("start")) {
                thirdButton.setVisible(true);
                createNewPlayer();
            }
        else if(firstButton.getText().equals("Lady Smurf")){
            player.setGender(Gender.FEMALE);
            textArea.setText("You have chosen Lady Smurf");
            thirdButton.setVisible(false);
            firstButton.setText("Continue");
        }

        else if(firstButton.getText().equals("Continue")){
            textArea.setText("Welcome to Smurfville. " +
                    "\nThis is a peaceful village where you live with thousands of other smurfs. " +
                    "\nTime to time evil hungry monsters can come from the outside of the dark woods. " +
                    "\nYou are the chosen one to protect your village when that occurs.");
            firstButton.setText("Enter Smurfville");
            }

        else if(firstButton.getText().equals("Enter Smurfville")){
            textArea.setText(model.getScene(0));
            }
    }

    public void secondButtonAction(ActionEvent actionEvent) {

    }

    public void thirdButtonAction(ActionEvent actionEvent) {
        if(thirdButton.getText().equals("Boy Smurf")){
            player.setGender(Gender.MALE);
            textArea.setText("You have chosen Boy Smurf");
            thirdButton.setVisible(false);
            firstButton.setText("Continue");
        }
    }

    public void fourthButtonAction(ActionEvent actionEvent) {
    }

    public void createNewPlayer(){
        textArea.setText("Welcome to your Monster punch Adventure. Select desired gender with the buttons below.");
        firstButton.setText("Lady Smurf");
        thirdButton.setText("Boy Smurf");



    }
}