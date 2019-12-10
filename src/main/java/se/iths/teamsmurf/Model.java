package se.iths.teamsmurf;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

// https://examples.javacodegeeks.com/singleton-class-in-java/ ref
public class Model {
    private static Model instance = null;
    private SimpleIntegerProperty playerHealth = new  SimpleIntegerProperty();
    private SimpleIntegerProperty monsterHealth = new  SimpleIntegerProperty();
    private List<Monster> monsterList =new ArrayList<>();
    private List<String> monsterAppearneceList = new ArrayList<>();
    private List<String> sceneList = new ArrayList<>();

    private Model(){
        monsterList.add(new Monster(30,Race.ELF));
        monsterList.add(new Monster(60,Race.TROLL));
        monsterList.add(new Monster(80,Race.OGRE));
        monsterList.add(new Monster(100,Race.HUMAN));

        sceneList.add("U are having tacos");
   }
    public static Model getInstance() {
        // If there is no instance available, create new one (i.e. lazy initialization).
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }
    public SimpleIntegerProperty playerHealthProperty(){
        return playerHealth;
    }
    public SimpleIntegerProperty monsterHealthProperty(){
        return monsterHealth;
    }
    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth.set(monsterHealth);
    }
    public void setPlayerHealth(int playerHealth) {
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
