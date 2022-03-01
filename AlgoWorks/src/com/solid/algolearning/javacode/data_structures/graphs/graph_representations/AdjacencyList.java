package com.solid.algolearning.javacode.data_structures.graphs.graph_representations;

import java.util.ArrayList;
import java.util.Arrays;

//Here we are using an arraylist of arraylists
//So basically, every index arraylist is storing all the arraylists adjacent to it
//
public class AdjacencyList {
    public static void main(String[] args) {
        int n = 3; int m = 3;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        //suppose we want to add connected vertices the general formular for 2 nodes u and v is:
//        adjacencyList.get(u).add(v);     //both are because of undirected graph
//        adjacencyList.get(v).add(u);


        //connect nodes/vertices 1 and 2
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);

        //conntce vertices 2 and 3
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(2);

        //add edge 1 -> 3
        adjacencyList.get(1).add(3);
        adjacencyList.get(3).add(1);

        System.out.println(adjacencyList.toString());
    }
}
