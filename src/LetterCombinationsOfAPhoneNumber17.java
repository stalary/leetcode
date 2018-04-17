import java.util.LinkedList;
import java.util.List;

/**
 * LetterCombinationsOfAPhoneNumber17
 * 输出手机号组成的所有字母
 *
 * @author lirongqian
 * @since 2018/04/17
 */
public class LetterCombinationsOfAPhoneNumber17 {

    /**
     * ""
     * "abc"
     * "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.offer("");
        for (int i = 0; i < digits.length(); i++) {
            // 拿到当前数字对应的字符，然后依次加入队列中
            char[] letters = mapping[Character.getNumericValue(digits.charAt(i))].toCharArray();
            while (ans.peek().length() == i) {
                // 拿出当前头元素
                String t = ans.poll();
                for (char s : letters) {
                    ans.offer(t + s);
                }
            }
        }
        return ans;
    }
}