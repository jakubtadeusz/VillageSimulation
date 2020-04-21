package Simulation.VillageCouncil;


import Simulation.Event.ChoosedEvent;

import java.util.ArrayList;
import java.util.List;

public class VillageCouncil {
    private ArrayList<CouncilMember> councilMemberArrayList = new ArrayList<>();
    private List<ChoosedEvent> possibleChoices;

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

    public List<ChoosedEvent> getChoices(){
        ArrayList<ChoosedEvent> eventList = new ArrayList<>();
        return eventList;
    }
}
