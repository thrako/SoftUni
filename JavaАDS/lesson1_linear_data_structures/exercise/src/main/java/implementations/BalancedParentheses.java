package implementations;

import interfaces.Solvable;

import java.util.HashMap;
import java.util.Map;

public class BalancedParentheses implements Solvable {
    private static final Map<Character, Character> bracketsMap = new HashMap<>();
    static {
        bracketsMap.put('}', '{');
        bracketsMap.put(']', '[');
        bracketsMap.put(')', '(');
    }
    private final String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char symbol : parentheses.toCharArray()) {
            if (bracketsMap.containsValue(symbol)) {
                stack.push(symbol);
            } else if (bracketsMap.containsKey(symbol)) {
                final Character expected = bracketsMap.get(symbol);
                final Character actual = stack.pop();
                if (!expected.equals(actual)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
