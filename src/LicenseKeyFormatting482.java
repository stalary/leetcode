/**
 * LicenseKeyFormatting482
 * 输入一个字符串，其中包含数字和字母以及-，输入k将字符串分成每组k个，第一个组可能比k小的字符串，每组以-分割，并且所有字符转化为大写
 *
 * @author lirongqian
 * @since 2018/04/04
 */
public class LicenseKeyFormatting482 {

    public static void main(String[] args) {
        LicenseKeyFormatting482 l = new LicenseKeyFormatting482();
        String s = "5F3Z-2e-9-w";
        System.out.println(l.licenseKeyFormatting(s, 4));
    }

    /**
     * 首先从字符串末尾进行循环，当字符不为-添加到StringBuilder中，为-则不添加
     * 然后每次将sb的长度取模于k+1，就能找出需要添加-的位置
     * 最后再逆置函数，转化为大写
     * @param s
     * @param k
     * @return
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}