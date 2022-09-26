package com.solid.algolearning.javacode.data_structures.tries;

public class Trie {
    private TrieNode root; //Root Node

    //Constructor
    Trie(){
        root = new TrieNode();
    }
    //Function to get the index of a character 'x'
    public int getIndex(char x)
    {
        return x - 'a';  // the index is based on the position of character in alphabets
    }

    //Function to get root
    public TrieNode getRoot() {
        return root;
    }

    //Function to insert a key in the Trie
    public void insert(String key)
    {
        if(key == null) //Null keys are not allowed
        {
            System.out.println("Null Key can not be Inserted!");
            return;
        }
        key = key.toLowerCase(); //Keys are stored in lowercase
        TrieNode currentNode = this.root;
        int index = 0; //to store character index

        //Iterate the Trie with given character index,
        //If it is null, then simply create a TrieNode and go down a level
        for (int level = 0; level < key.length(); level++)
        {
            index = getIndex(key.charAt(level));
            if(currentNode.children[index] == null)
            {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        //Mark the end character as leaf node
        currentNode.markAsLeaf();
    }

    //Function to search given key in Trie
    public boolean search(String key) {

        if (key == null) return false; //Null Key

        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0;

        //Iterate the Trie with given character index,
        //If it is null at any point then we stop and return false
        //We will return true only if we reach leafNode and have traversed the
        //Trie based on the length of the key

        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currentNode.children[index] == null) return false;
            currentNode = currentNode.children[index];
        }


        return currentNode.isEndWord;
    }

    //Helper Function to return true if currentNode does not have any children
    private boolean hasNoChildren(TrieNode currentNode){
        for (int i = 0; i < currentNode.children.length; i++){
            if ((currentNode.children[i]) != null)
                return false;
        }
        return true;
    }

    //Recursive function to delete given key
    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level)
    {
        boolean deletedSelf = false;

        if (currentNode == null){
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length){
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (hasNoChildren(currentNode)){
                currentNode = null;
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else
            {
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        }
        else
        {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted)
            {
                //Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currentNode is part of another key
                //and hence we can not delete this node and it's parent path nodes
                if (currentNode.isEndWord){
                    deletedSelf = false;
                }
                //If childNode is deleted but if currentNode has more children then currentNode must be part of another key.
                //So, we cannot delete currenNode
                else if (!hasNoChildren(currentNode)){
                    deletedSelf = false;
                }
                //Else we can delete currentNode
                else{
                    currentNode = null;
                    deletedSelf = true;
                }
            }
            else
            {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    //Function to delete given key from Trie
    public void delete(String key){
        if ((root == null) || (key == null)){
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }

}


//Explanation#
//        The Insert() function (line # 14) takes an argument of a string key, indicating a word which will be stored for that particular word/key.
//
//        Null-keys are not allowed, and keys are stored in lowercase.
//
//        We simply iterate the key character by character, and we generate an index for each character using getIndex() (line # 9).
//        Afterward, we check the child of currentNode at that particular index,
//        and if it’s null then we create a new TrieNode at that index indicating the specific character of the given key.
//
//        In the end, we mark the currentNode as leaf; i.e we’re setting the last character as the end of the word we just stored as “key”.
//
//        Time Complexity#
//        If the length of the word is h, the worst-case time complexity is O(h)

//        In the worst case, at every level, i.e., for every character in the word, a TrieNode is created and inserted into the Trie.
//        The running time of the TrieNode constructor is O(d)

//        . Since the alphabet size is fixed, this is O(1)
//        . Thus, the running time of inserting in the trie is O(h).

//Explanation#
//        The Search() function takes in the “key” of type string as an argument and returns a boolean true or false based on
//        if the “key” is found in Trie or not.
//
//        As we know from insertion, null keys aren’t allowed and all characters are stored in lowercase.
//
//        Just like we did in insertion, we’ll traverse the key character by character, and for each character,
//        we will see if children exist for currentNode for that particular index. We generate an index of each character by calling getIndex()),
//        and we will simply return false if children don’t exist.
//        We only return true if the key is completely traversed and isEndWord() is set for the last node in the path.

//    If the length of the word is h, the worst-case time complexity is O(h). In the worst case, we have to look at h
//    consecutive levels of a trie for a character in the key being searched for.