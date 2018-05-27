package LaiOffer.Class24._AllValidPermutationsOfParenthesesII;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

public class Solution {

    public List<String> validParentheses(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0) {
            return null;
        }

        char[] matcher = new char[]{'(', ')', '[', ']', '{', '}'};
        int[] counter = new int[]{a, a, b, b, c, c};
        StringBuilder s = new StringBuilder();
        List<String> result = new ArrayList<>();
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> m = new HashMap<>();

        m.put(')','(');
        m.put(']','[');
        m.put('}','{');


        validParentheses(s, (a + b + c)*2, matcher, counter, stack, result, m);

        return result;
    }

    private void validParentheses(StringBuilder s, int length, char[] match, int[] counter, Deque<Character> stack, List<String> result, Map<Character, Character> m) {

        if (length == 0) {
            result.add(s.toString());
            return;
        }

        for (int i = 0; i < counter.length; ++i) {
            if (counter[i]!=0) {
                if (i % 2 == 0) {
                    stack.push(match[i]);
                    s.append(match[i]);
                    counter[i]--;

                    validParentheses(s, length-1, match, counter, stack, result, m);

                    s.deleteCharAt(s.length() - 1);
                    stack.pop();
                    counter[i]++;

                } else {
                    if (!stack.isEmpty()&&m.get(match[i]) == stack.peek()) {
                        char tmp = stack.pop();
                        s.append(match[i]);
                        counter[i]--;

                        validParentheses(s, length-1, match, counter, stack, result, m);

                        s.deleteCharAt(s.length() - 1);
                        stack.push(tmp);
                        counter[i]++;
                    }
                }
            }
        }

    }

}