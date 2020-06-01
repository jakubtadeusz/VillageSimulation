package Simulation;

import Simulation.Output.*;

public abstract class ArgumentParser {

    public static IInput getIInputFromArgs(String[] args) {
        IInput input = new DefaultInput();
        if (args.length >= 2) {
            switch (args[0]) {
                case "console":
                    input = new ConsoleInput();
                    break;
                case "file":
                    if (args.length > 2) input = new FileInput(args[2]);
                    else input = new FileInput(SimulationConsts.DEFAULT_INPUT_FILE_NAME);
                    break;
                default:
                    break;
            }
        }
        return input;
    }

    public static IOutput getIOutputFromArgs(String[] args) {
        IOutput output = new ConsoleOutput();
        if (args.length >= 2) {
            switch (args[1]) {
                case "console":
                    output = new ConsoleOutput();
                    break;
                case "file":
                    if (args.length == 3) {
                        output = new FileOutput(args[2]);
                    } else if (args.length >= 4) output = new FileOutput(args[3]);
                    else output = new FileOutput(SimulationConsts.DEFAULT_OUTPUT_FILE_NAME);
                    break;
                case "default":
                    break;
            }
        }
        return output;
    }
}
