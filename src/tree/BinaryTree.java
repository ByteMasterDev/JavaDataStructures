package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTree {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode tree = constructBinaryTreeFromArray(array);

        System.out.println("Preorder Traversal:");
        preOrderTraversal(tree);
        System.out.println();

        System.out.println("Inorder Traversal:");
        inOrderTraversal(tree);
        System.out.println();

        System.out.println("Postorder Traversal:");
        postOrderTraversal(tree);
        System.out.println();

        System.out.println("Level Order Traversal:");
        levelOrderTraversal(tree);
        System.out.println();

        System.out.println("Number of Nodes in the Tree: " + countNodes(tree));
        System.out.println("Sum of All Nodes in the Tree: " + sumOfNodes(tree));
        System.out.println("Height of the Tree: " + heightOfATree(tree));
        System.out.println("Diameter of the Tree (Naive): " + diameterOfATreeNaive(tree));
        System.out.println("Diameter of the Tree (Optimized): " + diameterOfATreeOptimized(tree).diameter);
        System.out.println("Sum of Nodes at Kth Level (K=2): " + sumOfNodesAtKthLevel(tree, 2));
        System.out.println("Size of the Binary Tree: " + sizeOfABinaryTree(tree));
        System.out.println("Maximum Value in the Binary Tree: " + maxInABinaryTree(tree));

        System.out.println("Lowest Common Ancestor (LCA) of nodes 5 and 6 (Naive Approach):");
        TreeNode lcaNode = lcaNaive(tree, 5, 6);
        System.out.println("LCA Naive value: " + (lcaNode != null ? lcaNode.val : "null"));

        System.out.println("Lowest Common Ancestor (LCA) of nodes 5 and 6 (Optimized Approach):");
        TreeNode lcaNodeOptimized = lcaOptimized(tree, 5, 6);
        System.out.println("LCA Optimized value: " + (lcaNodeOptimized != null ? lcaNodeOptimized.val : "null"));

        List<Integer> leftView = new ArrayList<>();
        System.out.println("Left View of the Binary Tree:");
        leftViewOfABinaryTree(tree, leftView, 0);
        System.out.println(leftView);

        List<Integer> rightView = new ArrayList<>();
        System.out.println("Right View of the Binary Tree:");
        rightViewOfABinaryTree(tree, rightView, 0);
        System.out.println(rightView);

        System.out.println("Zigzag Level Order Traversal:");
        List<List<Integer>> zigzagResult = zigzagLevelOrder(tree);
        for (List<Integer> level : zigzagResult) {
            for (int val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("\nIs Complete Binary Tree: " + isCompleteBinaryTree(tree));
        System.out.println("Count of nodes in complete binary tree: " + countNodesInCompleteBinaryTree(tree));

        System.out.println("Children Sum Property: " + childrenSumProperty(tree));
        System.out.println("Is the Tree Balanced (Naive): " + isBalancedBinaryTreeNaive(tree));
        System.out.println("Is the Tree Balanced (Optimized): " + (isBalancedBinaryTreeOptimized(tree) != -1));
        System.out.println("Maximum Width of the Binary Tree: " + maxWidthOfBinaryTree(tree));

        System.out.println("Constructing Binary Tree from Inorder and Preorder:");
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        TreeNode constructedTree = constructBTFromInOrderAndPreOrder(inOrder, preOrder, 0, inOrder.length - 1);
        preOrderTraversal(constructedTree); // Validate construction
        System.out.println();

        System.out.println("Vertical Order Traversal (Not Optimized):");
        List<List<Integer>> verticalOrderNotOptimizedResult = verticalOrderNotOptimized(tree);
        System.out.println(verticalOrderNotOptimizedResult);

        System.out.println("Vertical Order Traversal (Optimized):");
        List<List<Integer>> verticalOrderOptimizedResult = verticalOrderOptimized(tree);
        System.out.println(verticalOrderOptimizedResult);

        System.out.println("Sum Root to Leaf Numbers: " + sumNumbers(tree));

        // Serialize and Deserialize
        System.out.println("Serialize Tree:");
        String serializedTree = serialize(tree);
        System.out.println(serializedTree);

        System.out.println("Deserialize Tree:");
        TreeNode deserializedTree = deserialize(serializedTree);
        preOrderTraversal(deserializedTree); // Validate deserialization

        int startNode1 = 5;
        int startNode2 = 4;
        int startNode3 = 6;

        System.out.println("Amount of time for infection to spread from node " + startNode1 + ": " + amountOfTime(tree, startNode1));
        System.out.println("Amount of time for infection to spread from node " + startNode2 + ": " + amountOfTime(tree, startNode2));
        System.out.println("Amount of time for infection to spread from node " + startNode3 + ": " + amountOfTime(tree, startNode3));
    }

    static int idx = -1;
    static TreeNode constructBinaryTreeFromArray(int[] array) {
      idx++;
      if(idx >= array.length) return null;
      if(array[idx] == -1) return null;
      TreeNode root = new TreeNode(array[idx]);
      root.left = constructBinaryTreeFromArray(array);
      root.right = constructBinaryTreeFromArray(array);
      return root;
    }

    static void preOrderTraversal(TreeNode root){
        if(root == null) return;
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void inOrderTraversal(TreeNode root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

    static void postOrderTraversal(TreeNode root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.val);
    }

    static void levelOrderTraversal(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                TreeNode current = q.poll();
                System.out.println(current.val);
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
        }
    }

    static int countNodes(TreeNode root){
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    static int sumOfNodes(TreeNode root){
        if(root == null) return 0;
        return root.val + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    static int heightOfATree(TreeNode root){
        if(root == null) return 0;
        int leftHeight = heightOfATree(root.left);
        int rightHeight = heightOfATree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static int diameterOfATreeNaive(TreeNode root){
        if(root == null) return 0;
        int leftDiameter = diameterOfATreeNaive(root.left);
        int rightDiameter = diameterOfATreeNaive(root.right);
        int leftHeight = heightOfATree(root.left);
        int rightHeight = heightOfATree(root.right);
        int diameterThroughRoot = leftHeight + rightHeight + 1;
        return Math.max(diameterThroughRoot, Math.max(leftDiameter, rightDiameter));
    }

    static TreeInfo diameterOfATreeOptimized(TreeNode root){
        if(root == null) return new TreeInfo(0,0);
        TreeInfo leftTree = diameterOfATreeOptimized(root.left);
        TreeInfo rightTree = diameterOfATreeOptimized(root.right);

        int leftDiam = leftTree.diameter;
        int rightDiam = rightTree.diameter;

        int leftHeight = leftTree.height;
        int rightHeight = rightTree.height;

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        int diameterThruRoot = leftHeight + rightHeight + 1;

        int myDiam = Math.max(diameterThruRoot, Math.max(leftDiam, rightDiam));
        return new TreeInfo(myHeight, myDiam);
    }

    static int sumOfNodesAtKthLevel(TreeNode root, int k){
        if(root == null) return 0;
        if(k == 0){
            return root.val;
        }
        return sumOfNodesAtKthLevel(root.left, k - 1) + sumOfNodesAtKthLevel(root.right, k - 1);
    }

    static int sizeOfABinaryTree(TreeNode root){
        if(root == null) return 0;
        return sizeOfABinaryTree(root.left) + sizeOfABinaryTree(root.right) + 1;
    }


    static int maxInABinaryTree(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        int leftVal = maxInABinaryTree(root.left);
        int rightVal = maxInABinaryTree(root.right);
        return Math.max(root.val, Math.max(leftVal, rightVal));
    }

    static void leftViewOfABinaryTree(TreeNode root, List<Integer> ls, int level) {
        if(root == null) return;
        if(level >= ls.size()) {
            ls.add(root.val);
            System.out.println(root.val);
        }
        leftViewOfABinaryTree(root.left, ls, level + 1);
        leftViewOfABinaryTree(root.right, ls, level + 1);
    }

    static void rightViewOfABinaryTree(TreeNode root, List<Integer> ls, int level) {
        if(root == null) return;
        if(level >= ls.size()) {
            ls.add(root.val);
        } else {
            ls.set(level, root.val); // Update the existing value at the current level
        }
        rightViewOfABinaryTree(root.left, ls, level + 1);
        rightViewOfABinaryTree(root.right, ls, level + 1);
    }

    static boolean childrenSumProperty(TreeNode root){
        if(root == null) return true;

        Integer leftVal = root.left != null ? root.left.val : 0;
        Integer rightVal = root.right != null ? root.right.val : 0;

        return root.val == leftVal + rightVal
                && childrenSumProperty(root.left)
                && childrenSumProperty(root.right);

    }

    static int maxWidthOfBinaryTree(TreeNode root){
        if (root == null) return 0;
        int maxWidth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int qSize = q.size();
            maxWidth = Math.max(maxWidth, qSize);

            for(int i=0; i<qSize; i++){
                TreeNode current = q.poll();
                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }
        }
        return maxWidth;
    }


//    int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
//    int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
    static int preOrderIdx = 0;
    static TreeNode constructBTFromInOrderAndPreOrder(int[] inOrder, int[] preOrder, int si, int ei) {
        if (si > ei || preOrderIdx >= preOrder.length) return null;
        int preOrderVal = preOrder[preOrderIdx++];
        TreeNode root = new TreeNode(preOrderVal);

        int inOrderIdx = 0;
        for(int i=si; i<ei; i++){
            if(inOrder[i] == preOrderVal){
                inOrderIdx = i;
                break;
            }
        }

        root.left = constructBTFromInOrderAndPreOrder(inOrder, preOrder, si, inOrderIdx - 1);
        root.right = constructBTFromInOrderAndPreOrder(inOrder, preOrder, inOrderIdx + 1, ei);
        return root;
    }

    // Leetcode: 103
    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        boolean reverse = false;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        q.add(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode current = q.poll();
                if (!reverse) {
                    innerList.add(current.val);
                } else {
                    s.push(current.val);
                }

                if(current.left != null) q.add(current.left);
                if(current.right != null) q.add(current.right);
            }

            if(reverse){
                while(!s.isEmpty()){
                    innerList.add(s.pop());
                }
            }

            result.add(innerList);
            reverse = !reverse;
        }

        return result;

    }

    static TreeNode lcaNaive(TreeNode root, int valOne, int valTwo) {
        List<TreeNode> ancestorOne = new ArrayList<>();
        List<TreeNode> ancestorTwo = new ArrayList<>();

        if(!findPath(root, valOne, ancestorOne) || !findPath(root, valTwo, ancestorTwo)) return null;

        int min = Math.min(ancestorOne.size(), ancestorTwo.size());
        for(int i=0; i<min-1; i++){
            if(ancestorOne.get(i+1) != ancestorTwo.get(i+1)){
                return ancestorOne.get(i);
            }
        }

        return ancestorOne.get(min - 1);

    }

    static boolean findPath(TreeNode root, int val, List<TreeNode> ancestors){
        if(root == null) return false;
        ancestors.add(root);
        if (root.val == val) {
            return true;
        }
        if(findPath(root.left, val, ancestors) || findPath(root.right, val, ancestors)) return true;
        ancestors.remove(ancestors.size() - 1);
        return false;
    }

    static TreeNode lcaOptimized(TreeNode root, int valOne, int valTwo){
        if(root == null) return null;
        if(root.val == valOne || root.val == valTwo) return root;
        TreeNode left = lcaOptimized(root.left, valOne, valTwo);
        TreeNode right = lcaOptimized(root.right, valOne, valTwo);

        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

    /** Balanced Tree: For every node in the tree, the height difference between its left and right subtrees is no more than one.*/
    static boolean isBalancedBinaryTreeNaive(TreeNode root){
        if(root == null) return true;
        int leftHeight = heightOfATree(root.left);
        int rightHeight = heightOfATree(root.right);
        return Math.abs(leftHeight - rightHeight) <=1
                && isBalancedBinaryTreeNaive(root.left)
                && isBalancedBinaryTreeNaive(root.right);
    }

    static int isBalancedBinaryTreeOptimized(TreeNode root){
        if(root == null) return 0;

        int leftHeight = isBalancedBinaryTreeOptimized(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = isBalancedBinaryTreeOptimized(root.right);
        if(rightHeight == -1) return -1;

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if(heightDiff > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    /* A complete binary tree is a type of binary tree in which all levels are fully filled except possibly the last level.
        In the last level, nodes are filled from left to right without any gaps.
     */

    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean endOfLevel = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // If we encounter a null node after non-null nodes, it should be the last level
            if (node == null) {
                endOfLevel = true;
            } else {
                // If we've encountered a null node before, and there's any non-null node after it
                if (endOfLevel) {
                    return false;
                }

                // Enqueue left and right children
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }

    static int countNodesInCompleteBinaryTree(TreeNode root){
        if(root == null) return 0;

        int leftCount = 0;
        TreeNode leftNode = root;
        while(leftNode != null){
            leftCount++;
            leftNode = leftNode.left;
        }

        int rightCount = 0;
        TreeNode rightNode = root;
        while(rightNode != null){
            rightCount++;
            rightNode = rightNode.right;
        }

        boolean isSame = (Math.pow(2, leftCount) - 1) == (Math.pow(2, rightCount) - 1);
        if(isSame){
            return (int) (Math.pow(2, leftCount) - 1);
        }

        return 1 + countNodesInCompleteBinaryTree(root.left) + countNodesInCompleteBinaryTree(root.right);
    }

    // Leetcode: 297
    static String serialize(TreeNode root){
        if(root == null) return "n";
        return String.valueOf(root.val) + "," +  serialize(root.left) + "," + serialize(root.right);
    }

    static TreeNode deserialize(String val){

        String[] list = val.split(",");
        return deserializeHelper(list);
    }

    static TreeNode deserializeHelper(String[] val){
        if(idx >= val.length || val[idx].equals("n")){
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val[idx]));
        root.left = deserializeHelper(val);
        root.right = deserializeHelper(val);
        return root;
    }

    // Leetcode: 314-Binary Tree Vertical Order Traversal
    /* In Naive approach , reeMap sorts keys automatically, it adds an O(log n) overhead for inserts and lookups due to maintaining the order*/
    static public List<List<Integer>> verticalOrderNotOptimized(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> treeMap = new TreeMap<>();
        verticalOrderHelper(root, 0, treeMap);

        for(List<Integer> ls : treeMap.values()){
            result.add(ls);
        }
        return result;
    }

    static void verticalOrderHelper(TreeNode root, int level, Map<Integer, List<Integer>> treeMap){
        if(root == null) return;
        treeMap.putIfAbsent(level, new ArrayList<>());
        treeMap.get(level).add(root.val);
        verticalOrderHelper(root.left, level - 1, treeMap);
        verticalOrderHelper(root.right, level + 1, treeMap);
    }

    static List<List<Integer>> verticalOrderOptimized(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        int min = 0;
        int max = 0;

        while(!q.isEmpty()){
            Pair currentPair = q.poll();
            TreeNode currentNode = currentPair.node;

            map.putIfAbsent(currentPair.level, new ArrayList<>());
            map.get(currentPair.level).add(currentNode.val);

            min = Math.min(min, currentPair.level);
            max = Math.max(max, currentPair.level);

            if(currentNode.left != null){
                q.add(new Pair(currentPair.level - 1, currentNode.left));
            }

            if(currentNode.right != null){
                q.add(new Pair(currentPair.level + 1, currentNode.right));
            }
        }

        for(int i=min; i<=max; i++){
            if (map.containsKey(i)) {
                result.add(map.get(i));
            }
        }

        return result;
    }

    // Leetcode: 129 Sum Root to Leaf Numbers
    static int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    static int sumNumbersHelper(TreeNode root, int currentSum){
        if(root == null) return 0;
        currentSum = currentSum * 10 + root.val;
        if(root.left == null && root.right == null) return currentSum;
        return sumNumbersHelper(root.left, currentSum) + sumNumbersHelper(root.right, currentSum);
    }

    // Leetcode: 2385 - Amount of time for Binary Tree to be Infected from a given Node.
    public static int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);
        TreeNode targetNode = findNode(root, start);
        if (targetNode == null) return -1;

        Set<TreeNode> visited = new HashSet<>();
        int infectionCount = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(targetNode);

        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                TreeNode current = q.poll();
                // Get parent of current node
                TreeNode parentNode = parentMap.get(current);

                // Add children and parent to queue if not visited
                if (current.left != null && !visited.contains(current.left)) {
                    q.add(current.left);
                    visited.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    q.add(current.right);
                    visited.add(current.right);
                }
                if (parentNode != null && !visited.contains(parentNode)) {
                    q.add(parentNode);
                    visited.add(parentNode);
                }
            }

            infectionCount++;
        }

        return infectionCount - 1;
    }

    static void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap){
        if(root == null) return;
        if(root.left != null) parentMap.put(root.left, root);
        if(root.right != null) parentMap.put(root.right, root);
        buildParentMap(root.left, parentMap);
        buildParentMap(root.right, parentMap);
    }

    static TreeNode findNode(TreeNode root, int start) {
        if(root == null) return null;
        if(root.val == start) return root;
        TreeNode left = findNode(root.left, start);
        TreeNode right = findNode(root.right, start);
        return left == null ? right : left;
    }
}
