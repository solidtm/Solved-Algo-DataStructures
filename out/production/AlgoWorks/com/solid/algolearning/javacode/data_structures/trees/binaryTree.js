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

//The remove method is a bit more technical. Follow the steps
     remove(value){
        if(!this.root){         //if nothing exists in root return false
         return false;
        }

        let currentNode = this.root;    //Grab the currentNode as this.root first
        let parentNode = null;          //Initialize a parent node to be used.

      while(currentNode){       //we keep looping until we find a match
        if(value < currentNode.value){
        //go left
           parentNode = currentNode;
           currentNode = currentNode.left;

        }else if(value > currentNode.value){
        //go right
           parentNode = currentNode;
           currentNode = currentNode.right;
        }else if(currentNode.value === value){
         // We have found a match, get to work:
         //  Option 1: Current node has No right child:
              if(currentNode.right === null){
                if(parentNode === null){
                this.root = currentNode.left;
                }else{
                    //if parent > current value, make current left child a child of parent
                    if(currentNode.value < parentNode.value){
                        parentNode.left = currentNode.left;

                        //if parent < current value, make left child a right child of parent
                    }else if(currentNode,value > parentNode.value){
                        parentNode.right = currentNode.left;
                    }
                }
         // Option 2: Right child which doesn't have a left child
             }else if(currentNode.right.left === null){
                if (parentNode === null){
                    this.root = currentNode.left;
                }else{
                    currentNode.right.left = currentNode.left;
                    //if parent > current, make right child of the left value the parent
                    if(currentNode.value < parentNode.value){
                        parentNode.left = currentNode.right;

                     //if parent < current, make right child a right child of the parent
                    }else if(currentNode.value > parentNode.value){
                        parentNode.right = currentNode.right;
                    }
                }
         // Option 3: Right child that has a left child
             }else{
                   //find the right child's leftmost child
                   let leftmost = currentNode.right.left;
                   let leftmostParent = currentNode.right;
                   while(leftmost.left != null){
                     leftmostParent = leftmost;
                     leftmost = leftmost.left;
                   }

                   //Parent's left subtree is now leftmost's right subtree
                   leftmostParent.left = leftmost.right;
                   leftmost.left = currentNode.left;
                   leftmost.right = currentNode.right;

                   if(parentNode === null){
                        this.root = leftmost;
                   }else{
                        if(currentNode.value < parentNode.value){
                            parentNode.left = leftmost;
                        }else if(currentNode.value > parentNode.value){
                            parentNode.right = leftmost;
                        }
                   }
             }
             return true;
        }
      }
     }
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
