package bst;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 4, 2, 7};

        // Build the BST from the array
        BSTNode root = buildTree(nums);
        System.out.println("Result:" +2+3);

        // Search for different values in the BST
        System.out.println("Searching for 4: " + searchInBST(root, 4)); // Expected: true
        System.out.println("Searching for 6: " + searchInBST(root, 6)); // Expected: false

        // Print the BST in-order before deletion
        System.out.print("In-order traversal before deletion: ");
        printInOrder(root); // Expected to print the sorted elements of the BST
        System.out.println();

        // Delete a node
        root = deleteNode(root, 3); // Delete node with value 3
        System.out.print("In-order traversal after deleting 3: ");
        printInOrder(root); // Verify the in-order traversal after deletion
        System.out.println();

        validatePrintInRange(root, 0, 3);    // Test range that includes lowest values
        validatePrintInRange(root, 4, 5);    // Test range that includes the root
        validatePrintInRange(root, 6, 8);    // Test range with no nodes in the BST
        validatePrintInRange(root, 2, 4);    // Test range that includes middle values
        validatePrintInRange(root, 1, 7);    // Test range that includes almost all nodes

        // Function to print all root-to-leaf paths
        List<Integer> path = new ArrayList<>();
        rootToLeaf(root, path);
    }

    static BSTNode buildTree(int[] nums) {
        BSTNode node = null;
        for(int num : nums){
            node = buildTreeHelper(node, num);
        }
        return node;
    }

    static BSTNode buildTreeHelper(BSTNode root, int val){
        if(root == null) return new BSTNode(val);
        else if(val > root.data) {
            root.right = buildTreeHelper(root.right, val);
        } else {
            root.left = buildTreeHelper(root.left, val);
        }
        return root;
    }

    static boolean searchInBST(BSTNode root, int val){
        if(root == null) return false;
        if(root.data == val) return true;
        if(val > root.data){
            return searchInBST(root.right, val);
        }else{
            return searchInBST(root.left, val);
        }
    }

    static BSTNode deleteNode(BSTNode root, int val){
        if(root == null) return null;
        if(val > root.data){
            root.right = deleteNode(root.right, val);
        }else if(val < root.data) {
            root.left = deleteNode(root.left, val);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                BSTNode IS = inOrderSuccessor(root.right);
                root.data = IS.data;
                root.right = deleteNode(root.right, IS.data);
            }
        }

        return root;
    }

    static BSTNode inOrderSuccessor(BSTNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    static void printInOrder(BSTNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    static void printInRange(BSTNode root, int min, int max, List<Integer> result) {
        if (root == null) return;
        if (min < root.data) {
            printInRange(root.left, min, max, result);
        }

        if( min <= root.data && max >= root.data){
            result.add(root.data);
        }

        if (max > root.data) {
            printInRange(root.right, min, max, result);
        }
    }

    static void validatePrintInRange(BSTNode root, int min, int max) {
        List<Integer> result = new ArrayList<>();
        printInRange(root, min, max, result);
        System.out.println("Values in range [" + min + ", " + max + "]: " + result);
    }

    static void rootToLeaf(BSTNode root, List<Integer> path){
        if(root == null) return;
        path.add(root.data);
        if (root.left == null && root.right == null){
            //Best practice is to add loop block to a separate function.
            printPath(path);
        } else {
            rootToLeaf(root.left, path);
            rootToLeaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    static void printPath(List<Integer> path) {
        for (int value : path) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}


