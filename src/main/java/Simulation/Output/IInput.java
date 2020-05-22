package Simulation.Output;

import java.util.List;

public interface IInput {
    long loadPopulation();
    long loadWealth();
    long loadCombatCapability();
    List<String> getRandomEventNames();
}
