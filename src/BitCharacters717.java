
/**
 * BitCharacters
 *
 * 判断一个数组是否由11，10和0组成，并且最后一位只能是1个字符，并且必须包括一个0
 * @author lirongqian
 * @since 2018/03/26
 */
public class BitCharacters717 {

    public static void main(String[] args) {
        int[] bits = new int[]{
                1, 0, 0
        };
        System.out.println(isOneBitCharacter(bits));
    }

    /**
     * 10和11都是出现开头的1即可跳过，判断最后i的
     * @param bits
     * @return
     */
    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }
        return i == bits.length - 1;
    }
}