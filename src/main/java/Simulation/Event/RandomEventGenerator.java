package Simulation.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Simulation.SimulationConsts.*;

public class RandomEventGenerator {

    private final List<String> possibleEventNames;
    private final Random random;

    public RandomEventGenerator(List<String> possibleEventNames) {
        this.possibleEventNames = possibleEventNames;
        random = new Random();
    }

    public Event getRandomEvent(int difficulty) {
        if(random.nextInt(DIFFICULTY_CAP) > (DIFFICULTY_CAP - BATTLE_CHANCE)){
            return new BattleEvent(difficulty);
        }else {

            int rand = random.nextInt(DIFFICULTY_CAP);
            int change = random.nextInt(difficulty * CHANGE_MULTIPLIER);
            return new RandomEvent(possibleEventNames.get(random.nextInt(possibleEventNames.size())), difficulty);
        }
    }

    public List<Event> getEvents(int amount, int difficulty) {
        ArrayList<Event> eventArrayList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            eventArrayList.add(getRandomEvent(difficulty));
        }
        return eventArrayList;
    }
}
