package Simulation.Event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void isRandomEventListCorrectSize() {
        List<Event> randomEventGeneratorEvents= randomEventGenerator.getEvents(20, 50);
        assertEquals(20, randomEventGeneratorEvents.size());

    }
}