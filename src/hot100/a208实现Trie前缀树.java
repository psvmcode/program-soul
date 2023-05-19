package hot100;

/**
 * @Author dongboy
 * @what time    2022/12/14 21:50
 */
public class a208实现Trie前缀树 {
    public static void main(String[] args) {

    }
}

class Trie {

    Trie[] children;
    boolean isWord;

    public Trie() {
        children = new Trie[26];
        isWord = false;
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new Trie();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
