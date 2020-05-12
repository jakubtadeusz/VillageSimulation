package Simulation;

import Simulation.Event.Event;
import Simulation.VillageCouncil.VillageCouncil;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Simulation  {

    public Village village;
    public VillageCouncil villageCouncil;
    public int time = 0;




    public void start() {
        System.out.println("Symulacja sie zaczyna");
        Scanner scan = new Scanner(System.in);
        int pop = scan.nextInt();
        int wel = scan.nextInt();
        int com = scan.nextInt();
        village = new Village(pop,wel,com);
        nextDay();
    }

    public void nextDay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    time++;
    System.out.println("Dzien:" + time);
    if(village.isOK()){
//        List<Event> events = RandomEventGenerator.getEvents(time/100, 10);
      //  executeEvents(events);
        System.out.println("execute events");
        nextDay();
    }else{
        stop();
    }
    }

    private void stop() {
        System.out.println("Symulacja zakonczona.");
    }

    private void executeEvents(List<Event> eventList) {
        for (Event event : eventList) {
            event.executeOnVillage(village);
        }
    }

    private int getDifficulty() {
        return this.time / 10;
    }
}
