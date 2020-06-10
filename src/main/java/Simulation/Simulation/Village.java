package Simulation.Simulation;

/**
 * Class that store information about Village parameters
 */
public class Village {
    private long population;
    private long wealth;
    private long combatCapability;

    /**
     * @param population       population size
     * @param wealth           wealth amount
     * @param combatCapability combat capability, used to calculate battle results
     */
    public Village(long population, long wealth, long combatCapability) {
        this.population = population;
        this.wealth = wealth;
        this.combatCapability = combatCapability;
    }


    public long getPopulation() {
        return population;
    }


    public void setPopulation(long population) {
        this.population = population;
    }


    public long getWealth() {
        return wealth;
    }


    public void setWealth(long wealth) {
        this.wealth = wealth;
    }


    public long getCombatCapability() {
        return combatCapability;
    }


    public void setCombatCapability(long combatCapability) {
        this.combatCapability = combatCapability;
    }

    /**
     * @return information if village is not dead
     */
    public Boolean isOK() {
        return getPopulation() > 0 && getWealth() > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Village village = (Village) obj;
        return village.getPopulation() == this.getPopulation()
                && (village.getWealth() == this.getWealth()
                && (village.getCombatCapability() == this.getCombatCapability()));
    }
}
