import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 17: Letter Combinations of a Phone Number
 * 
 * Problem: Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * 
 * Approach: Backtracking.
 * 
 * Time Complexity: O(4^n)
 * Space Complexity: O(n)
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, new StringBuilder(), result, mapping);
        return result;
    }
    
    private void backtrack(String digits, int index, StringBuilder current, List<String> result, String[] mapping) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(digits, index + 1, current, result, mapping);
            current.deleteCharAt(current.length() - 1);
        }
    }
    
    // Test method
    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();
        System.out.println("Result: " + solution.letterCombinations("23"));
        // Expected: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    }
}
