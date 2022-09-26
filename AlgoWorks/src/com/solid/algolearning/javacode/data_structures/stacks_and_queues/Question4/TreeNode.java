package com.solid.algolearning.javacode.data_structures.stacks_and_queues.Question4;

//Binary tree node class :
class TreeNode<T>{
    //declaring the field instances
    public  T value;
    public TreeNode<T> left;
    public TreeNode<T> right;


    //constructing the node object
    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    //this method checks if the tree is empty
    public boolean isEmpty(){
        return this.value != null;
    }

    //method to insert a node into the binary tree
    public void insert(TreeNode<T> obj){
        if(!isEmpty()){
            if(left != null){
                left.insert(obj);
            }else{
                left = new TreeNode<>(obj.value, null, null);
            }
        }else {
            if (right != null){
                right.insert(obj);
            }else{
                right = new TreeNode<>(obj.value, null, null);
            }
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
