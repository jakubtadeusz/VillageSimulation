package Simulation.Event;

import Simulation.VillageCouncil.MemberChoice;

import java.util.Random;

public class SelectedEvent extends Event {
    private MemberChoice choice;
    private int difficulty;

    public SelectedEvent(String name, int difficulty, MemberChoice choice) {
        super(name, difficulty);
        this.difficulty = difficulty;
        this.choice = choice;
    }

    public void setSelectedChanges() {
        Random random = new Random();
        int randInt = random.nextInt(100);
        int change = ((randInt > difficulty) ? 1 : -1) * randInt * 10 + 1;
        switch (choice) {
            case POPULATION:
                setChanges(change, 0, 0);
                break;
            case WEALTH:
                setChanges(0, change * 10, 0);
                break;
            case COMBATCAPABILITY:
                setChanges(0, 0, change);
                break;
        }
    }

}
