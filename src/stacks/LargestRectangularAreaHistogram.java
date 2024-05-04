package stacks;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class LargestRectangularAreaHistogram {
    public static void main(String[] args) {

        int[] givenArray = {6, 2, 5, 4, 1, 5, 6};
        System.out.println("Naive Method: " + naiveLargestRectangularAreaHistogram(givenArray, givenArray.length));
        System.out.println("Efficient Method: " + efficientLargestRectangularAreaHistogram(givenArray, givenArray.length));
        System.out.println("Best Stack Method: " + largestRectangularAreaHistogramUsingStack(givenArray, givenArray.length));

    }

    static int naiveLargestRectangularAreaHistogram(int[] givenArray, int n){
        final int[] maxArea = {0};

        // Iterate each bar
        IntStream.range(0, n).forEach(i -> {
            // Left Immediate Min
            int leftIdx = i - 1;
            while (leftIdx >= 0 && givenArray[leftIdx] >= givenArray[i]) {
                leftIdx--;
            }

            // Right Immediate Min
            int rightIndex = i + 1;
            while (rightIndex < n && givenArray[rightIndex] >= givenArray[i]) {
                rightIndex++;
            }

            int width = rightIndex - leftIdx - 1;
            int currentArea = width * givenArray[i];
            maxArea[0] = Math.max(maxArea[0], currentArea);
        });

        return maxArea[0];
    }

    static int efficientLargestRectangularAreaHistogram(int[] givenArray, int n){
        int[] ns = new int[n];
        int[] ps = new int[n];

        // Initialize previous smaller and next smaller index arrays
        Arrays.fill(ps, -1); // No smaller to the left
        Arrays.fill(ns, n);  // No smaller to the right

        final int[] maxArea = {0};

        IntStream.range(0, n).forEach(i -> {
            int leftMinIdx = leftMinIdx(givenArray, i);
            int rightMinIdx = rightMinIdx(givenArray, i, n);
            ps[i] = leftMinIdx;
            ns[i] = rightMinIdx;
        });

        IntStream.range(0, n).forEach(i -> {
            int width = ns[i] - ps[i] - 1;
            int currentArea = width * givenArray[i];
            maxArea[0] = Math.max(maxArea[0], currentArea);
        });

        return maxArea[0];
    }

    static int leftMinIdx(int[] givenArray, int start){
        return IntStream.iterate(start - 1, i -> i >= 0, i -> i - 1)
                .filter(i -> givenArray[i] < givenArray[start])
                .findFirst()
                .orElse(-1);
    }

    static int rightMinIdx(int[] givenArray, int start, int n){
        return IntStream.range(start + 1, n) // Correctly generate indices from start+1 to n-1
                .filter(i -> givenArray[i] < givenArray[start])
                .findFirst()
                .orElse(n); // Return n when no smaller element is found to the right
    }

    static int largestRectangularAreaHistogramUsingStack(int[] givenArray, int n) {
        Stack<Integer> stack = new Stack<>();
        final int[] maxArea = {0};

        IntStream.range(0, n).forEach(i -> {
            while (!stack.isEmpty() && givenArray[stack.peek()] >= givenArray[i]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int currentArea = givenArray[top] * width;
                maxArea[0] = Math.max(maxArea[0], currentArea);
            }
            stack.push(i);
        });

        // Handle the remaining bars in the stack
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            int currentArea = givenArray[top] * width;
            maxArea[0] = Math.max(maxArea[0], currentArea);
        }

        return maxArea[0];
    }

}
