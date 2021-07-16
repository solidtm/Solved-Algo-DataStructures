package com.solid.algolearning.javacode.algorithms.searching;

public class StopWatch {
    private final long start;

    //Constructor
    public StopWatch(){
        start = System.currentTimeMillis();
    }

    /*Method to return the elapsed CPU time(in seconds) since the stopwatch was created
    */
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
