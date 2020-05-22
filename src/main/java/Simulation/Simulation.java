package Simulation;

import Simulation.Event.Event;
import Simulation.Event.RandomEventGenerator;
import Simulation.Output.IInput;
import Simulation.Output.IOutput;
import Simulation.VillageCouncil.VillageCouncil;

import java.util.List;

public class Simulation {

    private final int MAXTIME = 300;
    public Village village;
    public VillageCouncil villageCouncil;
    RandomEventGenerator randomEventGenerator;
    public int time = 0;
    IInput input;
    IOutput output;

    /**
     * @param input input object
     * @param output output object
     */
    public Simulation(IInput input, IOutput output) {

        this.input = input;
        this.output = output;
        randomEventGenerator = new RandomEventGenerator(input.getRandomEventNames());

    }

    /**
     * use to start simulation
     */
    public void start() {
        output.write("Symulacja sie zaczyna");
        long pop = input.loadPopulation();
        long wel = input.loadWealth();
        long com = input.loadCombatCapability();
        village = new Village(pop, wel, com);
        villageCouncil = new VillageCouncil((int) (pop));
        nextDay();
    }

    /**
     * start next day in simulation
     */
    public void nextDay() {
        time++;
        output.write("Dzien: " + time);
        if (village.isOK() && time <= MAXTIME) {
            List<Event> events = randomEventGenerator.getEvents(time / 10 + 1, getDifficulty());
            events.addAll(villageCouncil.getChoices(time / 10 + 1, getDifficulty()));
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
     * @return difficultu
     */
    private int getDifficulty() {
        return this.time;
    }
}
