package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static int idx = -1;
    public static void main(String[] args) {
        int[] array = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = createBinaryTree(array);

        System.out.println("Beginning of pre Order Traversal");
        preOrderTraversal(root);

        System.out.println("Beginning of post Order Traversal");
        postOrderTraversal(root);

        System.out.println("Beginning of in Order Traversal");
        inOrderTraversal(root);

        System.out.println("Beginning of Level Order Traversal");
        levelOrderTraversal(root);

        System.out.println("Count of Nodes : " + countOfNodes(root));
        System.out.println("Sum of Nodes : " + sumOfNodes(root));

        System.out.println("Height of a tree : " + heightOfATree(root));

        System.out.println("Diameter of a tree, Naive n^2 solution: " + diameterNaiveSolution(root));
        System.out.println("Diameter of a tree, Naive O(N) solution: : " + diameterOptimizedSolution(root).diameter);

        System.out.println("Sum of nodes at kth level i.e level 3 : " + sumOfNodesAtKthLevel(root, 2));

        System.out.println("Size of a Binary Tree : " + sizeOfABinaryTree(root));
    }

    static Node createBinaryTree(int[] array){

        idx++;
        if(array[idx] == -1){
            return null;
        }

        Node root = new Node(array[idx]);
        root.left = createBinaryTree(array);
        root.right = createBinaryTree(array);
        return root;
    }

    static void preOrderTraversal(Node root){
        if(root == null) return;
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    static void levelOrderTraversal(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node current = q.poll();
            System.out.println(current.data);

            if(current.left != null){
                q.add(current.left);
            }

            if(current.right != null){
                q.add(current.right);
            }
        }
    }

    static void inOrderTraversal(Node root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    static int countOfNodes(Node root){
        if(root == null) return 0;
        int leftCount = countOfNodes(root.left);
        int rightCount = countOfNodes(root.right);
        return leftCount + rightCount + 1;
    }

    static int sumOfNodes(Node root){
        if(root == null) return 0;
        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    static int heightOfATree(Node root){
        if(root == null) return 0;
        int leftHeight = heightOfATree(root.left);
        int rightHeight = heightOfATree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static int diameterNaiveSolution(Node root){
        if(root == null) return 0;
        int leftDiameter = diameterNaiveSolution(root.left);
        int rightDiameter = diameterNaiveSolution(root.right);
        int diameterWithRoot = heightOfATree(root.left) + heightOfATree(root.right) + 1;
        return Math.max(diameterWithRoot, Math.max(leftDiameter, rightDiameter));
    }

    static TreeInfo diameterOptimizedSolution(Node root){
        if(root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo leftTreeInfo = diameterOptimizedSolution(root.left);
        TreeInfo rightTreeInfo = diameterOptimizedSolution(root.right);

        int leftDiameter = leftTreeInfo.diameter;
        int rightDiameter = rightTreeInfo.diameter;
        int d3 = leftTreeInfo.height + rightTreeInfo.height + 1;
        int height = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;

        int diam = Math.max(Math.max(leftDiameter, rightDiameter), d3);
        TreeInfo treeInfo = new TreeInfo(height, diam);
        return treeInfo;
    }

    static boolean isSubtree(Node rootNode, Node subtreeNode){
        if (rootNode == null && subtreeNode == null) return true;
        if (rootNode == null) return false;
        if (subtreeNode == null) return true;
        return checkForSubtree(rootNode, subtreeNode);
    }

    static boolean checkForSubtree(Node rootNode, Node subtreeNode){
        if (rootNode == null) return false;
        if (rootNode.data == subtreeNode.data && matchTree(rootNode, subtreeNode)) {
            return true;
        }
        return checkForSubtree(rootNode.left, subtreeNode) || checkForSubtree(rootNode.right, subtreeNode);
    }

    static boolean matchTree(Node rootNode, Node subtreeNode){
        if (rootNode == null && subtreeNode == null) return true;
        if (rootNode == null || subtreeNode == null) return false;
        return rootNode.data == subtreeNode.data
                && matchTree(rootNode.left, subtreeNode.left)
                && matchTree(rootNode.right, subtreeNode.right);
    }

    static int sumOfNodesAtKthLevel(Node root, int k) {
        if (root == null) return 0; // Base case
        if (k == 0) return root.data;
        return sumOfNodesAtKthLevel(root.left, k - 1) + sumOfNodesAtKthLevel(root.right, k - 1);
    }

    static int sizeOfABinaryTree(Node root){
        if(root == null) return 0;
        int leftSize = sizeOfABinaryTree(root.left);
        int rightSize = sizeOfABinaryTree(root.right);
        return leftSize + rightSize + 1;
    }
}

class TreeInfo {

    int height;
    int diameter;

    TreeInfo(int height, int diameter){
        this.height = height;
        this.diameter = diameter;
    }
}

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}

