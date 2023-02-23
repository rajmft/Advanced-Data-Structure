package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;


public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testBST();
        testAVL();
        runBenchMark();
    }

    /**
     * Creates a BST and prints it out.
     */
    private static void testBST() {
        List<Integer> intList = new ArrayList<>();
        //Generate 20 random integers and insert them into a BST
        intList.addAll(ThreadLocalRandom.current().ints(10, 99)
                .distinct().limit(20).collect(ArrayList::new, ArrayList::add,
                ArrayList::addAll));

        BinarySearchTree<Integer> binST = new BinarySearchTree<>();

        for (int i = 0; i < intList.size(); i++) {
            binST.insert(intList.get(i));
        }

        binST.printSideways("Binary Search Tree");

        System.out.println("\nIs the BST full?: " + binST.isFull());
        System.out.println(
                "Number of leaf nodes in BST: " + binST.countLeafNodes());

    }

    /**
     * Creates an AVL Tree and prints it out while checking for balance.
     */
    private static void testAVL() {
        List<Integer> intList = new ArrayList<>();

        intList.addAll(Arrays.asList(32, 15, 5, 8, 40, 68, 18, 25, 17, 35, 33,
                39, 2, 98, 55, 96, 60));
        AVLTree<Integer> avltree = new AVLTree<>();

        for (int i = 0; i < intList.size(); i++) {
            avltree.insert(intList.get(i));
            avltree.checkBalance();
        }
        avltree.printSideways("AVL Tree");
        avltree.checkBalance();

        while (!avltree.isEmpty()) {
            avltree.remove(avltree.getRoot().element);
            avltree.printSideways("Remove root");
            avltree.checkBalance();
        }
    }

    /**
     * Runs a performance comparison between ordinary Binary Search Trees and
     * AVL trees.
     */
    private static void runBenchMark() {
        try {
            int n = 10000;
            int k = 10000;

            //BST Insertion Time 
            BinarySearchTree<Integer> binST = new BinarySearchTree<>();
            insertionTime(n, binST);

            //AVL Insertion Time
            AVLTree<Integer> avlTree = new AVLTree<>();
            insertionTime(n, avlTree);

            //BST Search Time
            BinarySearchTree<Integer> searchBST = new BinarySearchTree<>();
            searchTime(k, searchBST);

            //AVL Search Time
            AVLTree<Integer> searchAVL = new AVLTree<>();
            searchTime(k, searchAVL);

        } catch (UnsupportedOperationException e) {
            System.out.println("Not supported yet.");// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    /**
     * Calculates and prints the time required to insert n random integers into
     * a BST
     *
     * @param n is the amount of numbers to be inserted
     * @param b is the binary search tree in which n integers are inserted
     */
    public static void insertionTime(int n, BinarySearchTree<Integer> b) {
        Random rand = new Random();
        double initialTime, finalTime, totalTime;

        //Insertion
        initialTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int random = rand.nextInt();
            b.insert(random);
        }
        finalTime = System.currentTimeMillis();
        totalTime = finalTime - initialTime;
        System.out.println("It takes " + totalTime + " to insert " + n + " random "
                + "integers "
                + "into an empty BST.");

    }

    /**
     * Calculates and prints the time required to insert b random integers into
     * an AVL Tree
     *
     * @param n is the amount of numbers to be inserted into avl tree
     * @param a is the avl tree in which n random integers are inserted
     */
    public static void insertionTime(int n, AVLTree<Integer> a) {
        Random rand = new Random();
        double initialTime, finalTime, totalTime;

        //Insertion 
        initialTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int random = rand.nextInt();
            a.insert(random);
        }
        finalTime = System.currentTimeMillis();
        totalTime = finalTime - initialTime;
        System.out.println("It takes " + totalTime + " to insert " + n + 
                " random integers into an empty AVL tree.");

    }

    /**
     * Calculates and prints the time required to search for a random integer in
     * a bst
     *
     * @param k is the amount of random numbers searched
     * @param b is the bst being search
     */
    public static void searchTime(int k, BinarySearchTree<Integer> b) {
        double initialTime, finalTime, totalTime;

        List<Integer> intListBST = new ArrayList<>();
        intListBST.addAll(ThreadLocalRandom.current().ints(1000, 75000)
                .distinct().limit(k).collect(ArrayList::new, ArrayList::add,
                ArrayList::addAll));

        initialTime = System.currentTimeMillis();
        for (int i = 0; i < k; i++) {
            b.contains(intListBST.get(i));
        }
        finalTime = System.currentTimeMillis();
        totalTime = finalTime - initialTime;

        System.out.println("It takes " + totalTime + " to search for " + k + 
                " random integers in a BST.");

    }

    /**
     * Calculates and prints the time required to search for k random integers
     * in an avl tree
     *
     * @param k is the amount of random integers searched for
     * @param a is the avl tree
     */
    public static void searchTime(int k, AVLTree<Integer> a) {
        double initialTime, finalTime, totalTime;

        List<Integer> intListAVL = new ArrayList<>();
        intListAVL.addAll(ThreadLocalRandom.current().ints(1000, 75000)
                .distinct().limit(k).collect(ArrayList::new, ArrayList::add,
                ArrayList::addAll));

        initialTime = System.currentTimeMillis();
        for (int i = 0; i < k; i++) {
            a.contains(intListAVL.get(i));
        }
        finalTime = System.currentTimeMillis();
        totalTime = finalTime - initialTime;

        System.out.println("It takes " + totalTime + " to search for " + k + 
                " random integers in an AVL .");
    }

}
