package Simulation.Output;

import java.util.List;

public interface IInput {
    int loadPopulation();
    int loadWealth();
    int loadCombatCapability();
    List<String> getRandomEventNames();
}
