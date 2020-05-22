package Simulation.Output;

public class ConsoleOutput implements  IOutput{
    @Override
    public void write(String string) {
        System.out.println(string);
    }
}
