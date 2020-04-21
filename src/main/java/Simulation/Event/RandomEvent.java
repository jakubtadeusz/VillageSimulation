package Simulation.Event;

import Simulation.Village;

import java.util.Random;

public class RandomEvent extends Event{
    private Random random;

    private void setRandomChanges(int difficulty){
        int rand = random.nextInt(100);
        setChanges((rand>difficulty?1:-1)*difficulty*10, (rand>difficulty?1:-1)*difficulty*100, 0);
    }

    public RandomEvent(String eventName, int difficulty) {
        super(eventName, difficulty);
        random = new Random();
        setRandomChanges(difficulty);
    }
}
