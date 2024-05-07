package tree;

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

    static void inOrderTraversal(Node root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
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
