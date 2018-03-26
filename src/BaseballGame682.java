import java.util.LinkedList;

/**
 * BaseballGame682
 *
 * 按符号进行运算，数字就相加，C是减去前一个数字，D是加上上一个数字的两倍，+是加上上一个数字和倒数第二个数字
 * @author lirongqian
 * @since 2018/03/26
 */
public class BaseballGame682 {

    public static void main(String[] args) {
        String[] ops = new String[]{
                "5", "2", "C", "D", "+"
        };
        System.out.println(new BaseballGame682().calPoints(ops));
    }

    public int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        for (String op : ops) {
            // 减去之前的元素，即队列中的最后一个元素
            if ("C".equals(op)) {
                sum -= list.removeLast();
            } else if ("D".equals(op)) {
                // 先将两倍的数字加入队列中，再修改sum
                list.add(list.peekLast() * 2);
                sum += list.peekLast();
            } else if ("+".equals(op)) {
                // 加上最后一个数字和倒数第二个数字
                list.add(list.peekLast() + list.get(list.size() - 2));
                sum += list.peekLast();
            } else {
                // 当时数字时直接相加
                list.add(Integer.parseInt(op));
                sum += list.peekLast();
            }
        }
        return  sum;
    }
}