package Simulation.VillageCouncil;

import java.util.Random;

public class CouncilMember {
    private int populationImportance;
    private int wealthImportance;
    private int combatCapabilityImportance;
    private Random random;

    public CouncilMember() {
        this.random = new Random();
        this.rerollMember();
    }

    protected void rerollMember() {
        this.populationImportance = random.nextInt(100);
        this.wealthImportance = random.nextInt(100);
        this.combatCapabilityImportance = random.nextInt(100);
    }

    protected MemberChoice getMemberChoice() {
        int max = this.combatCapabilityImportance + this.wealthImportance + this.populationImportance;
        int choice = random.nextInt(max);
        if (choice <= populationImportance) {
            return MemberChoice.POPULATION;
        } else if (choice >= max - this.wealthImportance) {
            return MemberChoice.WEALTH;
        } else return MemberChoice.COMBATCAPABILITY;
    }
}
