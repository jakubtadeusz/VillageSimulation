package Simulation.VillageCouncil;

import java.util.Random;

public class CouncilMember {
    private static final int IMPORTANCE_CAP = 100;
    private int populationImportance;
    private int wealthImportance;
    private int combatCapabilityImportance;
    private final Random random;

    public CouncilMember() {
        this.random = new Random();
        this.rerollMember();
    }

    protected void rerollMember() {
        this.populationImportance = random.nextInt(IMPORTANCE_CAP);
        this.wealthImportance = random.nextInt(IMPORTANCE_CAP);
        this.combatCapabilityImportance = random.nextInt(IMPORTANCE_CAP);
    }

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
