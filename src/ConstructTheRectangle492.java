import java.util.Arrays;

/**
 * ConstructTheRectangle492
 * <p>
 * 求一个数字由两个数字相乘的数组，并且两个数字是最接近的
 *
 * @author lirongqian
 * @since 2018/03/26
 */
public class ConstructTheRectangle492 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle(90)));
    }

    /**
     * 可以首先先对area进行开方，从而缩小范围
     * 然后递增开放后的数，直到相乘为area
     * @param area
     * @return
     */
    public static int[] constructRectangle(int area) {
        int[] a = new int[2];
        int a1 = (int) Math.sqrt(area);
        while (area % a1 != 0) {
            a1++;
        }
        a[0] = Math.max(a1, area / a1);
        a[1] = Math.min(a1, area / a1);
        return a;
    }

}