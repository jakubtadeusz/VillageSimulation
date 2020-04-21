package Simulation;

public class Village {
    private int population;
    private int wealth;
    private int combatCapability;


    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getWealth() {
        return wealth;
    }

    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

    public int getCombatCapability() {
        return combatCapability;
    }

    public void setCombatCapability(int combatCapability) {
        this.combatCapability = combatCapability;
    }

    public Boolean isOK() {
        return true;
    }
}
