package Simulation.VillageCouncil;


import Simulation.Event.Event;
import Simulation.Event.SelectedEvent;

import java.util.ArrayList;

public class VillageCouncil {
    private ArrayList<CouncilMember> councilMemberArrayList = new ArrayList<>();

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

    public ArrayList<Event> getChoices(int amount, int difficulty) {
        ArrayList<Event> eventList = new ArrayList<>();
        MemberChoice choice;
        String eventName;
        for(int i = 0; i < amount; i++)
        {
            choice = voteForChoice();
            eventName = choice==MemberChoice.POPULATION?"Population":choice==MemberChoice.COMBATCAPABILITY?"Combat capability":"Wealth";
            eventList.add(new SelectedEvent(eventName, difficulty, choice));
        }
        return eventList;
    }

    private MemberChoice voteForChoice() {
        int population = 0;
        int wealth = 0;
        int combat = 0;
        for (CouncilMember councilMember : getCouncilMemberArrayList()) {
            switch (councilMember.getMemberChoice()) {
                case POPULATION:
                    population++;
                    break;
                case WEALTH:
                    wealth++;
                    break;
                case COMBATCAPABILITY:
                    combat++;
                    break;
            }
        }
        return getChoiceFromVotes(population, wealth, combat);
    }

    public static MemberChoice getChoiceFromVotes(int population, int wealth, int combat) {
        if (population > wealth) {
            if (combat > population) {
                return MemberChoice.COMBATCAPABILITY;
            } else return MemberChoice.POPULATION;
        } else if (combat > wealth) {
            return MemberChoice.COMBATCAPABILITY;
        } else return MemberChoice.WEALTH;
    }
}
