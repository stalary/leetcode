/**
 * SortColors75
 * 对red，white，blue三种颜色排序，分别用0，1，2代表
 * @author lirongqian
 * @since 2018/04/12
 */
public class SortColors75 {

    public static void main(String[] args) {
        new SortColors75().sortColors(new int[]{
                1, 2, 1, 0, 1
        });
    }

    /**
     * 因为只有三种颜色，所以将red移到最前面，blue移到最后即可
     * @param A
     */
    public void sortColors(int[] A) {
        if (A == null || A.length < 2) {
            return;
        }
        // 首先申请首尾两个坐标
        int low = 0;
        int high = A.length - 1;
        for (int i = low; i <= high; ) {
            if (A[i] == 0) {
                // 当A[i]=0时即放到前面，交换A[i]和A[low]，然后都后移
                int temp = A[i];
                A[i] = A[low];
                A[low] = temp;
                i++;
                low++;
            } else if (A[i] == 2) {
                // 当A[i]=2时即放到后面，交换A[i]和A[high]，然后将最大值缩小;
                int temp = A[i];
                A[i] = A[high];
                A[high] = temp;
                high--;
            } else {
                // 否则向后一位
                i++;
            }
        }
    }
}