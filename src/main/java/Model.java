import javafx.application.*;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

// https://examples.javacodegeeks.com/singleton-class-in-java/ ref
public class Model {
    private static Model instance = null;
    private SimpleDoubleProperty playerHealth = new  SimpleDoubleProperty();
    private SimpleDoubleProperty monsterHealth = new  SimpleDoubleProperty();
    private Model(){

    }
    public static Model getInstance() {
        // If there is no instance available, create new one (i.e. lazy initialization).
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }
    public SimpleDoubleProperty playerHealthProperty(){
        return playerHealth;
    }
    public SimpleDoubleProperty monsterHealthProperty(){
        return monsterHealth;
    }

    public void setMonsterHealth(double monsterHealth) {
        this.monsterHealth.set(monsterHealth);
    }

    public void setPlayerHealth(double playerHealth) {
        this.playerHealth.set(playerHealth);
    }
}
