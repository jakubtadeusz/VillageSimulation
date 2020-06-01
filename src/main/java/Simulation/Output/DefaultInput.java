package Simulation.Output;

import java.util.ArrayList;
import java.util.List;

public class DefaultInput implements IInput {
    @Override
    public long loadPopulation() {
        return 100;
    }

    @Override
    public long loadWealth() {
        return 1000;
    }

    @Override
    public long loadCombatCapability() {
        return 200;
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
