package Simulation.Output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Use to save simulation output in file
 */
public class FileOutput implements IOutput {
    FileWriter fileWriter;

    /**
     * @param filePath path of file used as output
     */
    public FileOutput(String filePath) {
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
        }

        try {
            fileWriter = new FileWriter(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void write(String string) {
        try {
            fileWriter.write("\n" + string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
