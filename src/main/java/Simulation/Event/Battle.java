package Simulation.Event;

import Simulation.Village;

import java.util.Random;

public class Battle{
    private final int difficulty;
    private Village changes;
    private Random random;

    public Battle(int difficulty) {
        random = new Random();
        this.difficulty = difficulty;
    }

    private int getNewOpponent(int difficulty){
        return difficulty*random.nextInt(10);
    }

    public void runBattle(Village village){
        int opponent = getNewOpponent(difficulty);
        this.changes = new Village(0, 0, 0);
        if(opponent <  village.getCombatCapability()){
            changes.setWealth(difficulty*random.nextInt(100) );
        } else{
            changes.setCombatCapability((-opponent*random.nextInt(100)/100));
            changes.setWealth(- difficulty*random.nextInt(100));
        }
    }

    public Village getBattleResult(){
        return this.changes;
    }
}
