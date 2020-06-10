package Simulation.Event;

import Simulation.Simulation.Village;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BattleEventTest {
    @Test
    void isBattleExecutedCorrectly(){
        Village village = new Village(100, 10000, 1);
        Village village2 = new Village(100, 10000, 1);
        BattleEvent battleEvent = new BattleEvent(100);
        battleEvent.executeOnVillage(village);
        assertNotEquals(village2, village);
    }
}