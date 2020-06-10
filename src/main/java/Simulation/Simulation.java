package Simulation;

import Simulation.Event.Event;
import Simulation.Event.RandomEventGenerator;
import Simulation.Output.IOutput;
import Simulation.VillageCouncil.VillageCouncil;

import java.util.List;

/**
 * Simulation class
 */
public class Simulation {

    private final static int MAX_TIME = 300;
    private final static double EVENT_PER_TIMEUNIT = 0.1;
    private final Village village;
    private VillageCouncil villageCouncil;
    private int time = 0;
    private final RandomEventGenerator randomEventGenerator;
    private final IOutput output;


    /**
     * @param startingVillage Village object that simulation will be based on
     * @param randomEventGenerator used to generate random events
     * @param output object used to write output to user
     */
    public Simulation(Village startingVillage, RandomEventGenerator randomEventGenerator, IOutput output) {
        this.village = startingVillage;
        this.output = output;
        this.randomEventGenerator = randomEventGenerator;
    }

    /**
     * use to start simulation
     */
    public void start() {
        output.write("Symulacja sie zaczyna");

        villageCouncil = new VillageCouncil((int) village.getPopulation());
        nextDay();
    }

    /**
     * start next day in simulation
     */
    public void nextDay() {
        time++;
        output.write("Dzien: " + time);
        if (village.isOK() && time <= MAX_TIME) {
            List<Event> events = randomEventGenerator.getEvents((int)(time * EVENT_PER_TIMEUNIT) + 1, getDifficulty());
            events.addAll(villageCouncil.getChoices((int)(time * EVENT_PER_TIMEUNIT) + 1, getDifficulty()));
            executeEvents(events);
            output.write(getDailySummary());
            nextDay();
        } else {
            stop();
        }
    }

    /**
     * @return String with daily summary
     */
    private String getDailySummary() {
        return "Stan wioski na dzien " + this.time + ":\n   Populacja: " + village.getPopulation() + "   Bogactwo: " + village.getWealth() + "   Zdolnosc bojowa: " + village.getCombatCapability();
    }

    /**
     * stop simulation
     */
    private void stop() {
        output.write("Symulacja zakonczona.");
        output.close();
    }

    /**
     * @param eventList execute eventList on Village
     */
    private void executeEvents(List<Event> eventList) {
        for (Event event : eventList) {
            event.executeOnVillage(village);
            output.write(event.toString());
        }
    }

    /**
     * @return difficulty
     */
    private int getDifficulty() {
        return this.time;
    }
}
