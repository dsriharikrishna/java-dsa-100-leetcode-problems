/**
 * LeetCode 208: Implement Trie (Prefix Tree)
 * 
 * Problem: Implement a trie with insert, search, and startsWith methods.
 * 
 * Approach: Tree structure where each node represents a character.
 * Each node has 26 children (for lowercase letters) and a boolean flag for word end.
 * 
 * Time Complexity: O(m) for all operations where m is key length
 * Space Complexity: O(n * m) where n is number of keys
 */
public class ImplementTrie {
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    
    private TrieNode root;
    
    public ImplementTrie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
    
    // Test method
    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println("Search 'apple': " + trie.search("apple"));   // true
        System.out.println("Search 'app': " + trie.search("app"));       // false
        System.out.println("StartsWith 'app': " + trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println("Search 'app': " + trie.search("app"));       // true
    }
}
