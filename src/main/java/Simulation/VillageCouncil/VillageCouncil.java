package Simulation.VillageCouncil;


import Simulation.Event.BattleEvent;
import Simulation.Event.Event;
import Simulation.Event.SelectedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Simulation.App.SimulationConsts.BATTLE_CHANCE;
import static Simulation.App.SimulationConsts.DIFFICULTY_CAP;

/**
 * allow to generate events based on village council choices
 */
public class VillageCouncil {
    private final static int MAX_COUNCIL_SIZE = 300;
    private final static double MEMBERS_PER_SETTLER = 0.01;
    private final ArrayList<CouncilMember> councilMemberArrayList = new ArrayList<>();

    /**
     * @param villagePopulation population of village that will use this council
     */
    public VillageCouncil(long villagePopulation) {
        long memberAmount = this.calculateCouncilSize(villagePopulation);
        generateCouncilMembers(memberAmount);
    }

    /**
     * @param amount choices amount
     * @param difficulty event difficulty
     * @return list of event selected by council
     * use to get event that village council chooses
     */
    public List<Event> getChoices(int amount, int difficulty) {
        List<Event> eventList = new ArrayList<>();
        MemberChoice choice;
        String eventName;
        for (int i = 0; i < amount; i++) {
            choice = voteForChoice();
            eventName = getSelectedEventName(choice);
            Random random = new Random();
            if (random.nextInt(DIFFICULTY_CAP) > (DIFFICULTY_CAP - BATTLE_CHANCE)) {
                eventList.add(new BattleEvent(difficulty));
            } else eventList.add(new SelectedEvent(eventName, difficulty, choice));
        }
        return eventList;
    }


    /**
     * @return size of council
     */
    public int councilSize() {
        return this.getCouncilMemberArrayList().size();
    }

    /**
     * @return maximum council size
     */
    public int getMaxCouncilSize() {
        return MAX_COUNCIL_SIZE;
    }

    /**
     * @param population amount of votes for population
     * @param wealth amount of votes for wealth
     * @param combat amount of votes for combat capability
     * @return choice that most people voted for
     */
    public static MemberChoice getChoiceFromVotes(int population, int wealth, int combat) {
        if (population > wealth) {
            if (combat > population) {
                return MemberChoice.COMBAT_CAPABILITY;
            } else return MemberChoice.POPULATION;
        } else if (combat > wealth) {
            return MemberChoice.COMBAT_CAPABILITY;
        } else return MemberChoice.WEALTH;
    }

    private String getSelectedEventName(MemberChoice choice) {
        return choice == MemberChoice.POPULATION ? "Population" : choice == MemberChoice.COMBAT_CAPABILITY ? "Combat capability" : "Wealth";
    }

    private ArrayList<CouncilMember> getCouncilMemberArrayList() {
        return this.councilMemberArrayList;
    }

    private void addNewCouncilMember(CouncilMember councilMember) {
        councilMemberArrayList.add(councilMember);
    }

    private void generateCouncilMembers(long memberAmount) {
        for (int i = 0; i < memberAmount; i++) {
            addNewCouncilMember(new CouncilMember());
        }
    }

    private long calculateCouncilSize(long villagePopulation) {
        return Math.min(((int) (villagePopulation * MEMBERS_PER_SETTLER)), getMaxCouncilSize());
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
                case COMBAT_CAPABILITY:
                    combat++;
                    break;
            }
        }
        return getChoiceFromVotes(population, wealth, combat);
    }

}
