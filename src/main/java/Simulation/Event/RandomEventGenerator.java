package Simulation.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomEventGenerator {

    private final List<String> possibleEventNames;
    private final Random random;

    public RandomEventGenerator(List<String> possibleEventNames) {
        this.possibleEventNames = possibleEventNames;
        random = new Random();
    }

    public Event getRandomEvent(int difficulty) {
        RandomEvent randomEvent = new RandomEvent(possibleEventNames.get(random.nextInt(possibleEventNames.size())), difficulty);
        return randomEvent;
    }

    public List<Event> getEvents(int amount, int difficulty) {
        ArrayList<Event> eventArrayList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            eventArrayList.add(getRandomEvent(difficulty));
        }
        return eventArrayList;
    }
}
