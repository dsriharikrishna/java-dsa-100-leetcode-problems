# 100 LeetCode DSA Problems - Java Solutions

A comprehensive collection of 100 carefully selected LeetCode Data Structures and Algorithms problems, organized by topic with complete Java implementations.

## 📚 Table of Contents

- [Overview](#overview)
- [Directory Structure](#directory-structure)
- [Topics Covered](#topics-covered)
- [How to Use](#how-to-use)
- [Compilation and Execution](#compilation-and-execution)
- [Problem List](#problem-list)
- [Key Features](#key-features)
- [Contributing](#contributing)

## 🎯 Overview

This repository contains **100 LeetCode problems** organized into 17 topic-based categories, covering all major DSA patterns. Each solution includes:

- ✅ Complete Java implementation
- ✅ Time and space complexity analysis
- ✅ Detailed approach explanation
- ✅ Test methods with example cases
- ✅ Clean, well-documented code

## 📁 Directory Structure

```
Java + DSA/
├── arrays/              # 10 Array problems
├── strings/             # 10 String problems
├── linkedlists/         # 8 Linked List problems
├── stacksandqueues/     # 6 Stack & Queue problems
├── binarysearch/        # 6 Binary Search problems
├── trees/               # 8 Tree problems
├── backtracking/        # 7 Backtracking problems
├── dynamicprogramming/  # 10 Dynamic Programming problems
├── graphs/              # 6 Graph problems
├── bitmanipulation/     # 4 Bit Manipulation problems
├── slidingwindow/       # 5 Sliding Window problems ✨
├── heap/                # 5 Heap/Priority Queue problems ✨
├── monotonicstack/      # 3 Monotonic Stack problems ✨
├── prefixsum/           # 3 Prefix Sum problems ✨
├── trie/                # 3 Trie problems ✨
├── unionfind/           # 3 Union-Find problems ✨
└── greedy/              # 3 Greedy problems ✨
```

## 📖 Topics Covered

### 1. Arrays (10 Problems)
Core array manipulation techniques including two-pointer, sliding window, and sorting algorithms.

### 2. Strings (10 Problems)
String processing, pattern matching, palindromes, and character manipulation.

### 3. Linked Lists (8 Problems)
Linked list traversal, reversal, cycle detection, and manipulation techniques.

### 4. Stacks and Queues (6 Problems)
Stack and queue implementations, monotonic stacks, and expression evaluation.

### 5. Binary Search (6 Problems)
Classic and modified binary search on arrays and matrices.

### 6. Trees (8 Problems)
Binary tree traversals, depth calculations, and tree property verification.

### 7. Recursion and Backtracking (7 Problems)
Combinatorial problems, permutations, subsets, and constraint satisfaction.

### 8. Dynamic Programming (10 Problems)
Classic DP patterns including knapsack, LCS, LIS, and grid-based problems.

### 9. Graphs (6 Problems)
Graph traversal (BFS/DFS), topological sort, and connectivity problems.

### 10. Bit Manipulation (4 Problems)
Bitwise operations and bit-level problem solving.

### 11. Sliding Window (5 Problems) ✨
Variable and fixed-size window techniques for substring and subarray problems.

### 12. Heap / Priority Queue (5 Problems) ✨
Min-heap and max-heap for Top K problems, median finding, and K-way merge.

### 13. Monotonic Stack (3 Problems) ✨
Stack-based techniques for next greater/smaller element and histogram problems.

### 14. Prefix Sum (3 Problems) ✨
Cumulative sum techniques for efficient range queries and subarray problems.

### 15. Trie (3 Problems) ✨
Prefix tree data structure for string prefix/suffix matching and word search.

### 16. Union-Find (3 Problems) ✨
Disjoint set union for connectivity problems and cycle detection.

### 17. Greedy (3 Problems) ✨
Greedy algorithms for optimization problems and interval scheduling.

## 🚀 How to Use

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Quick Start

1. **Clone or navigate to the repository:**
   ```bash
   cd "c:\Users\Lenovo\OneDrive\Documents\workspace\Java + DSA"
   ```

2. **Browse problems by topic:**
   ```bash
   cd arrays
   ```

3. **Open any problem file:**
   Each file is self-contained with the solution and test cases.

## 💻 Compilation and Execution

### Compile a Single File
```bash
javac arrays/TwoSum.java
```

### Run a Single Solution
```bash
java arrays.TwoSum
```

### Compile All Files in a Category
```bash
javac arrays/*.java
```

### Compile All Files
```bash
javac **/*.java
```

## 📋 Problem List

### Arrays
1. **Two Sum** (LC 1) - HashMap approach, O(n)
2. **Best Time to Buy and Sell Stock** (LC 121) - Single pass
3. **Merge Sorted Array** (LC 88) - Backward merging
4. **Contains Duplicate** (LC 217) - HashSet
5. **Product of Array Except Self** (LC 238) - O(1) space
6. **Maximum Subarray** (LC 53) - Kadane's algorithm
7. **3Sum** (LC 15) - Two-pointer
8. **Merge Intervals** (LC 56) - Sorting + merging
9. **Container With Most Water** (LC 11) - Two-pointer
10. **Rotate Image** (LC 48) - Transpose + reverse

### Strings
11. **Valid Parentheses** (LC 20) - Stack-based
12. **Valid Palindrome** (LC 125) - Two-pointer
13. **Valid Anagram** (LC 242) - Frequency counting
14. **Group Anagrams** (LC 49) - HashMap
15. **Longest Palindromic Substring** (LC 5) - DP
16. **Minimum Window Substring** (LC 76) - Sliding window
17. **Find Index of First Occurrence** (LC 28) - String matching
18. **String Compression** (LC 443) - In-place
19. **Longest Common Prefix** (LC 14) - Prefix reduction
20. **Repeated Substring Pattern** (LC 459) - Pattern detection

### Linked Lists
21. **Reverse Linked List** (LC 206) - Iterative
22. **Merge Two Sorted Lists** (LC 21) - Recursive
23. **Remove Nth Node From End** (LC 19) - Two-pointer
24. **Linked List Cycle** (LC 141) - Floyd's algorithm
25. **Add Two Numbers** (LC 2) - Carry handling
26. **Intersection of Two Linked Lists** (LC 160) - Two-pointer
27. **Palindrome Linked List** (LC 234) - Reverse + compare
28. **Reverse Nodes in k-Group** (LC 25) - Recursive

### Stacks and Queues
29. **Implement Queue Using Stacks** (LC 232)
30. **Implement Stack Using Queues** (LC 225)
31. **Min Stack** (LC 155) - O(1) min operation
32. **Daily Temperatures** (LC 739) - Monotonic stack
33. **Evaluate Reverse Polish Notation** (LC 150)
34. **Next Greater Element I** (LC 496)

### Binary Search
35. **Binary Search** (LC 704) - Classic
36. **Find First and Last Position** (LC 34)
37. **Search a 2D Matrix** (LC 74)
38. **Search in Rotated Sorted Array** (LC 33)
39. **Search in Rotated Sorted Array II** (LC 81)
40. **Find Peak Element** (LC 162)

### Trees
41. **Maximum Depth of Binary Tree** (LC 104)
42. **Same Tree** (LC 100)
43. **Symmetric Tree** (LC 101)
44. **Binary Tree Preorder Traversal** (LC 144)
45. **Binary Tree Inorder Traversal** (LC 94)
46. **Binary Tree Postorder Traversal** (LC 145)
47. **Binary Tree Level Order Traversal** (LC 102)
48. **Balanced Binary Tree** (LC 110)

### Recursion and Backtracking
49. **Combination Sum** (LC 39)
50. **Permutations** (LC 46)
51. **Subsets** (LC 78)
52. **N-Queens** (LC 51)
53. **Letter Combinations of Phone Number** (LC 17)
54. **Subsets II** (LC 90)
55. **Sudoku Solver** (LC 37)

### Dynamic Programming
56. **Climbing Stairs** (LC 70) - Fibonacci
57. **House Robber** (LC 198)
58. **Coin Change** (LC 322) - Unbounded knapsack
59. **Longest Increasing Subsequence** (LC 300)
60. **Longest Common Subsequence** (LC 1143)
61. **Unique Paths** (LC 62)
62. **Longest Palindromic Substring** (LC 5) - DP version
63. **Maximum Length of Repeated Subarray** (LC 718)
64. **Partition Equal Subset Sum** (LC 416)
65. **Maximum Subarray** (LC 53) - DP version

### Graphs
66. **Clone Graph** (LC 133) - BFS
67. **Number of Islands** (LC 200) - DFS
68. **Course Schedule** (LC 207) - Topological sort
69. **Is Graph Bipartite?** (LC 785) - Graph coloring
70. **Rotting Oranges** (LC 994) - Multi-source BFS
71. **Number of Connected Components** (LC 323)

### Bit Manipulation
72. **Single Number** (LC 136) - XOR
73. **Reverse Bits** (LC 190)
74. **Number of 1 Bits** (LC 191) - Hamming weight
75. **Missing Number** (LC 268) - XOR

### Sliding Window ✨
76. **Longest Substring Without Repeating Characters** (LC 3) - HashSet
77. **Minimum Size Subarray Sum** (LC 209) - Variable window
78. **Longest Repeating Character Replacement** (LC 424) - Frequency map
79. **Permutation in String** (LC 567) - Fixed window
80. **Find All Anagrams in a String** (LC 438) - Fixed window

### Heap / Priority Queue ✨
81. **Kth Largest Element in an Array** (LC 215) - Min-heap
82. **Top K Frequent Elements** (LC 347) - Heap + HashMap
83. **Merge k Sorted Lists** (LC 23) - K-way merge
84. **Find Median from Data Stream** (LC 295) - Two heaps
85. **K Closest Points to Origin** (LC 973) - Max-heap

### Monotonic Stack ✨
86. **Largest Rectangle in Histogram** (LC 84) - Increasing stack
87. **Trapping Rain Water** (LC 42) - Decreasing stack
88. **Next Greater Element II** (LC 503) - Circular array

### Prefix Sum ✨
89. **Subarray Sum Equals K** (LC 560) - HashMap
90. **Range Sum Query - Immutable** (LC 303) - Prefix array
91. **Contiguous Array** (LC 525) - 0s and 1s

### Trie ✨
92. **Implement Trie (Prefix Tree)** (LC 208) - Basic Trie
93. **Word Search II** (LC 212) - Trie + DFS
94. **Design Add and Search Words Data Structure** (LC 211) - Wildcard

### Union-Find ✨
95. **Number of Provinces** (LC 547) - Connected components
96. **Redundant Connection** (LC 684) - Cycle detection
97. **Longest Consecutive Sequence** (LC 128) - Grouping

### Greedy ✨
98. **Jump Game** (LC 55) - Reachability
99. **Jump Game II** (LC 45) - Minimum jumps
100. **Gas Station** (LC 134) - Circular tour

## ✨ Key Features

### Code Quality
- **Clean Code**: Well-structured, readable implementations
- **Comments**: Detailed explanations of approach and logic
- **Naming**: Descriptive variable and method names
- **Best Practices**: Following Java coding conventions

### Learning Resources
- **Complexity Analysis**: Time and space complexity for each solution
- **Multiple Approaches**: Some problems include alternative solutions
- **Test Cases**: Example inputs and expected outputs
- **Problem Descriptions**: Clear problem statements

### Organization
- **Topic-Based**: Easy to find problems by data structure/algorithm
- **Self-Contained**: Each file can be compiled and run independently
- **Consistent Structure**: Uniform format across all solutions

## 🤝 Contributing

This is a personal learning repository, but suggestions are welcome! If you find:
- Bugs or errors in solutions
- More efficient approaches
- Better explanations

Feel free to open an issue or submit a pull request.

## 📝 Notes

### C++ to Java Conversions
- `vector<T>` → `ArrayList<T>` or `T[]`
- `unordered_map<K,V>` → `HashMap<K,V>`
- `unordered_set<T>` → `HashSet<T>`
- `stack<T>` → `Stack<T>` or `Deque<T>`
- `queue<T>` → `Queue<T>` (LinkedList)
- `INT_MAX` → `Integer.MAX_VALUE`
- `isalnum()` → `Character.isLetterOrDigit()`
- `tolower()` → `Character.toLowerCase()`

### Testing
Each file includes a `main` method with test cases. Run individual files to see the solutions in action.

## 📊 Progress Tracker

- ✅ Arrays: 10/10
- ✅ Strings: 10/10
- ✅ Linked Lists: 8/8
- ✅ Stacks and Queues: 6/6
- ✅ Binary Search: 6/6
- ✅ Trees: 8/8
- ✅ Backtracking: 7/7
- ✅ Dynamic Programming: 10/10
- ✅ Graphs: 6/6
- ✅ Bit Manipulation: 4/4
- ✅ Sliding Window: 5/5 ✨
- ✅ Heap/Priority Queue: 5/5 ✨
- ✅ Monotonic Stack: 3/3 ✨
- ✅ Prefix Sum: 3/3 ✨
- ✅ Trie: 3/3 ✨
- ✅ Union-Find: 3/3 ✨
- ✅ Greedy: 3/3 ✨

**Total: 100/100 Complete** 🎉

## 📚 Resources

- [LeetCode](https://leetcode.com/) - Original problem source
- [Java Documentation](https://docs.oracle.com/en/java/) - Official Java docs
- [Big-O Cheat Sheet](https://www.bigocheatsheet.com/) - Complexity reference

## 📄 License

This repository is for educational purposes. All LeetCode problems are property of LeetCode.

---

**Happy Coding! 🚀**

*Last Updated: January 2026*
