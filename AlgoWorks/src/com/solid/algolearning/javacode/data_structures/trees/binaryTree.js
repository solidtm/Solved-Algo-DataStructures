class Node{
    constructor(value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
}

function traverse(node){
    const tree = {value: node.value};
    tree.left = node.left === null ? null : traverse(node.left); 
    tree.right = node.right === null ? null : traverse(node.right);

    return tree;
}

class BinarySearchTree{

    constructor(){
        this.root = null;
    }

    insert(value){
        let newNode = new Node(value);
        if(this.root === null){
            this.root = newNode;
        }else{
            let currentNode = this.root;
            while(true){
                if(value < currentNode.value){
                    // Go left
                    if(!currentNode.left){  //if there is no current node.left value
                        currentNode.left = newNode;
                        return this;
                    }
                    currentNode = currentNode.left;  //assign the left prop of the currentNode to to be the currentNode

                }else {// if  value > currentNode.value
                    // go right
                    if(!currentNode.right){
                        currentNode.right = newNode;
                        return this;
                    }
                    currentNode = currentNode.right;
                }
            }
        }      
       return this;
    }

    lookup(value){
      if(!this.root){
        return false;
      }
      let currentNode = this.root;
      while(currentNode){ //will terminate if currentNode is null.
        if(value < currentNode.value){
          currentNode = currentNode.left;
        }else if(value > currentNode.value){
          currentNode = currentNode.right;
        }else if(currentNode.value === value){
            return currentNode.value
        }
      }

      return false;
    }

    // remove(value){

    // }
}

const bst = new BinarySearchTree();

bst.insert(9);
bst.insert(4);
bst.insert(20);
bst.insert(1);
bst.insert(6);
bst.insert(15);
bst.insert(170);
bst.lookup(170);

// JSON.stringify(traverse(bst.root))
