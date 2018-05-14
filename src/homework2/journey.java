package homework2;

import java.util.ArrayList;

public class journey {
    private float distance;
    private journey from;
    private String name;

    public journey(float distance, journey from, String name) {
        this.distance = distance;
        this.from = from;
        this.name = name;
    }

    public journey(float distance, String name) {
        this.distance = distance;
        this.from = null;
        this.name = name;
    }

    public journey() {
        this.distance = 0;
        this.from = null;
        this.name = "";
    }

    public journey nextJourney(float distance, String name){
        journey nextjourney=new journey(distance,this,name);
        return nextjourney;
    }

    public float getDistance() {
        return distance;
    }

    public static ArrayList<journey> getJourneys(){
        ArrayList<journey> journeys=new ArrayList<>();
        journey journey0=new journey();
        journeys.add(journey0);
        journey journey1=journey0.nextJourney(100,"北京");
        journeys.add(journey1);
        journey journey2=journey1.nextJourney(50,"天津");
        journeys.add(journey2);
        journey journey3=journey2.nextJourney(500,"山东");
        journeys.add(journey3);
        journey journey4=journey3.nextJourney(100,"辽宁");
        journeys.add(journey4);
        return journeys;
    }

    public journey getFrom() {
        return from;
    }

    public String getName() {
        return name;
    }
}
