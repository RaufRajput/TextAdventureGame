import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.maven.model.Model;

public class Main extends Application {
    private Model model;
    private Game controller;
    private Stage primStage;

    public static void main(String[] args) {
        launch (args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader (getClass ().getResource ("file.fxml"));
        model = new Model ();
       loader.setControllerFactory (param -> new Game(model));
        Parent root = loader.load ();

        controller = loader.getController ();
    //    controller.setStage (primaryStage);
        primStage = primaryStage;
        primaryStage.setTitle ("Shapes and Colors");
       // primaryStage.setScene (new Scene (root, 990, 470));
    //    controller.init (primaryStage.getScene ());
        primaryStage.show ();
    }
}
