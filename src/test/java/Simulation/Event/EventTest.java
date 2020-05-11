package Simulation.Event;

import Simulation.Village;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventTest {
    Village village;
    Event event;

    @BeforeEach
   void createEvent() {
        this.village = new Village(1000, 10000, 600);
        this.event = new Event("Test event", 10);
    }

    @Test
    void areChangesExecutedOnVillage() {
        event.setChanges(100, 1000, 100);
        event.executeOnVillage(village);
        assertEquals(900, village.getPopulation(), "population");
        assertEquals(9000, village.getWealth(), "wealth");
        assertEquals(500, village.getCombatCapability(), "combat");
    }

}