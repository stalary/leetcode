import java.util.ArrayList;
import java.util.List;

/**
 * EncodeAndDecodeTinyURL535
 *
 * 实现编码解码，将长url转化为短url
 * @author lirongqian
 * @since 2018/03/13
 */
public class EncodeAndDecodeTinyURL535 {

    public static void main(String[] args) {
        EncodeAndDecodeTinyURL535 e = new EncodeAndDecodeTinyURL535();
        System.out.println(e.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(e.decode(e.encode("https://leetcode.com/problems/design-tinyurl")));
    }

    private String baseUrl = "http://tinyurl.com";

    List<String> urls = new ArrayList<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return baseUrl + String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl.replace(baseUrl, ""));
        return index < urls.size() ? urls.get(index).replace(baseUrl, "") : "";
    }
}