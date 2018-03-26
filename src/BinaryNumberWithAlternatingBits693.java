/**
 * BinaryNumberWithAlternatingBits693
 * <p>
 * 输入一个正数，转化为二进制，判断是否为跳跃式
 *
 * @author lirongqian
 * @since 2018/03/26
 *
 */
public class BinaryNumberWithAlternatingBits693 {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
    }

    public static boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

}