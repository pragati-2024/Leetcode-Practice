import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        ValidParentheses obj = new ValidParentheses();

        String s = "{[()]}";
        System.out.println(obj.isValid(s));  // Output: true

        s = "{[(])}";
        System.out.println(obj.isValid(s));  // Output: false
    }
}