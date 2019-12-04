package main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GenderTest {

    @Test
    void TestGenderEnums() {
        assertEquals("MALE", Gender.MALE.toString());
        assertEquals("FEMALE", Gender.FEMALE.toString());
    }
}