package Simulation;

import Simulation.Event.Event;
import Simulation.VillageCouncil.VillageCouncil;

import java.util.List;

public class Simulation {

    private Village village;
    private VillageCouncil villageCouncil;
    private Integer time;

    public void start() {
    }

    public void nextDay() {

    }

    private void stop() {

    }

    private void executeEvents(List<Event> eventList) {
        for (Event event : eventList
        ) {
            event.executeOnVillage(village);
        }
    }

    private int getDifficulty() {
        return this.time / 10;
    }
}
