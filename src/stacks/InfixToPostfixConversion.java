package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

/*
 * Step 1: Scan and read elements from left to right.
 * Step 2: If the scanned item is an operand, add it to the output.
 * Step 3: If the scanned item is '(', push it onto the stack.
 * Step 4: If the scanned item is ')', pop all items from the stack until '(' is encountered.
 * Step 5: If it is an operator:
 *       5a: Find the precedence score/rank for the current element and the top element of the stack (using the Precedence static map) and determine associativity.
 *       5b: Check operator precedence and associativity:
 *           i. If the precedence of the current element equals the precedence of the top element, pop the top element and push the current one.
 *           ii. If the precedence of the top element is greater than the precedence of the current element, pop the top and push the current.
 *           iii. If the precedence of the top element is less than the precedence of the current element, push the current element onto the stack.
 * Note: In the stack, a lower precedence operator cannot be on top of a higher precedence operator.
 */
public class InfixToPostfixConversion {

    static Map<Character, Integer> precedenceMap = new HashMap<>();
    static{
        precedenceMap.put('+', 1);
        precedenceMap.put('-', 1);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
        precedenceMap.put('^', 3);
    }

    public static void main(String[] args) {
        String givenWord = "A+B*C";
        System.out.println(convertInfixToPostFix(givenWord));

    }

    static String convertInfixToPostFix(String givenWord){
        int n = givenWord.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        IntStream.range(0, n).forEach(i -> {
            Character current = givenWord.charAt(i);
            if(Character.isLetter(current)) {
                sb.append(current);
            } else if(current == '(') {
                stack.push(current);
            } else if(current == ')') {
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            } else {
                while(!stack.isEmpty() && precedenceMap.containsKey(current) && operatorPrecedenceCondition(current, stack.peek())){
                    sb.append(stack.pop());
                }
                stack.push(current);
            }
        });

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    static boolean operatorPrecedenceCondition(Character current, Character peek){
        int currentPrecedenceScore = getPrecedence(current);
        int peekPrecedenceScore = getPrecedence(peek);

        if(getAssociativity(current) == 'L'){
            return currentPrecedenceScore <= peekPrecedenceScore;
        }else{
            return currentPrecedenceScore < peekPrecedenceScore;
        }
    }

    static int getPrecedence(Character value){
        return precedenceMap.getOrDefault(value, -1);
    }

    static Character getAssociativity(Character value){
        return value != '^' ? 'L' : 'R';
    }
}
