public class Main {
    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        System.out.println("-Binary Search Tree :-");
        System.out.println("Initially...");
        //printing the value of root
        System.out.println("root = " + myBST.root);

        //calling the insert function
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(52);
        myBST.insert(82);
        myBST.insert(27);

        //for leaving the line
        System.out.println(" ");

        //printing the value of root after adding the items
        System.out.println("After adding items... \nroot = " + myBST.root.value);

        //for leaving the line
        System.out.println(" ");
        System.out.println("Checking if the given item is present in tree or not");

        //calling the contain() for checking if the element is present or not
        System.out.println("82 is present in tree : " + myBST.contain(82));
        System.out.println("17 is present in tree : " + myBST.contain(17));

        System.out.println("----------------------------------------");
        //-----------------------------------------------------------------------

        //Recursive Binary Tree
        System.out.println("-Recursive Binary Tree:-");
        BinarySearchTree rBST = new BinarySearchTree();

        //calling the rInsert() in recursive binary tree
        rBST.rInsert(2);
        rBST.rInsert(1);
        rBST.rInsert(3);

        System.out.println("Root: " + rBST.root.value);
        System.out.println("Root->left: " + rBST.root.left.value);
        System.out.println("Root->right: " + rBST.root.right.value);

        //for leaving the line
        System.out.println(" ");

        //for checking if the element is present or not, calling rContain()
        System.out.println("Checking if the item is present or not");
        System.out.println("1 is present in tree : " + rBST.rContains(1));
        System.out.println("17 is present in tree : " + rBST.rContains(17));

        System.out.println(" ");

        //calling the deleteNode() for deleting the node
        rBST.deleteNode(3);

        System.out.println("After deleting the Node with value 3");
        System.out.println("Root: " + rBST.root.value);
        System.out.println("Root->left: " + rBST.root.left.value);
        System.out.println("Root->right: " + rBST.root.right);

        System.out.println("----------------------------------------");
        //-----------------------------------------------------------------------

        //Tree Traversal
        System.out.println("-Tree Traversal:-");
        BinarySearchTree tBST = new BinarySearchTree();

        //inserting the items
        tBST.insert(47);
        tBST.insert(21);
        tBST.insert(76);
        tBST.insert(18);
        tBST.insert(27);
        tBST.insert(52);
        tBST.insert(82);

        System.out.println();
        System.out.println("In Breadth First Search " + tBST.BFS());    //calling BFS()
        System.out.println("DSF PreOrder " + tBST.DFSPreOrder());       //calling DFSPreOrder()
        System.out.println("DSF PostOrder " + tBST.DSFPostOrder());     //calling DSFPostOrder()
        System.out.println("DSF InOrder " + tBST.DSFInOrder());         //calling DSFInOrder()
    }
}
