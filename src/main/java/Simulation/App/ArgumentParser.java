package Simulation.App;

import Simulation.Input.ConsoleInput;
import Simulation.Input.DefaultInput;
import Simulation.Input.FileInput;
import Simulation.Input.IInput;
import Simulation.Output.*;

/**
 * Use to parse argument from String array and generate appropriate IOutput and IInput classes <br>
 * With first two arguments you can choose IInput and IOutput implementation <br>
 * "console" - Use console stream to load params or write output <br>
 * "file" - Use file to load params or write output, can add 3rd or 4th arguments to choose file path. Default ones are saved in SimulatioConsts class
 */
public abstract class ArgumentParser {

    /**
     * @param args app params from main
     * @return input object
     * use to get IInput object from args
     */
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

    /**
     * @param args app params from main
     * @return output object
     * use to get IOutput object from args
     */
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
