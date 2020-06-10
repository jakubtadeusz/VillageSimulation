package Simulation.Event;

import Simulation.Simulation.Village;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomEventTest {
    @Test
    void isRandomChangeWorking(){
        Village original = new Village(1000, 500, 600);
        Village copy = new Village(original.getPopulation(), original.getWealth(), original.getCombatCapability());
        RandomEvent randomEvent = new RandomEvent("Random event", 10);
        randomEvent.executeOnVillage(copy);
        assertNotEquals(original, copy);
    }
}
