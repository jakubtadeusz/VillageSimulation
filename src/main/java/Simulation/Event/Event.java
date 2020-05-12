package Simulation.Event;

import Simulation.Village;

public class Event {
    private String eventName;
    private int populationChange;
    private int wealthChange;
    private int combatCapabilityChange;
    private int difficulty;

    public Event(String eventName, int difficulty) {
        this.eventName = eventName;
        this.difficulty = difficulty;
    }

    public void executeOnVillage(Village village) {
        village.setPopulation(village.getPopulation() - this.populationChange);
        village.setWealth(village.getWealth() - this.wealthChange);
        village.setCombatCapability(village.getCombatCapability() - this.combatCapabilityChange);
    }

    public void setChanges(int populationChange, int wealthChange, int combatCapabilityChange) {
        this.populationChange = populationChange;
        this.wealthChange = wealthChange;
        this.combatCapabilityChange = combatCapabilityChange;
    }

    @Override
    public String toString() {
        return eventName;
    }
}
