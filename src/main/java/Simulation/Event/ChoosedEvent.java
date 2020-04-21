package Simulation.Event;

import Simulation.Village;
import Simulation.VillageCouncil.MemberChoice;

public class ChoosedEvent extends Event{
    private MemberChoice choice;

    public ChoosedEvent(String name, int difficulty, MemberChoice choice) {
        super(name, difficulty);
        this.choice = choice;
    }

    public void setChoosedChanges(){

    }

}
