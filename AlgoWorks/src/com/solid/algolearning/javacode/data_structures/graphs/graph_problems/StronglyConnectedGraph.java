package com.solid.algolearning.javacode.data_structures.graphs.graph_problems;

import java.util.*;
public class StronglyConnectedGraph {

    public static void main(String[] args) {
        Graph graph;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 4));
        edges.add(new Edge(1, 0));
        edges.add(new Edge(1, 2));
        edges.add(new Edge(2, 4));
        edges.add(new Edge(2, 1));
        edges.add(new Edge(3, 1));
        edges.add(new Edge(3, 2));
        edges.add(new Edge(4, 3));
        graph = new Graph(edges, 5);

        System.out.println(isStronglyConnected(graph, 5));
    }

    // A class to store a graph edge
    static class Edge {
        int source, dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    // A class to represent a graph object
    static class Graph {
        // A list of lists to represent an adjacency list
        private final List<List<Integer>> adjList;

        // Constructor
        Graph(List<Edge> edges, int n) {
            adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            // add edges to the directed graph
            for (Edge edge : edges) {
                int src = edge.source;
                int dest = edge.dest;

                adjList.get(src).add(dest);
            }
        }

        public List<List<Integer>> getAdjList(){
            return adjList;
        }
    }

    // Function to perform DFS traversal on the graph on a graph
    private static void DFS(Graph graph, int v, boolean[] visited) {
        // mark current node as visited
        visited[v] = true;

        // do for every edge (v, u)
        for (int u : graph.getAdjList().get(v)) {
            // `u` is not visited
            if (!visited[u]) {
                DFS(graph, u, visited);
            }
        }
    }

    // Check if the graph is strongly connected or not
    public static boolean isStronglyConnected(Graph graph, int n) {

        // do for every vertex
        for (int i = 0; i < n; i++) {
            // to keep track of whether a vertex is visited or not
            boolean[] visited = new boolean[n];

            // start DFS from the first vertex
            DFS(graph, i, visited);

            // If DFS traversal doesn't visit all vertices,
            // then the graph is not strongly connected
            for (boolean b : visited) {
                if (!b) {
                    return false;
                }
            }
        }

        return true;
    }

}
