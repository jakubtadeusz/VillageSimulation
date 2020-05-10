package Simulation.Event;

import Simulation.Village;
import Simulation.VillageCouncil.MemberChoice;

public class SelectedEvent extends Event{
    private MemberChoice choice;

    public SelectedEvent(String name, int difficulty, MemberChoice choice) {
        super(name, difficulty);
        this.choice = choice;
    }

    public void setSelectedChanges(){

    }

}
