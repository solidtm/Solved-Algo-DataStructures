package com.solid.algolearning.javacode.data_structures.graphs.graph_representations;

//Here we create an n+1 by n+1 array, where we represent the vertices and the edges
//connecting them with 0 or 1 showing there is or is not a connection
import java.util.Arrays;

public class AdjacenyMatrix {
    public static void main(String[] args) {
      int n = 3, m = 3;  //this is the number of nodes and edges, it can be accepted as input

      int adjacencyMatrix[][] = new int[n + 1][n + 1];

      //edge between 1 and 2...both of them are here for the sake of undirected graphs
        adjacencyMatrix[1][2] = 1;
        adjacencyMatrix[2][1] = 1;

      //edge between 3 and 1
        adjacencyMatrix[3][1] = 1;
        adjacencyMatrix[1][3] = 1;  //vice cersa for undirected graph

        //In the case where we have a weighted graph, then,
        // we will represent the weight number for all the places
        //where we have a 1 ie, places we have a path.


        System.out.println(Arrays.deepToString(adjacencyMatrix));
    }


}
