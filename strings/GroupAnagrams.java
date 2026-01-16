import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 49: Group Anagrams
 * 
 * Problem: Given an array of strings strs, group the anagrams together.
 * 
 * Approach: Sort each string and use it as a key in a HashMap.
 * 
 * Time Complexity: O(n * k log k) where n is number of strings and k is max length
 * Space Complexity: O(n * k)
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Sort the string to use as key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            // Add to the corresponding group
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    // Test method
    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Test 1: " + solution.groupAnagrams(strs));
        // Expected: [["bat"],["nat","tan"],["ate","eat","tea"]]
    }
}
