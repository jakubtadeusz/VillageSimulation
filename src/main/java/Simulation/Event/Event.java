package Simulation.Event;

import Simulation.Village;

/**
 * default event class, has only name and village changes
 */
public class Event {
    private final String eventName;
    private long populationChange;
    private long wealthChange;
    private long combatCapabilityChange;

    /**
     * @param eventName event name
     */
    public Event(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @param village village on which the event will be run
     */
    public void executeOnVillage(Village village) {
        village.setPopulation(village.getPopulation() + this.populationChange);
        village.setWealth(village.getWealth() + this.wealthChange);
        village.setCombatCapability(village.getCombatCapability() + this.combatCapabilityChange);
    }

    /**
     * @param populationChange population that will added to village, might be negative
     * @param wealthChange wealth that will be added to village, might be negative
     * @param combatCapabilityChange combat capability that will be added to village, might be negative
     *                               Method used to set changes that will be proceeded on village
     */
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
