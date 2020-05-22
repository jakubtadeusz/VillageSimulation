package Simulation;

import Simulation.Output.*;

public class App {

    public static void main(String[] args) {
        IInput input = new DefaultInput();
        IOutput output = new ConsoleOutput();

        if (args.length >=2) {
            switch (args[0]) {
                case "console":
                    input = new ConsoleInput();
                    break;
                case "file":
                    if(args.length >2)input = new FileInput(args[2]);
                    else input = new FileInput("config.txt");
                    break;
                default:
                    break;
            }
                switch (args[1]) {
                    case "console":
                        output = new ConsoleOutput();
                        break;
                    case "file":
                        if(args.length >2)output = new FileOutput(args[3]);
                        else output = new FileOutput("file.txt");
                        break;
                    case "default":
                        break;
                }

        }
        Simulation simulation = new Simulation(input, output);
        simulation.start();
    }


}
