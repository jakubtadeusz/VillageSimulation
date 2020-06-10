package Simulation.Simulation;

import Simulation.Event.RandomEventGenerator;
import Simulation.Input.IInput;
import Simulation.Output.IOutput;

/**
 * Use to generate correct Simulation object based on IInput starting data and IOutput object
 */
public class SimulationFactory {

    private final IInput input;
    private final IOutput output;

    /**
     * @param input  input object
     * @param output output object
     */
    public SimulationFactory(IInput input, IOutput output) {
        this.input = input;
        this.output = output;
    }

    /**
     * @return Simulation object
     */
    public Simulation create() {
        Village startingVillage = new Village(input.loadPopulation(), input.loadWealth(), input.loadCombatCapability());
        RandomEventGenerator randomEventGenerator = new RandomEventGenerator(input.getRandomEventNames());
        return new Simulation(startingVillage, randomEventGenerator, output);
    }
}
