package Simulation.VillageCouncil;


import Simulation.Event.BattleEvent;
import Simulation.Event.Event;
import Simulation.Event.SelectedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VillageCouncil {
    private final int MAXCOUNCILSIZE = 300;
    private final ArrayList<CouncilMember> councilMemberArrayList = new ArrayList<>();

    private ArrayList<CouncilMember> getCouncilMemberArrayList() {
        return this.councilMemberArrayList;
    }

    private void rerollCouncilMembers() {
        for (CouncilMember councilMember : councilMemberArrayList
        ) {
            councilMember.rerollMember();
        }
    }

    private void addNewCouncilMembers(long amount) {
        for (int i = 0; i < amount; i++) {
            councilMemberArrayList.add(new CouncilMember());
        }
    }

    public VillageCouncil(long amount) {
        long memberAmount = this.calculateCouncilSize(amount);
        addNewCouncilMembers(memberAmount);
    }

    private long calculateCouncilSize(long amount) {
        return Math.min((amount / 100 + 1), MAXCOUNCILSIZE);
    }

    public List<Event> getChoices(int amount, int difficulty) {
        List<Event> eventList = new ArrayList<>();
        MemberChoice choice;
        String eventName;
        for (int i = 0; i < amount; i++) {
            choice = voteForChoice();
            eventName = choice == MemberChoice.POPULATION ? "Population" : choice == MemberChoice.COMBATCAPABILITY ? "Combat capability" : "Wealth";
            Random random = new Random();
            if (random.nextInt(100) > 75) {
                eventList.add(new BattleEvent(difficulty));
            } else eventList.add(new SelectedEvent(eventName, difficulty, choice));
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

    public int councilSize() {
        return this.getCouncilMemberArrayList().size();
    }

    public int getMaxCouncilSize() {
        return MAXCOUNCILSIZE;
    }
}
