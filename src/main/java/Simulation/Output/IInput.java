package Simulation.Output;

import java.util.List;

/**
 * Interface used as simulation input
 */
public interface IInput {
    /**
     * @return starting village population size
     */
    long loadPopulation();

    /**
     * @return starting village wealth amount
     */
    long loadWealth();

    /**
     * @return starting village combat capability
     */
    long loadCombatCapability();

    /**
     * @return list of event names used for random events
     */
    List<String> getRandomEventNames();
}
