package com.solid.algolearning.javacode.data_structures.graphs.graph_traversal;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        int v = 7;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        addEdge(adjacencyList, 0, 1);
        addEdge(adjacencyList, 0, 3);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 2, 6);
        addEdge(adjacencyList, 3, 4);
        addEdge(adjacencyList, 4, 5);
        addEdge(adjacencyList, 5, 6);

        System.out.println(adjacencyList);
        System.out.println(breadthFirstSearch(adjacencyList, 2));
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        adj.get(u).add(v);
//        adj.get(v).add(u); for undirected graph
    }


    static ArrayList<Integer> breadthFirstSearch(ArrayList<ArrayList<Integer>> adj, int v){
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> visitedNodes = new HashSet<>();

        queue.add(v);  //add the start node to queue
        visitedNodes.add(v); //mark the node as visited

        while(!queue.isEmpty()){  //while queue is not empty
            int vertex = queue.poll();   //remove the node from the queue
            result.add(vertex);     //and add it to the output
            ArrayList<Integer> adjacents = adj.get(vertex);  //get its adjacents to process them

            for (Integer adjacent : adjacents) {  //process adjacents
                if (!visitedNodes.contains(adjacent)) {
                    queue.add(adjacent);
                    visitedNodes.add(adjacent);
                }
            }

        }

      return result;
    }

}
