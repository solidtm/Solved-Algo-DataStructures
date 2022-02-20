package com.solid.algolearning.javacode.algorithms.patterns.tree_breadth_first_search;

 class LinkedTreeNode {
    int val;
    LinkedTreeNode left;
    LinkedTreeNode right;
    LinkedTreeNode next;

    LinkedTreeNode(int x) {
        val = x;
        left = right = next = null;
    }


    // level order traversal using 'next' pointer
    public void printLevelOrder() {
        LinkedTreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            LinkedTreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
