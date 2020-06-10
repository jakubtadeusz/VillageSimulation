package Simulation;

import Simulation.Output.IInput;
import Simulation.Output.IOutput;

/**
 * Main class
 */
public class App {

    public static void main(String[] args) {
        IInput input = ArgumentParser.getIInputFromArgs(args);
        IOutput output = ArgumentParser.getIOutputFromArgs(args);
        SimulationFactory simulationFactory = new SimulationFactory(input, output);
        Simulation simulation = simulationFactory.create();
        simulation.start();
    }

}
