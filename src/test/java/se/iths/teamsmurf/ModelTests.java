package se.iths.teamsmurf;

import static org.junit.jupiter.api.Assertions.*;

import javafx.beans.property.SimpleIntegerProperty;
import org.junit.jupiter.api.*;

import javafx.beans.property.SimpleDoubleProperty;
import se.iths.teamsmurf.Model;
import se.iths.teamsmurf.Monster;


@DisplayName("Smurf test of se.iths.teamsmurf.Model")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModelTests {
    private Model model;
    private SimpleIntegerProperty health;

    @BeforeAll
    void setModel() {
        this.model = Model.getInstance();
    }

    @AfterAll
    void clearmodel() {
        this.health=null;
        this.model = null;
    }

    @Test
    @Order(1)
    @DisplayName("Checking se.iths.teamsmurf.Player Health property")
    void testHealtPlayernIsReturningADouble(TestInfo info){
        health=model.playerHealthProperty();
        model.setPlayerHealth(100);
       assertEquals(health,model.playerHealthProperty());
       assertEquals(100,model.playerHealthProperty().doubleValue());
        System.out.println(info.getDisplayName());
    }

    @Test
    @Order(3)
    @DisplayName("Checking for a monster in the list")
    void testMonesterobjektisofSameClass(TestInfo info){
        Monster m =new Monster(30,Race.ELF);
        assertEquals(m.getClass(),model.getMonster(0).getClass());
        System.out.println(info.getDisplayName());
        m=null;
    }
    @Test
    @Order(2)
    @DisplayName("Checking se.iths.teamsmurf.Monster Health property")
    void testHealthMonsterIsReturningADouble(TestInfo info){
        health=model.monsterHealthProperty();
        model.setMonsterHealth(100);
        assertEquals(health,model.monsterHealthProperty());
        assertEquals(100,model.monsterHealthProperty().doubleValue());
        System.out.println(info.getDisplayName());
    }
}
