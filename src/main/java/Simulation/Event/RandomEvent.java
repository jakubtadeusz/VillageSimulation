package Simulation.Event;

import java.util.Random;

import static Simulation.SimulationConsts.CHANGE_MULTIPLIER;
import static Simulation.SimulationConsts.DIFFICULTY_CAP;

public class RandomEvent extends Event {
    private final Random random;

    private void setRandomChanges(int difficulty) {
        int rand = random.nextInt(DIFFICULTY_CAP);
        int change = random.nextInt(difficulty * CHANGE_MULTIPLIER);
        setChanges(((rand > difficulty) ? -1 : 1) * change, ((rand > difficulty) ? -1 : 1) * change * CHANGE_MULTIPLIER, 0);
    }

    public RandomEvent(String eventName, int difficulty) {
        super(eventName);
        random = new Random();
        setRandomChanges(difficulty);
    }

}
