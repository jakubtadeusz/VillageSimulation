package Simulation.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Simulation.SimulationConsts.*;

/**
 * Class used to generate random events
 */
public class RandomEventGenerator {

    private final List<String> possibleEventNames;
    private final Random random;

    /**
     * @param possibleEventNames List with event names
     */
    public RandomEventGenerator(List<String> possibleEventNames) {
        this.possibleEventNames = possibleEventNames;
        random = new Random();
    }

    /**
     * @param difficulty difficulty of event
     * @return randomized event or battle event
     */
    public Event getRandomEvent(int difficulty) {
        if (random.nextInt(DIFFICULTY_CAP) > (DIFFICULTY_CAP - BATTLE_CHANCE)) {
            return new BattleEvent(difficulty);
        } else {

            int rand = random.nextInt(DIFFICULTY_CAP);
            int change = random.nextInt(difficulty * CHANGE_MULTIPLIER);
            return new RandomEvent(possibleEventNames.get(random.nextInt(possibleEventNames.size())), difficulty);
        }
    }

    /**
     * @param amount amount of events that will be generated
     * @param difficulty difficulty of genereted events
     * @return List of randomized events
     */
    public List<Event> getEvents(int amount, int difficulty) {
        ArrayList<Event> eventArrayList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            eventArrayList.add(getRandomEvent(difficulty));
        }
        return eventArrayList;
    }
}
