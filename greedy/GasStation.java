/**
 * LeetCode 134: Gas Station
 * 
 * Problem: There are n gas stations along a circular route. Given two arrays gas and cost,
 * return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Approach: Greedy - if total gas >= total cost, solution exists.
 * Find starting point where we never run out of gas.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentGas = 0;
        int startIndex = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];
            
            // If we can't reach next station from current start
            if (currentGas < 0) {
                startIndex = i + 1; // Try starting from next station
                currentGas = 0;
            }
        }
        
        // If total gas < total cost, impossible to complete circuit
        return totalGas >= totalCost ? startIndex : -1;
    }
    
    // Test method
    public static void main(String[] args) {
        GasStation solution = new GasStation();
        
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Test 1: " + solution.canCompleteCircuit(gas1, cost1)); // Expected: 3
        
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Test 2: " + solution.canCompleteCircuit(gas2, cost2)); // Expected: -1
    }
}
