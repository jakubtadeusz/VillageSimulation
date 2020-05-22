package Simulation;

import Simulation.Output.ConsoleInput;
import Simulation.Output.ConsoleOutput;
import Simulation.Output.IInput;
import Simulation.Output.IOutput;

public class App {

    public static void main(String[] args) {

        IOutput output = new ConsoleOutput();
        IInput input = new ConsoleInput();
        Simulation simulation = new Simulation(input, output);
        simulation.start();
    }

}
