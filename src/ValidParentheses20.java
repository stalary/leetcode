
import java.util.Stack;

/**
 * ValidParentheses20
 * 判断括号是否合法
 * @author lirongqian
 * @since 2018/04/25
 */
public class ValidParentheses20 {

    /**
     * 通过栈，入栈与当前括号相匹配的括号，然后最后判断栈是否为空
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}