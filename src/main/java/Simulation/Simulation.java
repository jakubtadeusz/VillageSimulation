package Simulation;

import Simulation.Event.Event;
import Simulation.Event.RandomEventGenerator;
import Simulation.VillageCouncil.VillageCouncil;

import java.util.Scanner;
import java.util.List;
import java.io.*;
import java.util.concurrent.TimeUnit;
/**
 * Simulation class is responsible for scanning starting params,
 * handling days logic and executing randomized events on village.
 * It shows actual simulation state.
 */

public class Simulation  {

    public Village village;
    public VillageCouncil villageCouncil;
    public int time = 0;

    public void start() {
        System.out.println("Simulation starts");
        scanStartingParams();
        nextDay();
    }

    public void nextDay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        time++;
        System.out.println("Day:" + time);
         if(village.isOK()){
             List<Event> events = RandomEventGenerator.getEvents(time/10);
             executeEvents(events);
             showVillageState();
             nextDay();
         }else{
               stop();
         }
    }

    private void stop() {
        System.out.println("Simulation completed.");
    }

    private void executeEvents(List<Event> eventList) {
        for (Event event : eventList) {
            event.executeOnVillage(village);
        }
    }
    private void showVillageState(){
        System.out.println("Actual village resources:\n"+
                "Wealth: "+village.getWealth()+
                "\nPopulation: "+ village.getPopulation()+
                "\nCombat capability: "+ village.getCombatCapability());
    }
    private void scanStartingParams(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Give starting params in order: Population, Wealth, Combat capability");
        int pop = scan.nextInt();
        int wel = scan.nextInt();
        int com = scan.nextInt();
        village = new Village(pop,wel,com);
    }
    private int getDifficulty() {
        return this.time / 10;
    }
}
