

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Model model;
    private Game controller;
    private Stage primStage;

    public static void main(String[] args) {
       launch (args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(getClass().getResource("file.fxml"));
        model = Model.getInstance();
       loader.setControllerFactory (param -> Game.getInstance(model));
       Parent root = loader.load ();

        controller = loader.getController ();
        controller.setStage (primaryStage);
        primStage = primaryStage;
        primaryStage.setTitle ("Monster");
        primaryStage.setScene (new Scene (root, 800, 600));
       controller.init (primaryStage.getScene ());
        primaryStage.show ();


    }
}
//TODO Göra om Controller till Singelton  (fila på Lösning...)
//TODO Behålla Model som Singelton?