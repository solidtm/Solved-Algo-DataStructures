package com.solid.algolearning.javacode.data_structures.graphs.graph_problems;

//This is an algorithm to find the shortest path from the source node to any particular node in a graph
//It uses the principle that the shortest path from the souce to any node in the graph
//has tocome from one of the shortest paths already calculated.
public class DijkstraAlgorithm {
    public static void main(String[] args) {
       int graph[][] = new int[][]{{0,1,5,0,0,0}, {0,0,2,2,1,0}, {0,0,0,0,2,0},
                                   {0,0,0,0,3,1}, {0,0,0,0,0,2}, {0,0,0,0,0,0}};

       dijkstra(graph, 0);

//       int[] visited = new int[6];  //6 is the number of vertices.
//       int min, nextNode = 0;
//       int[] previousVertexNode = new int[6];
//       int[] distance = new int[6];
//
//        System.out.println("The minimum distance(edge length) from the source vertex to the destination vertex is: ");
//
//        for (int i = 0; i < 6; i++) {  //represent the visited indexes to 0 because we have not visited any of the nodes
//            visited[i] = 0;
//            previousVertexNode[i] = 0;  //represent the predefined vertices array indices to 0 too because we have not visited any node.
//
//            for (int j = 0; j < 6; j++) {
//                if(graph[i][j] == 0){ //this means there are no edges or vertices in the graph
//                    graph[i][j] = 999;
//                }
//            }
//        }
//
//        distance = graph[0];    //the source vertex will be the first thing in the distance first, as we visit it first.
//        visited[0] = 1;         //so we have aready visited the source vertex, we mark it as visited.
//        distance[0] = 0;        //as there is no edge connecting the source vertex to the source vertex itself, the distance is 0.
//
//        for (int counter = 0; counter < 6; counter++) {
//            min = 999;
//            for (int i = 0; i < 6; i++) {
//                if (min > distance[i] && visited[i] != 1){
//                    min = distance[i];
//                    nextNode = i;
//                }
//            }
//
//            visited[nextNode] = 1;
//            for (int i = 0; i < 6; i++) {  //here we find the minimum distance.
//                if (visited[i] != 1){
//                    if (min + graph[nextNode][i] < distance[i]){
//                        distance[i] = min + graph[nextNode][i];
//                    }
//                }
//            }
//        }
//
//
//        for (int i = 0; i < 6; i++) { //priint the distance from source to vertices
//            System.out.println(i + "th distance from the source node: " + distance[i]);
//        }
    }


    static void dijkstra(int[][] graph, int src){
        int[] dist = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {  //initially the distance and visited arrays will be zero
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        //source vertex will be 0; as it is where we are starting from
        dist[0] = 0;
        visited[0] = true;

        for (int i = 0; i < graph.length; i++) {
            int index = minDistance(dist, visited);   //get the minimum index from the node.
            visited[index] = true;                    //mark that you have visited the index

            for (int j = 0; j < graph.length; j++) {
                if(!visited[i] && graph[index][j] != 0 && dist[j] != Integer.MAX_VALUE && dist[index] + graph[index][j] < dist[j]){
                    if(index + graph[index][j] < dist[j]){
                        dist[j] = dist[index] + graph[index][j];
                    }
                }
            }
        }

        for (int i = 0; i < 6; i++) { //priint the distance from source to vertices
            System.out.println(i + "th distance from the source node: " + dist[i]);
        }

    }

    private static int minDistance(int[] dist, boolean[] visited) { //this returs the index with the minimum distance from source
       int min = Integer.MAX_VALUE;
       int index = -1;

        for (int i = 0; i < dist.length; i++) {
            if(!visited[i] && dist[i] <= min){
                min = dist[i];
                index = i;
            }
        }

        return index;
    }
}
