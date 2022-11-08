package lesson01_stacks_and_queues.exercise;

import java.util.*;

public class N05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        if (isBalanced(sequence)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isBalanced(String sequence) {
        Map<Character, Character> chars = new HashMap<>();
        chars.put(')', '(');
        chars.put('}', '{');
        chars.put(']', '[');

        Deque<Character> parenthesis = new ArrayDeque<>();

        for (int i = 0, length = sequence.length(); i < length; i++) {
            char symbol = sequence.charAt(i);
            switch (symbol) {
                case '(':
                case '{':
                case '[':
                    parenthesis.push(symbol);
                    break;
                case ')':
                case '}':
                case ']':
                    if (parenthesis.isEmpty() || parenthesis.pop() != chars.get(symbol)) {
                        return false;
                    }
                    break;
                default:
            }
        }
        return true;
    }
}
