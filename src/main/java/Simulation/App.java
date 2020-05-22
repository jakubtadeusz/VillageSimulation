package Simulation;

import Simulation.Output.*;

public class App {

    public static void main(String[] args) {
        IInput input = new DefaultInput();
        IOutput output = new ConsoleOutput();

        if (args.length > 0) {
            switch (args[0]) {
                case "console":
                    input = new ConsoleInput();
                    break;
                case "file":
                    input = new FileInput(args[2]);
                    break;
                case "default":
                    break;
            }

            if (args[1] != null) {
                switch (args[1]) {
                    case "console":
                        output = new ConsoleOutput();
                        break;
                    case "file":
                        output = new FileOutput(args[3]);
                        break;
                    case "default":
                        break;
                }
            }
        }
        Simulation simulation = new Simulation(input, output);
        simulation.start();
    }

}
