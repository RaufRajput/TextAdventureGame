import javafx.application.*;
// https://examples.javacodegeeks.com/singleton-class-in-java/ ref
public class Model {
    private static Model instance = null;
    private Model(){

    }
    public static Model getInstance() {
        // If there is no instance available, create new one (i.e. lazy initialization).
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

}
