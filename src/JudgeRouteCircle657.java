
/**
 * JudgeRouteCircle657
 *
 * 判断能否回到原点
 * @author lirongqian
 * @since 2018/03/19
 */
public class JudgeRouteCircle657 {

    /**
     * 通过上下左右移动进行判断能否回到原点
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'L') {
                x--;
            } else if (c == 'R') {
                x++;
            }
        }
        return x == 0 && y == 0;
    }

}