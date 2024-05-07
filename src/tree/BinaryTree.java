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
}

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}
