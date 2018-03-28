/**
 * FloodFill733
 *
 * Input:
 image = [[1,1,1],[1,1,0],[1,0,1]]
 sr = 1, sc = 1, newColor = 2
 Output: [[2,2,2],[2,2,0],[2,0,1]]
 由于右上角的1没有能到与其相连的2，所以不能涂色
 * sr，sc为原点，newColor为修改后的像素，将与原点相连且数值相等的像素全部设为新像素，输出数组
 * @author lirongqian
 * @since 2018/03/27
 */
public class FloodFill733 {

    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };
        int[][] out = floodFill(image, 1, 1, 2);
        for (int[] o : out) {
            for (int oo : o) {
                System.out.print(oo + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        // 当当前点为1，并且不越界时，对其涂色
        image[sr][sc] = newColor;
        // 继续递归四个方向进行涂色
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
    }

}