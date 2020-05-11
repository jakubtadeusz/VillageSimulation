package Simulation.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomEventGenerator {

    private List<RandomEvent> possibleEvents;
    private Random random;

    public RandomEventGenerator(List<RandomEvent> possibleEvents) {
        this.possibleEvents = possibleEvents;
    }

    public Event getRandomEvent() {
        return possibleEvents.get(random.nextInt(possibleEvents.size()));
    }

    public List<Event> getEvents(int amount) {
        ArrayList<Event> eventArrayList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            eventArrayList.add(getRandomEvent());
        }
        return eventArrayList;
    }
}
