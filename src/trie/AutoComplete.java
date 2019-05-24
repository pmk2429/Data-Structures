package trie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AutoComplete {

  class TrieNode {
    char data;
    boolean isEnd;
    LinkedList<TrieNode> children;
    TrieNode parent;

    TrieNode(char c) {
      data = c;
      children = new LinkedList();
      isEnd = false;
    }

    TrieNode getChild(char c) {
      if (children != null) {
        TrieNode matchingNode = children.stream().filter(x -> x.data == c).findFirst().get();
        return matchingNode;
      }
      return null;
    }

    List<String> getWords() {
      List<String> list = new ArrayList<>();
      if (isEnd) {
        list.add(toString());
      }

      if (children != null) {
        for (TrieNode child : children) {
          if (child != null) {
            list.addAll(child.getWords());
          }
        }
      }
      return list;
    }

    public String toString() {
      if (parent == null) {
        return "";
      } else {
        return parent.toString() + new String(new char[]{data});
      }
    }
  }

  private TrieNode root;

  private AutoComplete() {
    root = new TrieNode(' ');
  }

  private void insert(String word) {
    if (search(word)) {
      return;
    }

    TrieNode current = root;
    TrieNode pre;
    for (char ch : word.toCharArray()) {
      pre = current;
      TrieNode child = current.getChild(ch);
      if (child != null) {
        current = child;
        child.parent = pre;
      } else {
        current.children.add(new TrieNode(ch));
        current = current.getChild(ch);
        current.parent = pre;
      }
    }
    current.isEnd = true;
  }

  private boolean search(String word) {
    TrieNode current = root;
    for (char ch : word.toCharArray()) {
      if (current.getChild(ch) == null)
        return false;
      else {
        current = current.getChild(ch);
      }
    }
    return current.isEnd;
  }

  private List<String> autocomplete(String prefix) {
    TrieNode lastNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      lastNode = lastNode.getChild(prefix.charAt(i));
      if (lastNode == null)
        return new ArrayList();
    }

    return lastNode.getWords();
  }


  public static void main(String[] args) {
    AutoComplete trie = new AutoComplete();
    trie.insert("analyse");
    trie.insert("boondock");
    trie.insert("extend");
    trie.insert("append");
    trie.insert("insert");
    trie.insert("remove");
    trie.insert("free");
    trie.insert("Free weblog publishing tool from Google, for sharing text, photos and vide");
    trie.insert("clear");
    trie.insert("blog");
    trie.insert("what is autocomplete");
    trie.insert("blog is your best bet for a voice among the online crowd");
    trie.insert("start a WordPress blog or create a free website in seconds");
    trie.insert("start");
    trie.insert("While we hope these tips are informative, we are unable to answer individua");
    trie.insert("while");
    trie.insert("base ment");
    trie.insert("amazon");
    trie.insert("amazon prime");
    trie.insert("amazing");
    trie.insert("amazing spider man");
    trie.insert("amazed");
    trie.insert("alibaba");
    trie.insert("ali express");
    trie.insert("ebay");
    trie.insert("walmart");

//    InputStreamReader in = new InputStreamReader(System.in);
//    BufferedReader br = new BufferedReader(in);
//    String line;
//    TrieNode location = null;
//    System.out.println("Enter your keywords::");

//    while (true) {
//      line = br.readLine();
//      if (line.equals("Y")) {
//        break;
//      }
//      location = trie.getLocationOfStringInTrie(line);
//      if (location != null) {
//        trie.autocomplete(location);
//      } else {
//        System.out.println("No Match found for [ " + line + " ] in our data base");
//      }
//    }

    List<String> autocompleteWords = trie.autocomplete("ama");
    for (String autocompleteWord : autocompleteWords) {
      System.out.println(autocompleteWord);
    }
  }
}
