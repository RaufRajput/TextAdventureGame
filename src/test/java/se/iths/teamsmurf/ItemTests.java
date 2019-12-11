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
    @Order(2)
    @DisplayName("Testing getting health value")
    void getHealthShouldReturnValue(TestInfo info){
        assertEquals(25, it.getHealth());
        System.out.println(info.getDisplayName());
    }

    @Test
    @Order(1)
    @DisplayName("Testing of health getting another value")
    void getHealthShouldNotReturnSameValue(TestInfo info){
        it.setHealth(it.getHealth()+5);
        assertNotEquals(20, it.getHealth());
        System.out.println(info.getDisplayName());
    }

    @Test
    @Order(5)
    @DisplayName("Testing Item getting a name")
    void itemShouldReturnSword(TestInfo info){
        assertEquals("Sword", it.getName());
        System.out.println(info.getDisplayName());
    }

    @Test
    @Order(6)
    @DisplayName("Testing Item getting another name")
    void itemShouldNotReturnSameName(TestInfo info){
        it.setName("sword");
        assertNotEquals("Sword", it.getName());
        System.out.println(info.getDisplayName());
    }

    @Test
    @Order(3)
    @DisplayName("Testing of Item Damage")
    void getDamageShouldChangeValue(TestInfo info){
        it.setDamage(it.getDamage()-3);
        assertEquals(7, it.getDamage());
        System.out.println(info.getDisplayName());
    }

    @Test
    @Order(4)
    @DisplayName("Testing of Item Damage gets changed")
    void getDamageShouldNotReturnSameValue(TestInfo info){
       it.setDamage(2);
       assertNotEquals(6, it.getDamage());
       System.out.println(info.getDisplayName());
    }
}
