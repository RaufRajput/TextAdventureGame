package se.iths.teamsmurf;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayerTests {
    Player p;
    @BeforeAll
    void setupPlayer(){
        p=new Player(100);
    }
    @Test
    @Order(1)
    @DisplayName("Testing Player health value")
    void playerShouldReturnAnDecresedInt(TestInfo info){
        p.setHealth(p.getHealth()-10);
        assertEquals(90,p.getHealth());
        System.out.println(info.getDisplayName());
    }
    @Test
    @Order(2)
    @DisplayName("Testing Player setting health value")
    void playerShouldReturnAnLowerDecresedInt(TestInfo info){
        p.setHealth(p.getHealth()-10);
        assertEquals(80,p.getHealth());
        System.out.println(info.getDisplayName());
    }
    @Test
    @Order(3)
    @DisplayName("Testing Player setting health value")
    void playerShouldReturnAnGender(TestInfo info){
        p.setGender(Gender.MALE);
        assertNotEquals(Gender.FEMALE,p.getGender());
        assertEquals(Gender.MALE,p.getGender());
    }
}
