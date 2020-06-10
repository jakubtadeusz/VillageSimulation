package Simulation.Output;

/**
 * Interface used as simulation output
 */
public interface IOutput {
    /**
     * @param string output string
     */
    void write(String string);

    /**
     * Method is called after simulation is finished
     */
    void close();
}
