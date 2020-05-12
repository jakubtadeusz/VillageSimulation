package Simulation;

public class Village {

    private int population;
    private int wealth;
    private int combatCapability;
    public Village (int population, int wealth, int combatCapability){
        this.population = population;
        this.wealth=wealth;
        this.combatCapability = combatCapability;
    }



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
        if(this.population > 0)return true;
        else return false;
    }
}
