package se.iths.teamsmurf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    private Model model;
    private Game controller;
    private Stage primStage;



    public static void main(String[] args) {
       launch (args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("/file.fxml"));
       model = Model.getInstance();
       loader.setControllerFactory(param -> Game.getInstance(model));
       Parent root = loader.load();

        controller = loader.getController();
        controller.setStage(primaryStage);
        primStage = primaryStage;
        primaryStage.setTitle("Monster");
        primaryStage.setScene(new Scene (root));
        primaryStage.setResizable(false);
        controller.init (primaryStage.getScene ());
        String musicFile = "haha.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        primaryStage.show();
    }
}
