package Simulation.VillageCouncil;

import Simulation.Event.Event;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VillageCouncilTest {

    @Test
    void areChoicesCountedCorrectly(){
        assertEquals(VillageCouncil.getChoiceFromVotes(1000, 10, 50), MemberChoice.POPULATION);
        assertEquals(VillageCouncil.getChoiceFromVotes(100, 1000, 50), MemberChoice.WEALTH);
        assertEquals(VillageCouncil.getChoiceFromVotes(10, 10, 5000), MemberChoice.COMBATCAPABILITY);
    }

    @Test
    void isSelectedEventListSizeCorrect(){
        VillageCouncil villageCouncil = new VillageCouncil(100);
        ArrayList<Event> choices = villageCouncil.getChoices(20, 30);
        assertEquals(20, choices.size());
    }
}