package Simulation.Event;

import Simulation.VillageCouncil.MemberChoice;

import java.util.Random;

import static Simulation.SimulationConsts.CHANGE_MULTIPLIER;
import static Simulation.SimulationConsts.DIFFICULTY_CAP;

public class SelectedEvent extends Event {

    private final MemberChoice choice;
    private final int difficulty;


    public SelectedEvent(String name, int difficulty, MemberChoice choice) {
        super(name);
        this.difficulty = difficulty;
        this.choice = choice;
        this.setSelectedChanges();
    }

    public void setSelectedChanges() {
        Random random = new Random();
        int randInt = random.nextInt(DIFFICULTY_CAP);
        int change = ((randInt > difficulty) ? 1 : -1) * randInt * CHANGE_MULTIPLIER + 1;
        switch (choice) {
            case POPULATION:
                setChanges(change, 0, 0);
                break;
            case WEALTH:
                setChanges(0, change * CHANGE_MULTIPLIER, 0);
                break;
            case COMBAT_CAPABILITY:
                setChanges(0, 0, change);
                break;
        }
    }

}
