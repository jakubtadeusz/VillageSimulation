package Simulation.Event;

import Simulation.Village;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    @Test
    void isBattleResultCorrect(){
        Village village = new Village(100, 10000, 1);
        Battle battle = new Battle(1000);
        battle.runBattle(village);
        Village changes = battle.getBattleResult();
        assertTrue(changes.getCombatCapability() <=0, "combat incorrect");
        assertTrue(changes.getWealth() <=0, "wealth incorrect");

        village.setCombatCapability(100000);
        battle = new Battle(1);
        battle.runBattle(village);
        changes = battle.getBattleResult();
        assertTrue(changes.getWealth() >= 0);
        assertTrue(changes.getCombatCapability() >= 0);
        assertTrue(changes.getPopulation() >= 0);
    }
}