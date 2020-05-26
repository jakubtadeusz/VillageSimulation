package Simulation.Event;

import Simulation.Village;

public class Event {
    private final String eventName;
    private long populationChange;
    private long wealthChange;
    private long combatCapabilityChange;

    public Event(String eventName) {
        this.eventName = eventName;
    }

    public void executeOnVillage(Village village) {
        village.setPopulation(village.getPopulation() + this.populationChange);
        village.setWealth(village.getWealth() + this.wealthChange);
        village.setCombatCapability(village.getCombatCapability() + this.combatCapabilityChange);
    }

    public void setChanges(long populationChange, long wealthChange, long combatCapabilityChange) {
        this.populationChange = populationChange;
        this.wealthChange = wealthChange;
        this.combatCapabilityChange = combatCapabilityChange;
    }

    @Override
    public String toString() {
        return eventName + "        zmiana populacji:" + populationChange + " zmiana bogactwa: " + wealthChange + " zmiana umiejetnosci walki: " + combatCapabilityChange;
    }
}
