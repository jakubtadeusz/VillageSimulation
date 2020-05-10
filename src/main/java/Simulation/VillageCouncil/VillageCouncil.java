package Simulation.VillageCouncil;


import Simulation.Event.SelectedEvent;

import java.util.ArrayList;
import java.util.List;

public class VillageCouncil {
    private ArrayList<CouncilMember> councilMemberArrayList = new ArrayList<>();
    private List<SelectedEvent> possibleChoices;

    private ArrayList<CouncilMember> getCouncilMemberArrayList() {
        return this.councilMemberArrayList;
    }

    private void rerollCouncilMembers() {
        for (CouncilMember councilMember : councilMemberArrayList
        ) {
            councilMember.rerollMember();
        }
    }

    private void addNewCouncilMembers(int amount) {
        for (int i = 0; i < amount; i++) {
            councilMemberArrayList.add(new CouncilMember());
        }
    }

    public VillageCouncil(int amount) {
        addNewCouncilMembers(amount);
    }

    public List<SelectedEvent> getChoices(){
        ArrayList<SelectedEvent> eventList = new ArrayList<>();
        return eventList;
    }
}
