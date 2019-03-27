/**
 * HammingDistance461
 *
 * 求x，y之间的Hamming距离
 * @author lirongqian
 * @since 2018/03/14
 */
public class HammingDistance461 {

    public static void main(String[] args) {
        System.out.println(new HammingDistance461().hammingDistance(1, 4));
    }

    /**
     * 求两个点转化为二进制后不同位的数量
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

}