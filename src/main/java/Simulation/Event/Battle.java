package Simulation.Event;

import Simulation.Village;


import java.util.Random;

public class Battle extends Event {

    private Random random;

    public Battle(int difficulty) {
        super("Battle", difficulty);
        random = new Random();
    }

    /*@Override
    public void executeOnVillage(Village village, int difficulty) {
        int opponent = getNewOpponent(difficulty);
        if(opponent <  village.getCombatCapability()){
            village.setWealth(difficulty*random.nextInt(100) + village.getWealth());
        } else{
            village.setCombatCapability(village.getCombatCapability() - opponent*random.nextInt(100)/100);
            village.setWealth(village.getWealth() - difficulty*random.nextInt(100));
        }
    }*/

    private int getNewOpponent(int difficulty){
        return difficulty*random.nextInt(10);
    }
    public void runBattle(){

    }
}
