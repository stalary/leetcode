/**
 * @(#)CountAndSay38.java, 2018-08-05.
 * <p>
 * Copyright 2018 Stalary.
 */
package interview;

/**
 * CountAndSay38
 * 统计数字的数量
 * @author lirongqian
 * @since 2018/08/05
 */
public class CountAndSay38 {

    public static void main(String[] args) {
        System.out.println(new CountAndSay38().countAndSay(5));
    }

    /**
     * 1.     1 1
     * 2.     11 1个1
     * 3.     21 2个1
     * 4.     1211 1个2，1个1
     * 5.     111221 1个1，1个2，2个1
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String cur = "1";
        //从1开始算
        int index = 1;
        while (index < n) {
            StringBuilder temp = new StringBuilder();
            // 统计重复数量
            int count = 1;
            for (int i = 1; i < cur.length(); i++) {
                if (cur.charAt(i) == cur.charAt(i - 1)) {
                    count++;
                } else {
                    // 不重复时添加数量和元素
                    temp.append(count).append(cur.charAt(i - 1));
                    count = 1;
                }
            }
            // 添加最后的数量和元素
            temp.append(count).append(cur.charAt(cur.length() - 1));
            cur = temp.toString();
            index++;
        }
        return cur;
    }
}