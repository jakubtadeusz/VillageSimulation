package Simulation.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomEventGenerator {

    private static List<RandomEvent> possibleEvents;
    private static Random random;

    public static Event getRandomEvent() {
        return possibleEvents.get(random.nextInt(possibleEvents.size()));
    }

    public static List<Event> getEvents(int amount) {
        ArrayList<Event> eventArrayList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            eventArrayList.add(getRandomEvent());
        }
        return eventArrayList;
    }
}
