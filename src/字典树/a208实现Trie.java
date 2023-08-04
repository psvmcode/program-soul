package 字典树;

/**
 * @Author dongboy
 * @what time    2022/12/12 11:32
 */
public class a208实现Trie {

}

class Trie {

    Trie[] children;

    boolean isWord;

    public Trie() {
        children = new Trie[26];
        isWord = false;
    }

    public void insert(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            if (root.children[word.charAt(i) - 'a'] == null) {
                root.children[word.charAt(i) - 'a'] = new Trie();
            }
            root = root.children[word.charAt(i) - 'a'];
        }
        root.isWord = true;
    }

    public boolean search(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            if (root.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            root = root.children[word.charAt(i) - 'a'];
        }
        return root.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (root.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            root = root.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }

}
