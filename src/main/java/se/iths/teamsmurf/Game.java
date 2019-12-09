package se.iths.teamsmurf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
   // @FXML
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
        player = new Player();
        firstButton.setText("Start Monster Punch Game!");
        secondButton.setVisible(false);
        thirdButton.setVisible(false);
        fourthButton.setVisible(false);
        //Will run after all fields are set and view is ready
        //Next line replaces onAction="#button1Action" in fxml file
        //button1.addEventHandler(ActionEvent.ACTION,this::button1Action);

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
          //  if(firstButton.textProperty().equals("Start Monster Punch Game!")) {
                secondButton.setVisible(true);
                createNewPlayer();
          //  }
        //else
        if(firstButton.textProperty().equals("Lady Smurf")){
            player.setGender(Gender.FEMALE);
        }

    }

    public void secondButtonAction(ActionEvent actionEvent) {
           if(secondButton.textProperty().equals("Boy Smurf")){
            player.setGender(Gender.MALE);
        }
    }

    public void thirdButtonAction(ActionEvent actionEvent) {
    }

    public void fourthButtonAction(ActionEvent actionEvent) {
    }

    public void createNewPlayer(){
        firstButton.setText("Lady Smurf");
        secondButton.setText("Boy Smurf");


    }
}