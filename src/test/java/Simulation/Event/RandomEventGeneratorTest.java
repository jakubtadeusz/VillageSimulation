package Simulation.Event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomEventGeneratorTest {
    ArrayList<String> testNames;
    RandomEventGenerator randomEventGenerator;

    @BeforeEach
    void setNames() {
        testNames = new ArrayList<>();
        testNames.add("test1");
        testNames.add("test2");
        testNames.add("test3");
        testNames.add("test4");
        randomEventGenerator = new RandomEventGenerator(testNames);
    }

    @Test
    void isEventReturnedRandom() {
        assertTrue(randomEventGenerator.getRandomEvent(100) instanceof  Event);
    }
}