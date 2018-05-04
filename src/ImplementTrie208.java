/**
 * ImplementTrie208
 * 实现前缀树
 *
 * @author lirongqian
 * @since 2018/05/04
 */
public class ImplementTrie208 {

    private TrieNode root;

    public ImplementTrie208() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode runner = root;
        // 从根开始插入
        for (char c : word.toCharArray()) {
            if (runner.children[c - 'a'] == null) {
                runner.children[c - 'a'] = new TrieNode();
            }
            runner = runner.children[c - 'a'];
        }
        runner.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode runner = root;
        for (char c : word.toCharArray()) {
            // 当未找到当前字符时，直接退出
            if (runner.children[c - 'a'] == null) {
                return false;
            } else {
                // 向后移动
                runner = runner.children[c - 'a'];
            }
        }
        // 全查找完时返回是否添加过
        return runner.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode runner = root;
        for (char c : prefix.toCharArray()) {
            if (runner.children[c - 'a'] == null) {
                return false;
            } else {
                runner = runner.children[c - 'a'];
            }
        }
        // 当全部查找完，即可直接返回true
        return true;
    }
}

class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children;

    // Initialize your data structure here.
    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}