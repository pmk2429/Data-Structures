package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch {
  private static int M;
  private static int N;

  private static List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
      return result;
    }

    TrieNode root = buildTrie(words);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        recursiveFindWords(result, board, root, i, j);
      }
    }

    return result;
  }

  private static void recursiveFindWords(List<String> result, char[][] board, TrieNode parent, int x, int y) {
    if (outOfBounds(board, x, y) || board[x][y] == '#' || parent.children.get(board[x][y]) == null) {
      return; // return if out of bounds, if visited and if current cell is a character in the trie
    }

    char xy = board[x][y];
    TrieNode child = parent.children.get(xy);
    if (child.isEndOfWord) { // Found a word
      result.add(child.word);
      child.isEndOfWord = false; // Set to false to avoid adding word to result multiple times
      // Don't RETURN since child.word can be a prefix of other words, e.g., 'ane' and 'aneis'
    }

    board[x][y] = '#'; // '#' marks a cell as visited

    recursiveFindWords(result, board, child, x, y - 1); // left
    recursiveFindWords(result, board, child, x - 1, y); // up
    recursiveFindWords(result, board, child, x, y + 1); // right
    recursiveFindWords(result, board, child, x + 1, y); // down

    board[x][y] = xy; // Set as unvisited since we are about to backtracking
  }

  private static boolean outOfBounds(char[][] board, int x, int y) {
    return x < 0 || x >= board.length || y < 0 || y >= board[0].length;
  }

  // The trie is represented by a root node, not a Trie object
  private static TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      if (word == null || word.isEmpty()) {
        continue;
      }

      TrieNode parent = root;
      for (int i = 0; i < word.length(); i++) {
        char cur = word.charAt(i);

        TrieNode child = parent.children.get(cur);
        if (child == null) {
          child = new TrieNode();
          parent.children.put(cur, child);
        }

        parent = child;
      }

      parent.isEndOfWord = true;
      parent.word = word; // Store a word at the leaf node
    }

    return root;
  }

  private static class TrieNode {
    boolean isEndOfWord; // this.word is null if isEndOfWord is false
    String word; // Store the word so that no StringBuilder is needed to build the word char by char
    Map<Character, TrieNode> children;

    TrieNode() {
      this.children = new HashMap<>();
    }
  }

  public static void main(String[] args) {
    char[][] board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    };
    String[] words = {"oath", "pea", "eat", "rain"};

    M = board.length;
    N = board[0].length;

    System.out.println(findWords(board, words));

  }
}
