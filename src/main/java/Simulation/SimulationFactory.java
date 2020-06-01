package Simulation;

import Simulation.Event.RandomEventGenerator;
import Simulation.Output.IInput;
import Simulation.Output.IOutput;

public class SimulationFactory {

    private final IInput input;
    private final IOutput output;

    public SimulationFactory(IInput input, IOutput output) {
        this.input = input;
        this.output = output;
    }

    public Simulation create() {
        Village startingVillage = new Village(input.loadPopulation(), input.loadWealth(), input.loadCombatCapability());
        RandomEventGenerator randomEventGenerator = new RandomEventGenerator(input.getRandomEventNames());
        return new Simulation(startingVillage, randomEventGenerator, output);
    }
}
