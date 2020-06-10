package Simulation.Output;

/**
 * Use to write simulation output to console
 */
public class ConsoleOutput implements IOutput {

    @Override
    public void write(String string) {
        System.out.println(string);
    }

    @Override
    public void close() {

    }
}
