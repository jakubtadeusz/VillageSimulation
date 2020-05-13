package Simulation.Event;

import Simulation.Village;

import java.util.Random;

public class BattleEvent extends Event{
    private final int difficulty;
    private final Random random;

    public BattleEvent(int difficulty) {
        super("Battle", difficulty);
        random = new Random();
        this.difficulty = difficulty;
    }

    private int getNewOpponent(int difficulty){
        return difficulty*random.nextInt(10);
    }

    public void runBattle(Village village){
        int opponent = getNewOpponent(difficulty);
        if(opponent <  village.getCombatCapability()){
            this.setChanges(0, difficulty*random.nextInt(100) , 0);
        } else{
            this.setChanges(0, - difficulty*random.nextInt(100) , (-opponent*random.nextInt(100)/100));
        }
    }

    @Override
    public void executeOnVillage(Village village) {
        this.runBattle(village);
        super.executeOnVillage(village);
    }
}
