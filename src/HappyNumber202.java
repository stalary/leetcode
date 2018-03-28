import java.util.HashSet;
import java.util.Set;

/**
 * HappyNumber202
 * 判断一个数字的每一位数字平方所最后组成的数是否为1
 * Example: 19 is a happy number

 1*1 + 9*9 = 82
 8*8 + 2*2 = 68
 6*6 + 8*8 = 100
 1*1 + 0*0 + 0*0 = 1

 * @author lirongqian
 * @since 2018/03/14
 */
public class HappyNumber202 {

    public static void main(String[] args) {
        HappyNumber202 h = new HappyNumber202();
        System.out.println(h.isHappy(19));

    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        // 使用一个set防止死循环
        while (set.add(n)) {
            int sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }

}