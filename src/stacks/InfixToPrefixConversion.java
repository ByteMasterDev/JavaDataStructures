package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

public class InfixToPrefixConversion {

    static Map<Character, Integer> precedenceMap = new HashMap<>();
    static {
        precedenceMap.put('+', 1);
        precedenceMap.put('-', 1);
        precedenceMap.put('*', 2);
        precedenceMap.put('/', 2);
        precedenceMap.put('^', 3);
    }

    public static void main(String[] args) {
        String givenExpression = "(A+(B*C)^D)";
        System.out.println(infixToPrefixConversion(givenExpression, givenExpression.length()));
    }

    static String infixToPrefixConversion(String givenWord, int n){
        String expression = reverseOriginalExpression(givenWord, n);
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        IntStream.range(0, n).forEach(i -> {
            Character current = expression.charAt(i);
            if(Character.isLetter(current)) {
                sb.append(current);
            } else if(current == '(') {
                stack.push(current);
            } else if(current == ')') {
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else{
                while(!stack.isEmpty() && precedenceMap.containsKey(current)
                        && operatorPrecedenceCondition(current, stack.peek())){
                    sb.append(stack.pop());
                }
                stack.push(current);
            }
        });

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    static boolean operatorPrecedenceCondition(Character current, Character peek){
        int currentPrecedenceScore = getPrecedenceScore(current);
        int peekPrecedenceScore = getPrecedenceScore(peek);

        if(getAssociativity(current) == 'L'){
            return currentPrecedenceScore <= peekPrecedenceScore;
        }else{
            return currentPrecedenceScore < peekPrecedenceScore;
        }
    }

    static int getPrecedenceScore(Character value){
        return precedenceMap.getOrDefault(value, -1);
    }

    static Character getAssociativity(Character value){
        return value != '^' ? 'L' : 'R';
    }

    static String reverseOriginalExpression(String expression, int n){
        StringBuilder sb = new StringBuilder();
        IntStream.iterate(n-1, i -> i>=0, i -> i-1).forEach(i -> {
            Character current = expression.charAt(i);
            if(current == '('){
                sb.append(')');
            }else if(current == ')'){
                sb.append('(');
            }else{
                sb.append(current);
            }
        });
        return sb.toString();
    }
}


