package se.iths.teamsmurf;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

// https://examples.javacodegeeks.com/singleton-class-in-java/ ref
public class Model {
    private static Model instance = null;
    private SimpleIntegerProperty playerHealth = new  SimpleIntegerProperty();
    private SimpleIntegerProperty monsterHealth = new  SimpleIntegerProperty();
    private SimpleStringProperty TextArea = new SimpleStringProperty();
    private List<Monster> monsterList =new ArrayList<>();
    private List<String> monsterAppearanceList = new ArrayList<>();
    private List<String> sceneList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();

    private Model(){
        monsterAppearanceList.add(" is jumping towards you!");
        monsterAppearanceList.add(" is popping up in front of you!");
        monsterAppearanceList.add(" is threatening running towards you!");
        monsterAppearanceList.add(" is moving furiously to you!");
        sceneList.add("You are eating a taco with your friends in your favorite smurvBar when you hear a big boom outside the gate." + "\nWoooooh!!");
        sceneList.add("Sunny Saturday! You are right in the middle of annual flower festival by the lake." + "\nSome screams are reaching you from the crowd..");
        sceneList.add("You are in the smurvMall to pick up some groceries when you hear the ceiling crashing..");
        sceneList.add("You are at the Christmas party with your fellows." + "\nTime for dessert. But: it´s missing!" + "\nChristmas tree suddenly falls down..");
        generateMonsters();
        createItems();
   }

    public void generateMonsters() {
        monsterList.add(new Monster(43,Race.ELF));
        monsterList.add(new Monster(78,Race.TROLL));
        monsterList.add(new Monster(92,Race.OGRE));
        monsterList.add(new Monster(100,Race.NinjaTurtle));
    }

    public String getTextArea() {
        return TextArea.get();
    }

    public SimpleStringProperty textAreaProperty() {
        return TextArea;
    }

    public void setTextArea(String textArea) {
        this.TextArea.set(textArea);
    }



    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void createItems() {
        itemList.add(new Item("Excaliber", 5, 0));
        itemList.add(new Item("GoldenShield", 0, 35));
        itemList.add(new Item("HolyKnightArmor", 0, 47));
        itemList.add(new Item("HolyKnightBoots", 0, 23));
    }

    public static Model getInstance() {
        // If there is no instance available, create new one (i.e. lazy initialization).
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public List<Item> getItemList() {
        return itemList;
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

    public int getMonsterListsize(){
        return this.monsterList.size()-1;
    }

    public String getMonsterAppearance(int i){
        return monsterAppearanceList.get(i);
    }
    public void removeMonsterfromlist(Monster defeatedmonster){
        for (int i = 0; i < monsterList.size() ; i++) {
         if (defeatedmonster.getMonsterName().equals(monsterList.get(i).getMonsterName())){
            monsterList.remove(i);
         }
        }
    }

    public String getScene(int i){
        return sceneList.get(i);
    }
}
