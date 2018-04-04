import java.util.ArrayList;
import java.util.List;

/**
 * GenerateParentheses22
 * 生成匹配的括号
 *
 * @author lirongqian
 * @since 2018/04/04
 */
public class GenerateParentheses22 {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses22().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    /**
     * 通过开闭括号来进行递归的实现
     * @param list
     * @param str
     * @param open
     * @param close
     * @param max
     * */

    public void backtrack(List<String> list, String str, int open, int close, int max) {
        // 当字符串长度和最大值两倍相等时，代表完成字符串的拼接
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        // 当开括号的数量小于最大值时，继续增加
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        // 闭括号小于开括号时，继续增加
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }
}