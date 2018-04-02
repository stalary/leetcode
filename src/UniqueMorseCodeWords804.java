
import java.util.HashSet;
import java.util.Set;

/**
 * UniqueMorseCodeWords804
 *
 * 计算一共可以转化为多少种摩丝密码
 *
 * @author lirongqian
 * @since 2018/04/02
 */
public class UniqueMorseCodeWords804 {

    public static void main(String[] args) {
        String[] strings = new String[] {
                "gin", "zen", "gig", "msg"
        };
        System.out.println(new UniqueMorseCodeWords804().uniqueMorseRepresentations(strings));
    }

    /**
     * 使用set进行去重，最后通过获得set的大小就能获得获得种类
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] strings = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                sb.append(strings[chars[j] - 97]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}