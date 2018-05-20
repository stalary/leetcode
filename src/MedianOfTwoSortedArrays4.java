import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * MedianOfTwoSortedArrays4
 * 查找两个排序数组的最大值
 *
 * @author lirongqian
 * @since 2018/05/20
 */
public class MedianOfTwoSortedArrays4 {

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : nums1) {
            if (count % 2 == 0) {
                maxHeap.offer(i);
                minHeap.offer(maxHeap.poll());
            } else {
                minHeap.offer(i);
                maxHeap.offer(minHeap.poll());
            }
            count++;
        }
        for (int i : nums2) {
            if (count % 2 == 0) {
                maxHeap.offer(i);
                minHeap.offer(maxHeap.poll());
            } else {
                minHeap.offer(i);
                maxHeap.offer(minHeap.poll());
            }
            count++;
        }
        if (count % 2 == 0) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        return (double) minHeap.peek();
    }
}