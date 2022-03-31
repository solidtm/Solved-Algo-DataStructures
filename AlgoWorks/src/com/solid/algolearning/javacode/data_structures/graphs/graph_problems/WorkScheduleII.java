package com.solid.algolearning.javacode.data_structures.graphs.graph_problems;

import java.util.*;
public class WorkScheduleII {
    public static void main(String[] args) {

    }

    //we will use dfs and topological sort implementation to solve this question
    //but, we will not do the basic implementation of topological sort
    //becuase it does not detect a cycle in a graph,
    //Hence we will implement topological sort in such a way that it will detect a cycle in the graph

    //first we write down the data structures we will need
    private List<Integer>[] graph;   //adjacency list graph representation.
    private int[] status;    //status array to hold the edges that have been unvisited, done or is explored
    private int[] result;     //our result array to hold the ordering
    private int index;         //will be used to add the nodes in the correct order in the result
    private final int UNVISITED = 0, EXPLORING = 1, DONE = 2;  //colors to be assigned to the nodes

    public int[] findOrder(int n, int[][] pq) { //n is numCourses & pq is prerequisites
        //initialize the variables above
        index = n;
        status = new int[n];
        result = new int[n];
        graph = new ArrayList[n];

        //initialize the graph
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        //convert the prerequisite 2d array to our adjacency list
        for(int[] edge : pq){
            int i = edge[0], j = edge[1];

            graph[j].add(i);  //this is adding the connection between the courses, finish course j before i
        }



        return hasCycle(n) ? new int[]{} : result;

    }


    public boolean hasCycle(int n){
        //loop through the edges and if the current edge has not been visited,
        for(int i = 0; i < n; i++){
            if(status[i] == UNVISITED && dfs(i)) return true;
        }

        return false;
    }

    public boolean dfs(int node){
        if(status[node] == EXPLORING){   //if we have this node being explored before
            return true;
        }else if(status[node] == DONE){  //
            return false;
        }


        //if above two cases is not satisfied, it means we are visiting the node for the first time.
        //hence, we need to mark the current node as exploring and also explore its edges.

        status[node] = EXPLORING;
        for(int neighbour : graph[node]){
            if(dfs(neighbour)) return true;   //recursively do dfs on the neighbours
        }

        status[node] = DONE;      //then we mark the node as done and
        result[--index] = node;   //add the node to the result array (remember we are adding in reverse)

        return false;
    }
}
