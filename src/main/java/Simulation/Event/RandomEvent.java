package Simulation.Event;

import java.util.Random;

public class RandomEvent extends Event{
    private Random random;

    private void setRandomChanges(int difficulty){
        int rand = random.nextInt(100);
        int change = random.nextInt(difficulty*10);
        setChanges(((rand>difficulty)?-1:1)*change, ((rand>difficulty)?-1:1)*change*10, 0);
    }

    public RandomEvent(String eventName, int difficulty) {
        super(eventName, difficulty);
        random = new Random();
        setRandomChanges(difficulty);
    }
}
