package com.solid.algolearning.javacode.data_structures.graphs.graph_problems;

//Given a Directed Acyclic Graph (DAG), print it in topological order using topological sort algorithm.
//If the graph has more than one topological ordering, output any of them. Assume valid Directed Acyclic Graph (DAG).

//A Topological sort or Topological ordering of a directed graph is a linear ordering of its vertices
//such that for every directed edge uv from vertex u to vertex v, u comes before v in the ordering.
//A topological ordering is possible if and only if the graph has no directed cycles, i.e. if the graph is DAG.


//steps to achieve topological sorting in a directed acyclic graph
// 1. Find the in-degree of every vertex in the graph.
// 2. Start writing the topological ordering from the vertex with in-degree 0
// 3. After you have written down each node starting from the node with indegree as 0,
// 4. You have to remove that node with its outgoing edges and update the indegree of the other edges
//    by subtracting the number of deleted edges from the indegree of the subsequent vertices.
// 5. Repeat the process in 2 again and follow that order.
public class TopologicalSort {
    public static void main(String[] args) {

    }


}
