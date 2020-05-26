package Simulation.VillageCouncil;

import Simulation.Event.Event;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VillageCouncilTest {

    @Test
    void areChoicesCountedCorrectly(){
        assertEquals(VillageCouncil.getChoiceFromVotes(1000, 10, 50), MemberChoice.POPULATION);
        assertEquals(VillageCouncil.getChoiceFromVotes(100, 1000, 50), MemberChoice.WEALTH);
        assertEquals(VillageCouncil.getChoiceFromVotes(10, 10, 5000), MemberChoice.COMBAT_CAPABILITY);
    }

    @Test
    void isSelectedEventListSizeCorrect(){
        VillageCouncil villageCouncil = new VillageCouncil(100);
        List<Event> choices = villageCouncil.getChoices(20, 80);
        assertEquals(20, choices.size());
    }

    @Test
    void isCouncilSizeCorrect(){
        long x = Long.MAX_VALUE;
        VillageCouncil villageCouncil = new VillageCouncil(x);
        assertTrue(villageCouncil.councilSize() <= villageCouncil.getMaxCouncilSize());
    }
}