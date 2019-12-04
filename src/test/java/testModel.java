import static org.junit.jupiter.api.Assertions.*;
import javafx.beans.property.SimpleDoubleProperty;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class testModel {
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
    @DisplayName("Check Player Health property")
    void testHealtPlayernIsReturningADouble(){
        health=model.playerHealthProperty();
        model.setPlayerHealth(100);
       assertEquals(health,model.playerHealthProperty());
       assertEquals(100,model.playerHealthProperty().doubleValue());

    }

    @Test
    @DisplayName("Check Monster Health property")
    void testHealthMonsterIsReturningADouble(){
        health=model.monsterHealthProperty();
        model.setMonsterHealth(100);
        assertEquals(health,model.monsterHealthProperty());
        assertEquals(100,model.monsterHealthProperty().doubleValue());
    }
}
