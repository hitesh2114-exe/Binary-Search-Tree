import java.util.*;

public class BinarySearchTree {
    Node root;

    class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //constructor for binarySearchTree
    public BinarySearchTree(){
        root = null;
    }

    //operations perforemd on BinarySearchTree are :-
    //1.insert()
    //2.contain()
  
    //insert method for inserting a node in binary tree
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
        }
        Node temp = root;
        while(true){
            if(newNode.value == temp.value) return false;
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }else{
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    //contain method to check wheather the value given is present or not
    public boolean contain(int value){
        Node temp = root;
        while(temp != null){
            if(value < temp.value){
                temp = temp.left;
            }else if(value > temp.value){
                temp = temp.right;
            }else{
                return true;
            }
        }
        return false;
    }

    //----------------------------------------------------------------------------------------
  
    //Recursive Binary Tree

    //methods performed on Recursive Binary Tree are :-
    //1. rConatins()
    //2. rInsert()
    //3. deleteNode()

    //method for checking if it contains the given value
    //start
    private boolean rContains(Node currentNode , int value){

        if(currentNode == null) return false;

        if(currentNode.value == value) return true;

        if(value < currentNode.value){
            return rContains(currentNode.left,value);
        }else{
            return rContains(currentNode.right,value);
        }
    }
    public boolean rContains(int value){
        return rContains(root,value);
    }
    //end

    //method for inserting the node
    //starts
    private Node rInsert(Node currentNode,int value){
        if(currentNode == null) return new Node(value);

        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left,value);
        }else if(value > currentNode.value){
            currentNode.right = rInsert(currentNode.right,value);
        }
        return currentNode;
    }
    public void rInsert(int value){
        if(root == null) root = new Node(value);
        rInsert(root,value);
    }
    //ends

    //method for deletion of Node form binary tree
    //start
    private Node deleteNode(Node currentNode, int value){
        if (currentNode == null) return null;
        if(value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left,value);
        }else if(value > currentNode.value){
            currentNode.right = deleteNode(currentNode.right,value);
        }else{
            if(currentNode.left == null && currentNode.right == null){
                return null;
            }else if(currentNode.left == null){
                currentNode = currentNode.right;
            } else if(currentNode.right == null) {
                currentNode = currentNode.left;
            }else{
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right,subTreeMin);
            }
        }
        return currentNode;
    }
    public void deleteNode(int value){
        deleteNode(root,value);
    }

    //helper method for finding the minimum node in the tree
    public int minValue(Node currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }
    
    //----------------------------------------------------------------------------------------

    //Tree Traversal
    //methods of Tree traversal are :-
    //1. Breadth First Search -> BSF()
    //2. Depth First Search :-
    // a. PreOrder -> DFSPreOrder()
    // b. PostOrder -> DFSPostOrder()
    // c. InOrder -> DFSInOrder()

    //Breadth First Search 
    public ArrayList<Integer> BFS(){

        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currentNode);

        while(queue.size() > 0){
            currentNode = queue.remove();
            result.add(currentNode.value);
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        return result;
    }

    //Depth First Search
    //preOrder
    public ArrayList<Integer> DFSPreOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal{
            public Traversal(Node currentNode) {
                result.add(currentNode.value);
                if(currentNode.left != null){
                    new Traversal(currentNode.left);
                }
                if(currentNode.right != null){
                    new Traversal(currentNode.right);
                }
            }
        }
        new Traversal(root);
        return result;
    }

    //postOrder
    public ArrayList<Integer> DSFPostOrder(){

        ArrayList<Integer> results = new ArrayList<>();

        class Traversal{
            public Traversal(Node currentNode){
                if(currentNode.left != null){
                    new Traversal(currentNode.left);
                }
                if(currentNode.right != null){
                    new Traversal(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }
        new Traversal(root);
        return results;
    }

    //InOrder
    public ArrayList<Integer> DSFInOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traversal{
            public Traversal(Node currentNode){
                if(currentNode.left != null){
                    new Traversal(currentNode.left);
                }
                result.add(currentNode.value);
                if(currentNode.right != null){
                    new Traversal(currentNode.right);
                }
            }
        }
        new Traversal(root);
        return result;
    }
}
