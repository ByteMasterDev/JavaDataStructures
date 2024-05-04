package stacks;

import java.util.Stack;

public class GetMin {

    public static void main(String[] args) {
        StackGetMinInOOne stack = new StackGetMinInOOne();
        stack.push(3);
        stack.push(5);
        System.out.println(stack.getMin()); // Should return 3
        stack.push(2);
        stack.push(2);
        System.out.println(stack.getMin()); // Should return 2
        stack.pop();
        System.out.println(stack.getMin()); // Should still return 2
        stack.pop();
        System.out.println(stack.getMin()); // Should return 3


        StackGetMinInOneSpace stack2 = new StackGetMinInOneSpace();

        // Pushing elements onto the stack
        stack2.push(3);
        System.out.println("Pushed 3; Min is now: " + stack2.getMin());
        stack2.push(5);
        System.out.println("Pushed 5; Min is still: " + stack2.getMin());
        stack2.push(2);
        System.out.println("Pushed 2; Min is now: " + stack2.getMin());
        stack2.push(1);
        System.out.println("Pushed 1; Min is now: " + stack2.getMin());
        stack2.push(4);
        System.out.println("Pushed 4; Min is still: " + stack2.getMin());

        // Popping elements and showing the min after each pop
        System.out.println("Popped " + stack2.pop() + "; Min is still: " + stack2.getMin());
        System.out.println("Popped " + stack2.pop() + "; Min is still: " + stack2.getMin());
        System.out.println("Popped " + stack2.pop() + "; Min is now: " + stack2.getMin());
        System.out.println("Popped " + stack2.pop() + "; Min is now: " + stack2.getMin());
    }
}

class StackGetMinInOOne {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> auxStack = new Stack<>();

    void push(int val){
        mainStack.push(val);
        if (auxStack.isEmpty() || val <= auxStack.peek()) {
            auxStack.push(val);
        }
    }

    int pop(){
        if (mainStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int top = mainStack.pop();
        if(auxStack.peek() == top){
            auxStack.pop();
        }
        return top;
    }

    int getMin(){
        if (auxStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return auxStack.peek();
    }

}

class StackGetMinInOneSpace{
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        } else if (val < min) {
            stack.push(2 * val - min);
            min = val;
        } else {
            stack.push(val);
        }
    }

    int pop() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty");

        int top = stack.pop();
        if (top < min) {
            int originalMin = min;
            min = 2 * min - top;
            top = originalMin;
        }
        return top;
    }

    int getMin() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty");
        return min;
    }
}
