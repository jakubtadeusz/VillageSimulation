package Simulation.Output;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Use to load starting simulation parameters from file
 */
public class FileInput implements IInput {
    Scanner scanner;
    long population;
    long wealth;
    long combatCapability;
    List<String> randomEventNames = new ArrayList<>();

    /**
     * @param file path of file used as input
     */
    public FileInput(String file) {

        try {
            scanner = new Scanner(new File(file));
            population = scanner.nextLong();
            wealth = scanner.nextLong();
            combatCapability = scanner.nextLong();
            while (scanner.hasNext()) {
                randomEventNames.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public long loadPopulation() {
        return this.population;
    }

    @Override
    public long loadWealth() {
        return this.wealth;
    }

    @Override
    public long loadCombatCapability() {
        return this.combatCapability;
    }

    @Override
    public List<String> getRandomEventNames() {
        return this.randomEventNames;
    }


}
