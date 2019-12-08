import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import javafx.beans.property.SimpleDoubleProperty;


@DisplayName("Smurf test of Model")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModelTests {
    private Model model;
    private SimpleDoubleProperty health;

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
    @DisplayName("Checking Player Health property")
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
    void testMonesterobjektisofSameClass(){
        Monster m =new Monster();
        assertEquals(m.getClass(),model.getMonster(0).getClass());
        m=null;
    }
    @Test
    @Order(2)
    @DisplayName("Checking Monster Health property")
    void testHealthMonsterIsReturningADouble(TestInfo info){
        health=model.monsterHealthProperty();
        model.setMonsterHealth(100);
        assertEquals(health,model.monsterHealthProperty());
        assertEquals(100,model.monsterHealthProperty().doubleValue());
        System.out.println(info.getDisplayName());
    }
}
