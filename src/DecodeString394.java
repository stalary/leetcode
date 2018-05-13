import java.util.Stack;

/**
 * DecodeString394
 * 编码字符串
 * 3[a2[c]]编码为accaccacc
 * @author lirongqian
 * @since 2018/04/08
 */
public class DecodeString394 {

    public static void main(String[] args) {
        System.out.println(new DecodeString394().decodeString("3[a2[c]]"));
    }

    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        int i = 0;
        result.push("");
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                // 存入字母前的数字
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                // 代表字母的开始
                result.push("");
            } else if (ch == ']') {
                // 代表字母的结束
                // 获取原字符串，通过数字决定重复次数
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                // ·合并字符串，弹出""，加入添加字母后的字符串
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
            i += 1;
        }
        return result.pop();
    }
}