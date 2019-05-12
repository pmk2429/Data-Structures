package trie;

public class WordDictionary {

  private class Trie {

    private class Node {
      private boolean isWordEnd;
      private Node[] next;

      Node() {
        this(false);
      }

      Node(boolean isWordEnd) {
        this.isWordEnd = isWordEnd;
        this.next = new Node[26];
      }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
      root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
      int wordLen = word.length();
      Node cur = root;
      for (int i = 0; i < wordLen; ++i) {
        char ch = word.charAt(i);
        if (cur.next[ch - 'a'] == null) {
          cur.next[ch - 'a'] = new Node();
        }
        cur = cur.next[ch - 'a'];
      }

      if (!cur.isWordEnd) {
        cur.isWordEnd = true;
      }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
      return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
      if (index == word.length()) {
        return node.isWordEnd;
      }

      char ch = word.charAt(index);
      index += 1;
      if (ch == '.') {
        for (int i = 0; i < 26; ++i) {
          if (node.next[i] == null) continue;
          boolean result = search(node.next[i], word, index);
          if (result) {
            return true;
          }
        }
        return false;
      } else {
        // current character matched ?
        boolean curIs = node.next[ch - 'a'] != null;
        return curIs && search(node.next[ch - 'a'], word, index);
      }
    }
  }

  private Trie trie;

  /**
   * Initialize your data structure here.
   */
  public WordDictionary() {
    trie = new Trie();
  }

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
    trie.insert(word);
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
   */
  public boolean search(String word) {
    return trie.search(word);
  }
}
