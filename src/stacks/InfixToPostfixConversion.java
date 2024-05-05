package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

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
        int n = givenWord.length();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        IntStream.range(0, n).forEach(i -> {
            char current = givenWord.charAt(i);
            if(Character.isLetter(current)){
                sb.append(current);
            }else if(current == '('){
                stack.push(current);
            }else if(current == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                while(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }else{
                while(!stack.isEmpty() && precedenceMap.containsKey(current)
                        && operatorPrecedenceCondition(current, stack.peek())){
                    sb.append(stack.pop());
                }
                stack.push(current);
            }
        });

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }

    static boolean operatorPrecedenceCondition(Character current, Character peek){
        int peekScore = getPrecedenceScore(peek);
        int currentScore = getPrecedenceScore(current);
        if(getAssociativity(current) == 'L'){
            return currentScore <= peekScore;
        }else{
            return currentScore < peekScore;
        }
    }

    static int getPrecedenceScore(Character value){
        return precedenceMap.getOrDefault(value, -1);
    }

    static char getAssociativity(char ch) {
        if (ch == '^') {
            return 'R';
        }
        return 'L';
    }
}
