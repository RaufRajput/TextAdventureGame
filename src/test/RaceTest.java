import main.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class RaceTest {

    @Test
    void TestRaceEnums() {
        assertEquals("HUMAN", Race.HUMAN.toString());
        assertEquals("ELF", Race.ELF.toString());
        assertEquals("OGRE", Race.OGRE.toString());
        assertEquals("TROLL", Race.TROLL.toString());
    }
}