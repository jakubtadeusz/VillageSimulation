package Simulation;

import Simulation.Simulation.Village;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VillageTest {

    @Test
    void checkEquals(){
        Village village1 = new Village(1000, 100, 5000);
        Village village2 = new Village(1000, 100, 5000);
        assertEquals(village1, village2);
    }

}