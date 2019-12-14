package se.iths.teamsmurf;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemTests {
    Item it;

    @BeforeAll
    void setupItem(){
       it = new Item("Sword", 10, 20);
    }

    @AfterAll
    void cleanUpItem(){ it = null; }

    @Test
    @DisplayName("Testing getting health value")
    void getHealthShouldReturnValue(TestInfo info){
        assertEquals(20, it.getHealth());
        System.out.println(info.getDisplayName());
    }

    @Test
    @DisplayName("Testing Item getting a name")
    void itemShouldReturnSword(TestInfo info){
        assertEquals("Sword", it.getName());
        System.out.println(info.getDisplayName());
    }

    @Test
    @DisplayName("Testing of Item Damage")
    void getDamageShouldReturnValue(TestInfo info){
        assertEquals(10, it.getDamage());
        System.out.println(info.getDisplayName());
    }
}
