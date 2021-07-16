package com.solid.algolearning.javacode.algorithms.searching;

//QuickFind algorithm is an eager algorithm used to solve dynamic connectivity problems
//Implementation of the QuickFind Union-Find algorithm is that two objects are connected if and only if they have the same
//entry in the array

import java.util.Arrays;

//The Quick-Union algorithm is such that to get union(p, q) all the elements in connection to id[p] will be changed to
//the value of id[q].
public class QuickFindUF {

    private int[] id;

//    The constructor initializes the data structure(array) id[] with values of the counter.
    public QuickFindUF(int N){
        id = new int[N];

        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

//    Method to check if two objects in the array are connected, this is the quick-find itself.
//    Checks whether p and q are of the same components
    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

//    Union Method to union two objects nd implement the union algorithm above
//    hence setting the value of all element with the same value(ie connected to) as p_id to value of q_id
    public void union(int p, int q){
        int p_id = id[p];
        int q_id = id[q];

        for(int i = 0; i < id.length; i++){
            if(id[i] == p_id){
                id[i] = q_id;
            }
        }
    }

    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(10);
        quickFindUF.union(4, 3);
        System.out.println(Arrays.toString(quickFindUF.id));
        System.out.println(quickFindUF.connected(4, 3));

        quickFindUF.union(3, 8);
        System.out.println(Arrays.toString(quickFindUF.id));
        System.out.println(quickFindUF.connected(3, 8));

        quickFindUF.union(6, 5);
        System.out.println(Arrays.toString(quickFindUF.id));
        System.out.println(quickFindUF.connected(6, 5));

        quickFindUF.union(9, 4);
        System.out.println(Arrays.toString(quickFindUF.id));
        System.out.println(quickFindUF.connected(9, 4));

        quickFindUF.union(2, 1);
        System.out.println(Arrays.toString(quickFindUF.id));
        System.out.println(quickFindUF.connected(2, 1));

        quickFindUF.union(5, 0);
        System.out.println(Arrays.toString(quickFindUF.id));
        System.out.println(quickFindUF.connected(5, 0));

        quickFindUF.union(7, 2);
        System.out.println(Arrays.toString(quickFindUF.id));
        System.out.println(quickFindUF.connected(7, 2));

        quickFindUF.union(7, 3);
        System.out.println(Arrays.toString(quickFindUF.id));
        System.out.println(quickFindUF.connected(7, 3));
    }
}
