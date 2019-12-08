import javafx.application.*;
import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.ArrayList;
import java.util.List;

// https://examples.javacodegeeks.com/singleton-class-in-java/ ref
public class Model {
    private static Model instance = null;
    private SimpleDoubleProperty playerHealth = new  SimpleDoubleProperty();
    private SimpleDoubleProperty monsterHealth = new  SimpleDoubleProperty();
    private List<Monster> monsterList =new ArrayList<>();
    private List<String> monsterAppearneceList = new ArrayList<>();
    private List<String> sceneList = new ArrayList<>();

    private Model(){
        monsterList.add(new Monster());
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

    public Monster getMonster(int i){
        return monsterList.get(i);
    }
    public String getMonsterAppearnce(int i){
        return monsterAppearneceList.get(i);
    }
    public String getScene(int i){
        return sceneList.get(i);
    }
}
