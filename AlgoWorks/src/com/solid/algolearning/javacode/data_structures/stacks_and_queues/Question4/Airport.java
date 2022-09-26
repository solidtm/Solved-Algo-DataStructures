package com.solid.algolearning.javacode.data_structures.stacks_and_queues.Question4;

public class Airport {
    private final String airportName;
    private final String location;
    private final int waitIndex;

    public Airport(){
        this.airportName = "";
        this.location = "";
        this.waitIndex = 0;
    }

    public Airport(String name, String loc, int index){
        this.airportName = name;
        this.location = loc;
        this.waitIndex = index;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getLocation() {
        return location;
    }


    public int getWaitIndex() {
        return waitIndex;
    }
}
