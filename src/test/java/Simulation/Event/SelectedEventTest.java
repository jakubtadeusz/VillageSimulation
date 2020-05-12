package Simulation.Event;

import Simulation.Village;
import Simulation.VillageCouncil.MemberChoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectedEventTest {
    Village village;

    @BeforeEach
    void resetVillage(){
        village = new Village(0, 0, 0);
    }

    @Test
    void isPopulationOptionWorking(){
        SelectedEvent selectedEvent = new SelectedEvent("Test", 50, MemberChoice.POPULATION);
        selectedEvent.setSelectedChanges();
        selectedEvent.executeOnVillage(village);
        assertNotEquals(village.getPopulation(), 0);
    }

    @Test
    void isWealthOptionWorking(){
        SelectedEvent selectedEvent = new SelectedEvent("Test", 50, MemberChoice.WEALTH);
        selectedEvent.setSelectedChanges();
        selectedEvent.executeOnVillage(village);
        assertNotEquals(village.getWealth(), 0);
    }

    @Test
    void isCombatCapabilityOptionWorking(){
        SelectedEvent selectedEvent = new SelectedEvent("Test", 50, MemberChoice.COMBATCAPABILITY);
        selectedEvent.setSelectedChanges();
        selectedEvent.executeOnVillage(village);
        assertNotEquals(village.getCombatCapability(), 0);
    }

}