import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 207: Course Schedule
 * 
 * Problem: There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
 * course bi first if you want to take course ai. Return true if you can finish all courses.
 * 
 * Approach: Topological sort with Kahn's algorithm.
 * 
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            
            for (int neighbor : graph.get(course)) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return count == numCourses;
    }
    
    // Test method
    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        int[][] prerequisites = {{1, 0}};
        System.out.println("Can finish: " + solution.canFinish(2, prerequisites)); // Expected: true
    }
}
