import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExercisesTest {
    Exercises exercises = new Exercises();

    @Test
    void poorCamelCase() {
        String allUpperCase = "THIS TESTS IF IT WORKS";
        String allLowerCase = "thistestsifitworks";
        String mixed = "ThiSTeSTsIFitWoRKs";
        String expected = "ThIsTeStSiFiTwOrKs";
        String polish = "Zażółć gęślą jaźń";


        assertEquals("ThIs TeStS iF iT wOrKs",exercises.poorCamelCase(allUpperCase));
        assertEquals(expected,exercises.poorCamelCase(allLowerCase));
        assertEquals(expected,exercises.poorCamelCase(mixed));
        assertEquals("ZaZoLc GeSlA jAzN", exercises.poorCamelCase(polish));


    }
}