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
    private List<String> monsterAppearanceList = new ArrayList<>();
    private List<String> sceneList = new ArrayList<>();

    private Model(){
        monsterList.add(new Monster(30,Race.ELF));
        monsterList.add(new Monster(60,Race.TROLL));
        monsterList.add(new Monster(80,Race.OGRE));
        monsterList.add(new Monster(100,Race.HUMAN));
        monsterAppearanceList.add(" is jumping towards you!");
        monsterAppearanceList.add(" is popping up in front of you!");
        monsterAppearanceList.add(" is threatening running towards you!");
        monsterAppearanceList.add(" is moving furiously to you!");
        sceneList.add("You are eating a taco with your friends in your favorite smurvBar when you hear a big boom outside the gate. Woooooh!!");
        sceneList.add("Sunny Saturday! You are right in the middle of annual flower festival by the lake. Some screams are reaching you from the crowd..");
        sceneList.add("You are in the smurvMall to pick up some groceries when you hear the ceiling crashing..");
        sceneList.add("You are at the Christmas party with your fellows. Time for dessert. But: it´s missing! Christmas tree suddenly falls down..");

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
    public String getMonsterAppearance(int i){
        return monsterAppearanceList.get(i);
    }
    public String getScene(int i){
        return sceneList.get(i);
    }
}
