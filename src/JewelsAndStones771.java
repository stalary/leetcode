
import java.util.HashSet;
import java.util.Set;

/**
 * JewelsAndStones771
 *
 * 判断S包含多少个J中的字符
 * @author lirongqian
 * @since 2018/03/13
 */
public class JewelsAndStones771 {

    public static void main(String[] args) {
        System.out.println(new JewelsAndStones771().numJewelsInStones("aA", "aAAbbb"));
    }

    /**
     * 将S中的字符存入set中，然后判断S中含有多少个set中的元素
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}