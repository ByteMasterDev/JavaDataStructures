package stacks;

import java.util.Stack;
import java.util.stream.IntStream;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] givenArray = {5, 15, 10, 8, 6, 12, 9, 18};
        int n = givenArray.length;
        if(n == 0) return;

        int[] results = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(givenArray[n-1]);
        results[n-1] = -1;

        IntStream.iterate(n - 2, i -> i >= 0, i -> i - 1).forEach(i -> {
            while(!stack.isEmpty() && stack.peek() < givenArray[i]){
                stack.pop();
            }

            int result = stack.isEmpty() ? -1 : stack.peek();
            results[i] = result;
            stack.push(givenArray[i]);
        });

        IntStream.range(0, n).forEach( i -> {
            System.out.println(results[i]);
        });
    }
}
