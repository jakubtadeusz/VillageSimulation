package Simulation.Event;

import Simulation.Village;

import java.util.Random;

import static Simulation.SimulationConsts.DIFFICULTY_CAP;

/**
 * Battle event
 */
public class BattleEvent extends Event {
    private static final int NEGATIVE_PUNISHMENT = 10;
    private static final int OPPONENT_SIZE_MODIFIER = 10;
    private final int difficulty;
    private final Random random;

    /**
     * @param difficulty battle difficulty
     */
    public BattleEvent(int difficulty) {
        super("Battle");
        random = new Random();
        this.difficulty = difficulty;
    }

    /**
     * @param village village object on which the battle will be proceeded
     * use to calculate battle result and set event changes
     */
    public void runBattle(Village village) {
        int opponent = getNewOpponent(difficulty);
        if (opponent < village.getCombatCapability()) {
            this.setChanges(0, difficulty * random.nextInt(DIFFICULTY_CAP), 0);
        } else {
            if (village.getCombatCapability() <= 0) {
                this.setChanges(0, -difficulty * random.nextInt(DIFFICULTY_CAP * NEGATIVE_PUNISHMENT), (-opponent * random.nextInt(DIFFICULTY_CAP * NEGATIVE_PUNISHMENT) / 100));
            } else {
                this.setChanges(0, -difficulty * random.nextInt(DIFFICULTY_CAP), (-opponent * random.nextInt(DIFFICULTY_CAP) / DIFFICULTY_CAP));
            }
        }
    }

    @Override
    public void executeOnVillage(Village village) {
        this.runBattle(village);
        super.executeOnVillage(village);
    }

    private int getNewOpponent(int difficulty) {
        return difficulty * random.nextInt(OPPONENT_SIZE_MODIFIER);
    }
}
