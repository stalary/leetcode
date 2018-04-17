import java.util.ArrayList;
import java.util.List;

/**
 * RemoveInvalidParentheses301
 * 删除不合法的括号
 * @author lirongqian
 * @since 2018/04/17
 */
public class RemoveInvalidParentheses301 {

    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses301().removeInvalidParentheses("()())()"));
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int lastI, int lastJ,  char[] par) {
        for (int stack = 0, i = lastI; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) {
                stack++;
            }
            if (s.charAt(i) == par[1]) {
                stack--;
            }
            // 未倒置时，右括号多的时候考虑删除
            if (stack >= 0) {
                continue;
            }
            for (int j = lastJ; j <= i; ++j) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        // 完成从左到右的搜索，倒置
        if (par[0] == '(') {
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        } else {
            // 完成从右到左的搜索，添加到输出队列
            ans.add(reversed);
        }
    }
}