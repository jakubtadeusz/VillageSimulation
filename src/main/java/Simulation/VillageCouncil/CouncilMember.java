package Simulation.VillageCouncil;

import java.util.Random;

/**
 * Member of Village council, can generate MemberChoice
 */
public class CouncilMember {
    private static final int IMPORTANCE_CAP = 100;
    private int populationImportance;
    private int wealthImportance;
    private int combatCapabilityImportance;
    private final Random random;

    /**
     * create member with random preferences
     */
    public CouncilMember() {
        this.random = new Random();
        this.rerollMember();
    }

    /**
     * generate new member preferences
     */
    protected void rerollMember() {
        this.populationImportance = random.nextInt(IMPORTANCE_CAP);
        this.wealthImportance = random.nextInt(IMPORTANCE_CAP);
        this.combatCapabilityImportance = random.nextInt(IMPORTANCE_CAP);
    }

    /**
     * @return member choice, depends on member preferences
     * use to get member choice
     */
    protected MemberChoice getMemberChoice() {
        int max = this.combatCapabilityImportance + this.wealthImportance + this.populationImportance;
        int choice = random.nextInt(max);
        if (choice <= populationImportance) {
            return MemberChoice.POPULATION;
        } else if (choice >= max - this.wealthImportance) {
            return MemberChoice.WEALTH;
        } else return MemberChoice.COMBAT_CAPABILITY;
    }
}
