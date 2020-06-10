package Simulation.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Use to load starting village parameters from console
 */
public class ConsoleInput implements IInput {

    Scanner scan = new Scanner(System.in);

    @Override
    public long loadPopulation() {
        System.out.println("Podaj startowa populacje: \n");
        return scan.nextLong();
    }

    @Override
    public long loadWealth() {
        System.out.println("Podaj startowe bogactwo: \n");
        return scan.nextLong();
    }

    @Override
    public long loadCombatCapability() {
        System.out.println("Podaj startowa zdolnosc bojowa: \n");
        return scan.nextLong();
    }

    @Override
    public List<String> getRandomEventNames() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Pogoda");
        names.add("Zbiory");
        names.add("Nauka");
        return names;
    }
}
