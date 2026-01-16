/**
 * LeetCode 211: Design Add and Search Words Data Structure
 * 
 * Problem: Design a data structure that supports adding words and searching with '.' wildcard.
 * 
 * Approach: Trie with DFS for wildcard matching.
 * 
 * Time Complexity: O(m) for addWord, O(26^m) worst case for search
 * Space Complexity: O(n * m)
 */
public class DesignAddAndSearchWords {
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        
        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    
    private TrieNode root;
    
    public DesignAddAndSearchWords() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        return searchInNode(word, 0, root);
    }
    
    private boolean searchInNode(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }
        
        char c = word.charAt(index);
        
        if (c == '.') {
            // Try all possible children
            for (TrieNode child : node.children) {
                if (child != null && searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int i = c - 'a';
            if (node.children[i] == null) {
                return false;
            }
            return searchInNode(word, index + 1, node.children[i]);
        }
    }
    
    // Test method
    public static void main(String[] args) {
        DesignAddAndSearchWords wordDictionary = new DesignAddAndSearchWords();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        
        System.out.println("Search 'pad': " + wordDictionary.search("pad")); // false
        System.out.println("Search 'bad': " + wordDictionary.search("bad")); // true
        System.out.println("Search '.ad': " + wordDictionary.search(".ad")); // true
        System.out.println("Search 'b..': " + wordDictionary.search("b..")); // true
    }
}
