package stacks;

import java.util.Arrays;

public class NStacksUsingArray {

    public static void main(String[] args) {
        int capacity = 10; // Total size of the array
        int numberOfStacks = 3; // Number of stacks you want to maintain in the array

        NStacksOperations nStacks = new NStacksOperations(capacity, numberOfStacks);

        // Push elements into the first stack
        nStacks.push(1, 5); // Push 5 in stack 1
        nStacks.push(1, 10); // Push 10 in stack 1

        // Push elements into the second stack
        nStacks.push(2, 15); // Push 15 in stack 2

        // Push elements into the third stack
        nStacks.push(3, 20); // Push 20 in stack 3
        nStacks.push(3, 25); // Push 25 in stack 3
        nStacks.push(3, 30); // Push 30 in stack 3

        // Pop elements from stacks
        System.out.println("Popped from stack 1: " + nStacks.pop(1)); // Should print 10
        System.out.println("Popped from stack 3: " + nStacks.pop(3)); // Should print 30

        // Peek elements from stacks
        System.out.println("Peek at stack 1: " + nStacks.peek(1)); // Should print 5
        System.out.println("Peek at stack 2: " + nStacks.peek(2)); // Should print 15

        // Check if stacks are empty
        System.out.println("Is stack 1 empty? " + nStacks.isEmpty(1)); // Should return false
        System.out.println("Is stack 2 empty? " + nStacks.isEmpty(2)); // Should return false
        System.out.println("Is stack 3 empty? " + nStacks.isEmpty(3)); // Should return true after pop

        // Push and pop operations to demonstrate stack full scenario
        try {
            for (int i = 0; i < 5; i++) {
                nStacks.push(2, i * 5);  // Attempting to fill the stack 2
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // Expect stack full message
        }

        // Pop until stack is empty
        while (!nStacks.isEmpty(2)) {
            System.out.println("Popping from stack 2: " + nStacks.pop(2));  // Pop all items from stack 2
        }
        System.out.println("Is stack 2 empty? " + nStacks.isEmpty(2)); // Should return true
    }
}

class NStacksOperations{

    int[] array;
    int capacity;
    int noOfStacks;
    int[] top;
    int[] next;
    int freeSpot;

    NStacksOperations(int capacity, int noOfStacks){
        this.capacity = capacity;
        this.noOfStacks = noOfStacks;
        array = new int[capacity];
        top = new int[noOfStacks];
        Arrays.fill(top, -1);
        next = new int[capacity];
        for(int i=0; i<capacity - 1; i++){
            next[i] = i+1;
        }
        next[capacity - 1] = -1;
        freeSpot = 0;
    }

    void push(int stack, int val){
        if (stack < 1 || stack > noOfStacks) throw new IndexOutOfBoundsException("Stack index out of range.");
        if (freeSpot == -1) throw new RuntimeException("Stack overflow");

        int availableSpot = freeSpot;
        freeSpot = next[availableSpot];
        array[availableSpot] = val;
        next[availableSpot] = top[stack - 1];
        top[stack - 1] = availableSpot;
    }

    int pop(int stack){
        if (stack < 1 || stack > noOfStacks) throw new IndexOutOfBoundsException("Stack index out of range.");
        int stackTopIndex = top[stack - 1];
        if (stackTopIndex == -1) throw new RuntimeException("Stack underflow");

        int item = array[stackTopIndex];
        top[stack - 1] = next[stackTopIndex];
        next[stackTopIndex] = freeSpot;
        freeSpot = stackTopIndex;
        return item;

    }

    boolean isEmpty(int stack){
        return top[stack - 1] == -1;
    }

    int peek(int stack){
        if(isEmpty(stack)) throw new RuntimeException("Stack is Empty");
        return array[top[stack-1]];
    }
}