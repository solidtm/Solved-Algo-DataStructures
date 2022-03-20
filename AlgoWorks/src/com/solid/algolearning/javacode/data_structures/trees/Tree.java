package com.solid.algolearning.javacode.data_structures.trees;

public class Tree {
   class Node{
       Node left, right;
       int data;

       public Node(int data){
           this.data = data;;
       }

       //inserts a node to the tree
       public void insert(int value){
           if(value <= data){
               if(left == null){
                   left = new Node(value);
               }else {
                   left.insert(value);
               }
           }else {
               if(right == null){
                   right = new Node(value);
               }else{
                   right.insert(value);
               }
           }
       }


//       checks if a node is available in the tree
       public boolean contains(int value){
           if(value == data) {
               return true;
           }else if(value < data){
               if(left == null){
                   return false;
               }else{
                   return left.contains(value);
               }
           }else{
               if(right == null){
                   return false;
               }else{
                   return right.contains(value);
               }
           }
       }


       public void printInOrder(){
           if(left != null){
               left.printInOrder();
           }
           System.out.println(data);

           if(right != null){
               right.printInOrder();
           }
       }

       public void printPreOrder(){
           System.out.println(data);
           if(left != null){
               left.printInOrder();
           }

           if(right != null){
               right.printInOrder();
           }
       }

       public void printPostOrder(){
           if(left != null){
               left.printInOrder();
           }

           if(right != null){
               right.printInOrder();
           }

           System.out.println(data);
       }
   }
}
