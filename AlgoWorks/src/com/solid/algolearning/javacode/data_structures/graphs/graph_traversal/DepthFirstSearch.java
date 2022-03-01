package com.solid.algolearning.javacode.data_structures.graphs.graph_traversal;

import java.util.*;

public class DepthFirstSearch {
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

        ArrayList<Integer> result = new ArrayList<>();
        System.out.println(adjacencyList);
        System.out.println(depthFirstSearch(adjacencyList, 0));
        System.out.println(depthFirstSearchRecursive(adjacencyList, result, 0));
    }


    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
//        adj.get(v).add(u); for undirected graph
    }

    private static ArrayList<Integer> depthFirstSearch(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visitedNodes = new HashSet<>();

        stack.add(v);
        visitedNodes.add(v);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            result.add(vertex);
            ArrayList<Integer> adjacents = adj.get(vertex);

            for (Integer adjacent : adjacents) {
                if (!visitedNodes.contains(adjacent)) {
                    stack.add(adjacent);
                    visitedNodes.add(adjacent);
                }
            }
        }

        return result;
    }

    private static ArrayList<Integer> depthFirstSearchRecursive(ArrayList<ArrayList<Integer>> adj,
                                                                ArrayList<Integer> result, int v) {

        Set<Integer> visitedNodes = new HashSet<>();
        visitedNodes.add(v);
        result.add(v);

        ArrayList<Integer> adjacents = adj.get(v);

        for (Integer adjacent : adjacents) {
            if (!visitedNodes.contains(adjacent)) {
                return depthFirstSearchRecursive(adj, result, adjacent);
            }
        }

        return result;
    }
}
