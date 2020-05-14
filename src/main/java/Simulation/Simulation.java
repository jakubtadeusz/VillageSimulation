package Simulation;

import Simulation.Event.Event;
import Simulation.Event.RandomEventGenerator;
import Simulation.Output.IInput;
import Simulation.Output.IOutput;
import Simulation.VillageCouncil.VillageCouncil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    public Village village;
    public VillageCouncil villageCouncil;
    RandomEventGenerator randomEventGenerator;
    public int time = 0;
    IInput input;
    IOutput output;

    public Simulation() {
        input = new IInput() {

            Scanner scan = new Scanner(System.in);

            @Override
            public int loadPopulation() {
                return scan.nextInt();
            }

            @Override
            public int loadWealth() {
                return scan.nextInt();
            }

            @Override
            public int loadCombatCapability() {
                return scan.nextInt();
            }

            @Override
            public List<String> getRandomEventNames() {
                ArrayList<String> names = new ArrayList<>();
                names.add("Pogoda");
                names.add("Zbiory");
                names.add("Nauka");
                return names;
            }
        };

        output = new IOutput() {
            @Override
            public void write(String string) {
                System.out.println(string);
            }
        };

        randomEventGenerator = new RandomEventGenerator(input.getRandomEventNames());
    }

    public void start() {
        output.write("Symulacja sie zaczyna");
        int pop = input.loadPopulation();
        int wel = input.loadWealth();
        int com = input.loadCombatCapability();
        village = new Village(pop, wel, com);
        villageCouncil = new VillageCouncil(pop/100 + 1);
        nextDay();
    }

    public void nextDay() {
        /*try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }*/
        time++;
        output.write("Dzien: " + time);
        if (village.isOK()) {
            List<Event> events = randomEventGenerator.getEvents(time / 10 + 1, getDifficulty());
            events.addAll(villageCouncil.getChoices(time/10 + 1, getDifficulty()));
            executeEvents(events);
            nextDay();
        } else {
            stop();
        }
    }

    private void stop() {
        output.write("Symulacja zakonczona.");
    }

    private void executeEvents(List<Event> eventList) {
        for (Event event : eventList) {
            event.executeOnVillage(village);
            output.write(event.toString());
        }
    }

    private int getDifficulty() {
        return this.time;
    }
}
