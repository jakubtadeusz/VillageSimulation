package Simulation.App;

import Simulation.Input.IInput;
import Simulation.Output.IOutput;
import Simulation.Simulation.Simulation;
import Simulation.Simulation.SimulationFactory;

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
