package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch {
    private static int M;
    private static int N;

    private static boolean isNavigable(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    private static boolean isValid(char[][] board, int x, int y, TrieNode parent) {
        return board[x][y] != '#' && parent.children.get(board[x][y]) != null;
    }

    private static void findWordsDFS(char[][] board, TrieNode parent, int i, int j, List<String> result) {
        if (!isNavigable(i, j) || !isValid(board, i, j, parent)) {
            return; // return if out of bounds, if visited and if current cell is a character in the trie
        }

        char curr = board[i][j];
        TrieNode child = parent.children.get(curr);
        if (child.isEndOfWord) { // Found a word
            result.add(child.word);
            child.isEndOfWord = false; // Set too false to avoid adding word to result multiple times
            // Don't RETURN since child.word can be a prefix of other words, e.g., 'ane' and 'aneis'
        }

        board[i][j] = '\0'; // '\0' is null - marks the cell as visited

        findWordsDFS(board, child, i, j - 1, result); // left
        findWordsDFS(board, child, i - 1, j, result); // up
        findWordsDFS(board, child, i, j + 1, result); // right
        findWordsDFS(board, child, i + 1, j, result); // down

        board[i][j] = curr; // Set as unvisited since we are about to backtracking
    }

    // The trie is represented by a root node, not a Trie object
    private static class TrieNode {
        boolean isEndOfWord; // this word is null if isEndOfWord is false
        String word; // Store the word so that no StringBuilder is needed to build the word char by char
        Map<Character, TrieNode> children;

        TrieNode() {
            children = new HashMap<>();
        }
    }

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

    private static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }

        TrieNode root = buildTrie(words);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                findWordsDFS(board, root, i, j, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain", "nerv", "pmk"};

        M = board.length;
        N = board[0].length;

        System.out.println(findWords(board, words));
    }
}
