# OpenX Internship Project

## Implementing binary tree data structure

### 1. General information
The data structure presented in the description is a binary tree.
To build the representation of a binary tree in Java I used two classes:
```TreeNode``` representing single node in a tree and ```MyTree``` representing data structure itself.
```MyTree``` plays a role of a wrapper over data which is the assignment of nodes.

### 2. Number of leaves
The function to calculate the number of leaves in the tree is quite simple.
It performs in-order traversal of the tree, stopping when the node is null or both children of the node are null.
The time complexity of the solution is O(n), where n is the number of the nodes in the tree.

### 3. Longest path from the head to a leave
The function to calculate the maximum number of vertices in the path from the head to a leaf is similar to the previous example.
In each node it is decided which subtree (left, or right) has longer path to reach a leaf.
This is performed recursively down to meeting a leaf.
The time complexity of the solution is O(n), where n is the number of the nodes in the tree.

### 4. Checking for equality
This task is equivalent to implementing ```boolean equals(Object o)``` in the ```MyTree``` class.
To hold the contract of equals & hash-code, ```int hashCode()``` will also be overridden.
