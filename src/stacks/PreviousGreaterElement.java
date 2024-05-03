package stacks;

import java.util.Stack;
import java.util.stream.IntStream;

public class PreviousGreaterElement {

    public static void main(String[] args) {
        int[] givenArray = {15, 10, 18, 12, 4, 6, 2, 8};
        Stack<Integer> stack = new Stack<>();

        if(givenArray.length == 0) return;
        // Directly handle the first element as a special case.
        System.out.println(-1);  // First element has no previous greater element
        stack.push(givenArray[0]);
        IntStream.range(1, givenArray.length).forEach(i -> {
            while(!stack.isEmpty() && stack.peek() < givenArray[i]){
                stack.pop();
            }

            int result = stack.isEmpty() ? -1 : stack.peek();
            System.out.println(result);
            stack.push(givenArray[i]);
        });
    }
}
