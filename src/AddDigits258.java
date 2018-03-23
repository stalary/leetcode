
/**
 * AddDigits258
 *
 * 将每个数字重复相加，直到只有一位数字
 * @author lirongqian
 * @since 2018/03/19
 */
public class AddDigits258 {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    /**
     * 当小于10时，可以直接返回数值
     * 将每一位的数字都相加
     * 当和大于10时进行递归
     * 等于10时，直接输出1
     * 否则返回当前和
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num > 10) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        if (sum < 10) {
            return sum;
        } else if (sum == 10) {
            return 1;
        } else {
            return addDigits(sum);
        }
    }
}