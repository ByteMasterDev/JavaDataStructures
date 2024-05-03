package stacks;

public class TwoStacksUsingArray {

    public static void main(String[] args) {
        StackOperations2 stackOps = new StackOperations2(10); // Initialize StackOperations with a total capacity

        // Test pushing to Stack One
        try {
            stackOps.pushToStackOne(1);
            stackOps.pushToStackOne(2);
            System.out.println("Push to Stack One: Success");
        } catch (RuntimeException e) {
            System.out.println("Push to Stack One Failed: " + e.getMessage());
        }

        // Test pushing to Stack Two
        try {
            stackOps.pushToStackTwo(10);
            stackOps.pushToStackTwo(9);
            System.out.println("Push to Stack Two: Success");
        } catch (RuntimeException e) {
            System.out.println("Push to Stack Two Failed: " + e.getMessage());
        }

        // Test popping from Stack One
        try {
            System.out.println("Pop from Stack One: " + stackOps.popStackOne()); // Should return 2
            System.out.println("Pop from Stack One: " + stackOps.popStackOne()); // Should return 1
        } catch (RuntimeException e) {
            System.out.println("Pop from Stack One Failed: " + e.getMessage());
        }

        // Test popping from Stack Two
        try {
            System.out.println("Pop from Stack Two: " + stackOps.popStackTwo()); // Should return 9
            System.out.println("Pop from Stack Two: " + stackOps.popStackTwo()); // Should return 10
        } catch (RuntimeException e) {
            System.out.println("Pop from Stack Two Failed: " + e.getMessage());
        }

        // Test for empty stacks
        try {
            stackOps.popStackOne();
        } catch (RuntimeException e) {
            System.out.println("Pop from Empty Stack One: " + e.getMessage()); // Expected, as stack one is empty
        }

        try {
            stackOps.popStackTwo();
        } catch (RuntimeException e) {
            System.out.println("Pop from Empty Stack Two: " + e.getMessage()); // Expected, as stack two is empty
        }
    }
}

class StackOperations2{
    int[] array;
    int capacity;
    int topOne;
    int topTwo;

    StackOperations2(int capacity){
        this.capacity = capacity;
        array = new int[capacity];
        topOne = -1;
        topTwo = capacity;
    }

    void pushToStackOne(int val){
        if(topOne + 1 < topTwo){
            array[++topOne] = val;
        }else{
            throw new RuntimeException("Stack One is Full.");
        }
    }

    void pushToStackTwo(int val){
        if(topOne < topTwo - 1){
            array[--topTwo] = val;
        }else{
            throw new RuntimeException("Stack Two is Full.");
        }
    }

    int popStackOne(){
        if(isStackOneEmpty()) throw new RuntimeException("Stack One is Empty.");
        int top = array[topOne];
        topOne--;
        return top;
    }

    int popStackTwo(){
        if(isStackTwoEmpty()) throw new RuntimeException("Stack Two is Empty.");
        int top = array[topTwo];
        topTwo--;
        return top;
    }

    int peekStackOne(){
        if(topOne == -1) throw new RuntimeException("Stack One is Empty.");
        int top = array[topOne];
        return top;
    }

    int peekStackTwo(){
        if(topTwo == capacity) throw new RuntimeException("Stack Two is Empty.");
        int top = array[topTwo];
        return top;
    }

    boolean isStackOneEmpty() {
        return topOne == -1;
    }

    boolean isStackTwoEmpty() {
        return topTwo == capacity;
    }
}