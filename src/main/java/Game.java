import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
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
    }

    public void secondButtonAction(ActionEvent actionEvent) {
    }

    public void thirdButtonAction(ActionEvent actionEvent) {
    }

    public void fourthButtonAction(ActionEvent actionEvent) {
    }
}