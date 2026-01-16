import java.util.Stack;

/**
 * LeetCode 739: Daily Temperatures
 * 
 * Problem: Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait 
 * after the ith day to get a warmer temperature.
 * 
 * Approach: Monotonic stack - store indices of temperatures.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        
        return res;
    }
    
    // Test method
    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        
        System.out.print("Result: ");
        for (int days : result) {
            System.out.print(days + " ");
        }
        System.out.println(); // Expected: 1 1 4 2 1 1 0 0
    }
}
