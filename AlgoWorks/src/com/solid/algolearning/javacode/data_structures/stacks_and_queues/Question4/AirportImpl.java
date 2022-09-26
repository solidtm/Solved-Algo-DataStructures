package com.solid.algolearning.javacode.data_structures.stacks_and_queues.Question4;

public class AirportImpl {
    public static void main(String[] args) {
        Airport airport1 = new Airport("Helsinki Vantaa Airport", "Finland", 2);
        Airport airport2 = new Airport("Osaka Airport", "Japan", 3);
        Airport airport3 = new Airport("Porto Airport", "Portugal", 4);
        Airport airport4 = new Airport("Nagoya Airport", "Japan", 1);
        Airport airport5 = new Airport("Bangkok Airport", "Thailand", 5);
        Airport airport6 = new Airport("Quito Airport", "Ecuador", 8);
        Airport airport7 = new Airport("Malta International Airport", "Malta", 10);
        Airport airport8 = new Airport("Bali Airport", "Indonesia", 9);
        Airport airport9 = new Airport("Manau International Airport", "Brazil", 6);
        Airport airport10 = new Airport("Pittsburgh International Airport", "Pennsylvania, USA", 7);

//        Add airports to tree
        BinaryTreeImpl airports = new BinaryTreeImpl();
        airports.add(airport1);
        airports.add(airport2);
        airports.add(airport3);
        airports.add(airport4);
        airports.add(airport5);
        airports.add(airport6);
        airports.add(airport7);
        airports.add(airport8);
        airports.add(airport9);
        airports.add(airport10);

        System.out.println(airports);

//      check if airports tree is empty
        System.out.println(airports.isEmpty());

//      Count all nodes in airports
        System.out.println(airports.countNodes());

//      Find best airport
        Airport bestAirport = airports.findBestAirport();
        System.out.println(bestAirport.getAirportName());

//      Find the worst airport
        Airport worstAirport = airports.findWorstAirport();
        System.out.println(worstAirport.getAirportName());
    }
}
